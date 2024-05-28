package com.example.jpa.book.helper;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Component
public class UploadHelper {

    public final String PATH="C:\\Users\\Win 11\\Desktop\\Spring_boot\\book\\src\\main\\resources\\static";
    public boolean upload(MultipartFile file){

        boolean f=false;

        try {
            Files.copy(file.getInputStream(), Paths.get(PATH+File.separator+file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
            f=true;
        }catch (Exception e){
            e.printStackTrace();

        }

        return f;
    }
}
