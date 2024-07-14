package com.scalearn.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Playlist {
    @Id
    private String id;

    @NotBlank(message = "Playlist title is required")
    private String title;

    @NotBlank(message = "Playlist description is required")
    private String desc;

    @NotBlank(message = "Playlist duration is required")
    private String duration;

    @NotBlank(message = "Playlist author is required")
    private String author;

    // playlist thumbnail
    @NotBlank(message = "Playlist thumbnail image is required")
    private String imageUrl;

    @NotBlank(message = "Playlist price is required")
    private String price;

    // playlist category
    @NotBlank(message = "Playlist type is required")
    private String playlistType;

    @NotNull(message = "Please fill details of whether playlist is premium or not")
    private Boolean isPremium;

    // list of video contain in playlist
    @DBRef
    private List<Video> videoList;
}