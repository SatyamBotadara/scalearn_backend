package com.scalearn.service;

import com.scalearn.dto.PlayListDto;
import com.scalearn.entity.Playlist;
import com.scalearn.exception.custom.ItemNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PlaylistService {
    Playlist insertPlaylist(Playlist playlist);

    List<PlayListDto> getAllPlaylist();

    Playlist getPlaylistById(String id) throws ItemNotFoundException;

    void deletePlaylistById(String id) throws ItemNotFoundException;

    Playlist updatePlaylist(Playlist playlist) throws ItemNotFoundException;
}
