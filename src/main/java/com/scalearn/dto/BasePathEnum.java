package com.scalearn.dto;

import lombok.extern.log4j.Log4j2;

@Log4j2
public enum BasePathEnum {
    VIDEO("/video"),PLAYLIST("/playlist");

    private final String basePath = ScalearnProps.BasePathDto.basePath;

    private String path;

    BasePathEnum(String endPoint) {
        this.path = this.basePath+endPoint;
    }
    public String getPath() {
        log.info("basepath "+basePath);
        return path;
    }
}