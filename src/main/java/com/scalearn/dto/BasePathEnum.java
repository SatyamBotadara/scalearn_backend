package com.scalearn.dto;
import org.springframework.beans.factory.annotation.Value;

public enum BasePathEnum {
    VIDEO("/video"),PLAYLIST("/playlist");

    @Value("${application.data.basePath}")
    private String basePath;

    private String path;

    BasePathEnum(String endPoint) {
        this.path = this.basePath+endPoint;
    }
    public String getPath() {
        return path;
    }
}