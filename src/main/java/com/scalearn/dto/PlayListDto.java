package com.scalearn.dto;

import com.scalearn.entity.Playlist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayListDto {
    private String id;
    private String title;
    private String duration;
    // playlist thumbnail
    private String imageUrl;
    // playlist category
    private String playlistType;
    private boolean isPremium;

    public PlayListDto(Playlist playlist) {
        this.id = playlist.getId();
        this.title = playlist.getTitle();
        this.duration = playlist.getDuration();
        this.imageUrl = playlist.getDirPath();
        this.playlistType = playlist.getPlaylistType();
        this.isPremium = playlist.getIsPremium();
    }
}
