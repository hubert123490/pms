package com.pai.pms.controller;

import com.pai.pms.logic.service.LandlordApartmentsService;
import com.pai.pms.model.dto.ApartmentDetailReadModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class LandlordApartmentsController {
    private final LandlordApartmentsService service;
    Logger logger = LoggerFactory.getLogger(AddOpinionController.class);

    public LandlordApartmentsController(LandlordApartmentsService service) {
        this.service = service;
    }

    @GetMapping
    @RequestMapping("/landlord/apartments")
    ResponseEntity<List<ApartmentDetailReadModel>> readLandlordApartments() {
        try {
            logger.info("Reading landlord apartments");
            return ResponseEntity.ok(service.readLandlordApartments());
        }catch (Exception e){
            logger.error(e.getMessage());
            return ResponseEntity.status(500).build();
        }
    }
}
