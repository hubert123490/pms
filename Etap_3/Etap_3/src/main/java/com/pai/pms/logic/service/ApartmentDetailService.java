package com.pai.pms.logic.service;

import com.pai.pms.model.dto.ApartmentDetailReadModel;
import com.pai.pms.model.dto.ApartmentReadModel;
import com.pai.pms.model.entities.Apartment;
import com.pai.pms.model.repository.ApartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ApartmentDetailService {
    Logger logger = LoggerFactory.getLogger(ApartmentDetailService.class);
    private final ApartmentRepository repository;

    public ApartmentDetailService(ApartmentRepository repository) {
        this.repository = repository;
    }

    public ApartmentDetailReadModel readApartmentDetails(int apartmentId){
        Apartment apartment =  repository.findById(apartmentId).orElse(null);
        if(apartment != null){
            return new ApartmentDetailReadModel(apartment);
        }
        throw new NullPointerException("ApartmentDetailService - returned value from repository is null");
    }
}
