package com.scalearn.service.impl;

import com.scalearn.dto.VideoDto;
import com.scalearn.entity.Video;
import com.scalearn.exception.custom.DuplicateIdException;
import com.scalearn.exception.custom.ItemNotFoundException;
import com.scalearn.repository.PlaylistRepo;
import com.scalearn.repository.VideoRepository;
import com.scalearn.service.VideoService;
import com.scalearn.utility.VideoUtility;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Log4j2
@Service
public class VideoServiceImpl implements VideoService {

    private final VideoRepository videoRepository;

    private final PlaylistRepo playlistRepo;

    private final VideoUtility videoUtility;

    @Override
    public Video insertVideo(Video video,String playlistId) throws DuplicateIdException {
        var id = UUID.randomUUID().toString();
        video.setId(id);

        // check if generated id is not duplicating with existing id
        if( videoRepository.findById(video.getId()).isPresent() ) {
            log.error("Duplicate video id");
            log.error("Video id -> {} is already present in database",id);
            throw new DuplicateIdException("Video id already present");
        }

        // update playlist object and add video into list
        log.info("Video object is created");
        log.info("Inserting video into playlist's video collection");

        // find playlist using playlist id
        var playlist = playlistRepo.findById(playlistId).orElseThrow(()->
                new ItemNotFoundException("Playlist of id : "+ playlistId +" not found in database" +
                        ", Please Enter valid playlist Id"));

        // updating playlist object and add newly created video into existing list of video
        var list = playlist.getVideoList() == null ? new ArrayList<Video>()  : playlist.getVideoList();

        // adding image path
        // create directory for video using video uuid
        var videoDataDir = videoUtility.createVideoDirectory(id);
        video.setDataDir(videoDataDir);

        list.add(video);
        playlist.setVideoList(list);
        playlistRepo.save(playlist);
        // save video in database        
        return videoRepository.save(video);
    }

    // delete video by id
    @Override
    public void deleteVideoById(String id) throws ItemNotFoundException {
        var video = videoRepository.findById(id);
        if( video.isEmpty() ) {
            log.error("Video not found of it -> {} in database",id);
            throw new ItemNotFoundException("Video not found of id "+id);
        }
        videoRepository.delete(video.get());
        videoUtility.deleteVideoDirectory(video.get().getId());
    } 

    // update video
    @Override
    public Video updateVideo(Video video) {
        // fetch video details from db
        var dbVideo = videoRepository.findById(video.getId()).orElseThrow(()->
                new ItemNotFoundException("Video not found of id: "+video.getId()));
        // update video details
        dbVideo.setDesc(video.getDesc());
        dbVideo.setLearning(video.getLearning());
        dbVideo.setDetails(video.getDetails());
        dbVideo.setTitle(video.getTitle());
        dbVideo.setAuthor(video.getAuthor());
        dbVideo.setDuration(video.getDuration());

        return videoRepository.save(dbVideo);
    }

    // get video list only container necessary details
    @Override
    public List<VideoDto> getVideoList(String playlistId) {
        var playlist = playlistRepo.findById(playlistId).orElseThrow(()->
                new ItemNotFoundException("Playlist Not Found of id : "+playlistId));
        var list = playlist.getVideoList();

        if( list == null || list.isEmpty())
            throw new ItemNotFoundException("Video not found in playlist id " + playlistId);
        // TODO: add video base 64 image
        return list.stream().map(VideoDto::new).toList();
    }

    // get video by id
    @Override
    public Video getVideoById(String id) {
        return videoRepository.findById(id).orElseThrow( () ->
                new ItemNotFoundException("Video not found of id : "+id));
    }
}