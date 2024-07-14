package com.scalearn.dto;

import com.scalearn.entity.Video;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VideoDto {
    private String id;
    private String title;
    private String duration;
    private String imageUrl;
    private Boolean isPremium;

    public  VideoDto(Video video) {
        this.id = video.getId();
        this.title = video.getTitle();
        this.duration = video.getDuration();
        this.imageUrl = video.getDataDir();
        this.isPremium = video.getIsPremium();
    }
}
