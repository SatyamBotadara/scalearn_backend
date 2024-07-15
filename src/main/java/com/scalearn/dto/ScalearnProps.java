package com.scalearn.dto;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class ScalearnProps {
    static Properties prop = new Properties();

    static {
        InputStream inputStream = ScalearnProps.class.getClassLoader().getResourceAsStream("application.properties");
        try {
            prop.load(inputStream);
        } catch(IOException ioException) {
            log.error("error while loading application.properties file {}",ioException);     
        }
    }
    
    public static class BasePathDto {
        public static final String basePath = prop.getProperty("application.data.basePath");
    }
}