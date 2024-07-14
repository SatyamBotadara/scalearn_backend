package com.scalearn.repository;

import com.scalearn.dto.VideoDto;
import com.scalearn.entity.Video;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface VideoRepository extends MongoRepository<Video,String> {
    @Query(value = "{}",fields = "{'id':1,'title':1,'duration':1,'imageUrl':1 ,'isPremium':1}")
    List<VideoDto> findListOfVideoByPlaylist();
}
