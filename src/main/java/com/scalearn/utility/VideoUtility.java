package com.scalearn.utility;

import com.scalearn.exception.custom.CustomException;
import com.scalearn.exception.custom.DuplicateIdException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
@Log4j2
public class VideoUtility {

    @Value("${application.data.basePath}")
    private String basePath;

    public String createVideoDirectory(String videoId) {
        // get base path from properties file
         var videoDirPath = basePath+"/"+videoId;
         File videoDir = new File(videoDirPath);
         if(videoDir.exists() || videoDir.isDirectory()) {
             log.error("Video directory already present with same id "+videoId+" and it try to recreate");
             throw new DuplicateIdException("Video Directory already created with id: "+videoId+" ,please contact admin");
         }
         if(videoDir.mkdirs()) {
             return videoDir.getAbsolutePath();
         }
         log.error("Unable to create directory path at "+videoDir.getAbsolutePath());
         throw new CustomException("Unable to create video directory please contact Admin");
    }
    
    public void deleteVideoDirectory(String videoId) {
        var videoDirPath = basePath+"/"+videoId;
        File videoDir = new File(videoDirPath);

        if(videoDir.exists()){
           if(videoDir.delete()) {
             log.info("Video dir deleted with id : "+videoId);
           }
        } else {
            log.error("Video dir not exists with id : "+videoId);
        }
    }
}
