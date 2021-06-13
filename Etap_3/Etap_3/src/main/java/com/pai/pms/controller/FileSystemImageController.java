package com.pai.pms.controller;

import com.pai.pms.logic.service.BindImageService;
import com.pai.pms.logic.service.FileLocationService;
import com.pai.pms.payload.request.BindImageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("file-system")
class FileSystemImageController {

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
            return bindImageService.bindImageToApartment(bindImageRequest);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
