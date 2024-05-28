package com.example.jpa.book.controllers;

import com.example.jpa.book.helper.UploadHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUploaderController {

    @Autowired
    UploadHelper uploadHelper;

    @PostMapping("/upload-file")
    public ResponseEntity<String> fileUploder(@RequestParam("File")MultipartFile file){
        try {
            if (file.isEmpty()) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File is empty !");
            }

            if (!file.getContentType().equals("image/png")) {
                return ResponseEntity.internalServerError().body("Only PNG content typle are allowed");
            }

//            file upload code
            boolean f =uploadHelper.upload(file);
            if(f)
                return ResponseEntity.ok("File uploded successfully !");

        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.internalServerError().body("Somthing went wrong !! Try again !!");

    }
}
