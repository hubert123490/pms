package com.pai.pms.logic.service;

import com.pai.pms.model.dto.ApartmentDetailReadModel;
import com.pai.pms.model.dto.TouristAttractionDetailReadModel;
import com.pai.pms.model.entities.Apartment;
import com.pai.pms.model.entities.TouristAttraction;
import com.pai.pms.model.repository.ApartmentRepository;
import com.pai.pms.model.repository.TouristAttractionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TouristAttractionDetailService {
    Logger logger = LoggerFactory.getLogger(TouristAttractionDetailService.class);
    private final TouristAttractionRepository repository;

    public TouristAttractionDetailService(TouristAttractionRepository repository) {
        this.repository = repository;
    }

    public TouristAttractionDetailReadModel readTouristAttractionDetails(int touristAttractionId){
        TouristAttraction touristAttraction =  repository.findById(touristAttractionId).orElse(null);
        if(touristAttraction != null){
            logger.info("Reading tourist attraction details");
            return new TouristAttractionDetailReadModel(touristAttraction);
        }
        throw new NullPointerException("TouristAttractionDetailService - returned value from repository is null");
    }
}
