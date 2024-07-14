package com.scalearn.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Video {
    @Id
    private String id;

    @NotBlank(message = "Please Enter Video title ")
    private String title;

    @NotBlank(message = "Please Enter Video Description")
    private String desc;

    @NotBlank(message = "Please Enter Video Duration")
    private String duration;

    @NotBlank(message = "Please Enter Video Author")
    private String author;

    // video data url
    private String dataDir;

    // description about video
    @NotBlank(message = "Please Enter Video Details")
    private String details;

    // learning outcome of video
    @NotBlank(message = "Please Enter Video Learning")
    private String learning;

    @NotNull(message = "Please fill details of whether video is premium or not")
    private Boolean isPremium;
}