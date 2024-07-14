package com.scalearn.controllers;

import com.scalearn.dto.Response;
import com.scalearn.entity.Playlist;
import com.scalearn.exception.custom.ItemNotFoundException;
import com.scalearn.service.PlaylistService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/playlist")
public class PlaylistController {

    private final PlaylistService playlistService;

    @PostMapping
    public ResponseEntity<Response> insertPlaylist(@RequestBody @Valid Playlist playlist) {
        var playlistData  = playlistService.insertPlaylist(playlist);
        var response = new Response(playlistData,HttpStatus.CREATED,"Playlist inserted");
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Response> getAllPlaylist() {
        var list = playlistService.getAllPlaylist();
        var response = new Response(list,HttpStatus.OK,"SUCCESS");
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/id")
    public ResponseEntity<Response> getPlaylistById(@RequestParam("id") String id) throws ItemNotFoundException {
        var playlist = playlistService.getPlaylistById(id);
        var response = new Response(playlist,HttpStatus.OK,"SUCCESS");
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Response> deletePlaylist(@RequestParam("id") String id) {
        playlistService.deletePlaylistById(id);
        var response = new Response(HttpStatus.OK,"Playlist Deleted!");
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Response> updatePlaylist(@RequestBody @Valid Playlist playlist) {
        var playlistRes = playlistService.updatePlaylist(playlist);
        var response = new Response(playlistRes,HttpStatus.OK,"UPDATED!");
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}