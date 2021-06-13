package com.pai.pms.logic.service;

import com.pai.pms.model.entities.Apartment;
import com.pai.pms.model.entities.Image;
import com.pai.pms.model.repository.ApartmentRepository;
import com.pai.pms.model.repository.ImageDbRepository;
import com.pai.pms.payload.request.BindImageRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class BindImageService {
    Logger logger = LoggerFactory.getLogger(BindImageService.class);
    private final ImageDbRepository imageDbRepository;
    private final ApartmentRepository apartmentRepository;

    public BindImageService(ImageDbRepository imageDbRepository, ApartmentRepository apartmentRepository) {
        this.imageDbRepository = imageDbRepository;
        this.apartmentRepository = apartmentRepository;
    }

    @Transactional
    public Boolean bindImageToApartment(BindImageRequest bindImageRequest){
        Apartment apartment = apartmentRepository.findById(bindImageRequest.getApartmentId()).orElseThrow();
        Image image = imageDbRepository.findById(bindImageRequest.getImageId()).orElseThrow();

        apartment.getImages().add(image);
        image.setApartment(apartment);
        apartmentRepository.save(apartment);
        imageDbRepository.save(image);
        return true;
    }
}
