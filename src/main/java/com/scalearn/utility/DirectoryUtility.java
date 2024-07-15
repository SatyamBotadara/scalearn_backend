package com.scalearn.utility;

import com.scalearn.dto.BasePathEnum;
import com.scalearn.exception.custom.CustomException;
import com.scalearn.exception.custom.DuplicateIdException;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
@Log4j2
public class DirectoryUtility {

    public String createDirectory(String id,BasePathEnum basePathEnum) {
        // getting basepath from enum
        String basePath = basePathEnum.getPath();
        // get base path from properties file
         var dirPath = basePath+"/"+id;
         File dir = new File(dirPath);
         if(dir.exists() || dir.isDirectory()) {
             log.error("Directory already present with same id "+id+" and it try to recreate");
             throw new DuplicateIdException("Directory already created with id: "+id+" ,please contact admin");
         }
         log.info("Creating dir at "+dirPath);
         if(dir.mkdirs()) {
             log.info("dir is created");
             return dir.getAbsolutePath();
         }
         log.error("Unable to create directory path at "+dir.getAbsolutePath());
         throw new CustomException("Unable to create directory please contact Admin");
    }
    
    public void deleteDirectory(String id,BasePathEnum basePathEnum) {
        // getting basepath from enum
        String basePath = basePathEnum.getPath();

        var videoDirPath = basePath+"/"+id;
        File videoDir = new File(videoDirPath);

        if(videoDir.exists()){
           if(videoDir.delete()) {
             log.info("Dir deleted with id : "+id);
           }
        } else {
            log.error("Dir not exists with id : "+id);
        }
    }
}