package com.pai.pms.controller;

import com.pai.pms.logic.service.ApartmentDetailService;
import com.pai.pms.logic.service.BoughtApartmentDetailService;
import com.pai.pms.model.dto.ApartmentDetailReadModel;
import com.pai.pms.model.dto.BoughtApartmentDetailReadModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
public class BoughtApartmentDetailController {
    private final BoughtApartmentDetailService service;
    Logger logger = LoggerFactory.getLogger(BoughtApartmentDetailController.class);

    public BoughtApartmentDetailController(BoughtApartmentDetailService service) {
        this.service = service;
    }

    @RequestMapping(value = "/apartments/bought/read/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasRole('CLIENT')")
    ResponseEntity<BoughtApartmentDetailReadModel> readBoughtApartmentDetail(@PathVariable int id){
        try {
            logger.info("reading bought apartment with id: " + id);
            return ResponseEntity.ok(service.readBoughtApartmentDetail(id));
        }catch (NullPointerException | IllegalAccessException e){
            return ResponseEntity.notFound().build();
        }
    }
}
