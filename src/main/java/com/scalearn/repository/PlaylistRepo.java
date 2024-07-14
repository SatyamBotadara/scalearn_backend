package com.scalearn.repository;

import com.scalearn.dto.PlayListDto;
import com.scalearn.entity.Playlist;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PlaylistRepo extends MongoRepository<Playlist,String> {
    @Query(value = "{}",fields = "{'id':1,'title':1,'duration':1,'imageUrl':1 ,'playlistType':1 ,'isPremium':1}")
    List<PlayListDto> findListOfPlaylist();
}