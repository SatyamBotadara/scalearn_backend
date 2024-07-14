package com.scalearn.controllers;

import com.scalearn.dto.Response;
import com.scalearn.dto.VideoDto;
import com.scalearn.entity.Video;
import com.scalearn.service.VideoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/video")
@AllArgsConstructor
public class VideoController {

    private final VideoService videoService;

    @PostMapping
    public ResponseEntity<Response> insertVideo(@RequestBody @Valid  Video video,
                                                @RequestParam("playlistId") String playlistId) {
        var videoRes = videoService.insertVideo(video,playlistId);
        var response = new Response(videoRes,HttpStatus.CREATED,"CREATED!");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/id")
    public ResponseEntity<Response> getVideoById(@RequestParam("id") String id) {
        var video = videoService.getVideoById(id);
        var response = new Response(video,HttpStatus.OK,"SUCCESS");
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Response> getAllVideoByPlaylistId(@RequestParam("playlistId") String playlistId) {
        List<VideoDto> videoDtoList = videoService.getVideoList(playlistId);
        var response = new Response(videoDtoList,HttpStatus.OK,"SUCCESS");
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Response> updateVideo(@RequestBody @Valid Video video) {
        // update video details
        var updatedVideo = videoService.updateVideo(video);
        var response = new Response(updatedVideo,HttpStatus.OK,"UPDATED!");
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Response> deleteVideo(@RequestParam("id") String id) {
        videoService.deleteVideoById(id);
        var response = new Response(HttpStatus.OK,"DELETED!");
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
