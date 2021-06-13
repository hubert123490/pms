package com.pai.pms.controller;

import com.pai.pms.logic.service.BindImageService;
import com.pai.pms.logic.service.FileLocationService;
import com.pai.pms.payload.request.BindImageRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("file-system")
class FileSystemImageController {
    Logger logger = LoggerFactory.getLogger(FileSystemImageController.class);

    @Autowired
    FileLocationService fileLocationService;
    @Autowired
    BindImageService bindImageService;

    @PostMapping("/image")
    public Long uploadImage(@RequestParam MultipartFile image) throws Exception {
        return fileLocationService.save(image.getBytes(), image.getOriginalFilename());
    }

    @GetMapping(value = "/image/{imageId}", produces = MediaType.IMAGE_PNG_VALUE)
    public FileSystemResource downloadImage(@PathVariable Long imageId) throws Exception {
        return fileLocationService.find(imageId);
    }

    @PostMapping(value = "/image/bind_image")
    public boolean bindImage(@RequestBody BindImageRequest bindImageRequest){
        try {
            logger.info("Binding img success");
            return bindImageService.bindImageToApartment(bindImageRequest);
        }catch (Exception e){
            logger.error("Binding img failed");
            e.printStackTrace();
            return false;
        }
    }
}
