package com.scalearn.service;

import com.scalearn.dto.VideoDto;
import com.scalearn.entity.Video;
import com.scalearn.exception.custom.DuplicateIdException;
import com.scalearn.exception.custom.ItemNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VideoService {
    Video insertVideo(Video video,String playlistId) throws DuplicateIdException;
    void deleteVideoById(String id) throws ItemNotFoundException;
    Video updateVideo(Video video);
    List<VideoDto> getVideoList(String playlistId);
    Video getVideoById(String id);
}