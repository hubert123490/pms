package com.pai.pms.logic.service;

import com.pai.pms.model.entities.Image;
import com.pai.pms.model.repository.FileSystemRepository;
import com.pai.pms.model.repository.ImageDbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class FileLocationService {

    @Autowired
    FileSystemRepository fileSystemRepository;
    @Autowired
    ImageDbRepository imageDbRepository;

    public Long save(byte[] bytes, String imageName) throws Exception {
        String location = fileSystemRepository.save(bytes, imageName);
        Image image = new Image();
        image.setName(imageName);
        image.setLocation(location);

        return imageDbRepository.save(image).getId();
    }

    public FileSystemResource find(Long imageId) {
        Image image = imageDbRepository.findById(imageId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        return fileSystemRepository.findInFileSystem(image.getLocation());
    }

}