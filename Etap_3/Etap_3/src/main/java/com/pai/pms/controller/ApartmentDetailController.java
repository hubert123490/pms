package com.pai.pms.controller;

import com.pai.pms.logic.service.ApartmentDetailService;
import com.pai.pms.model.dto.ApartmentDetailReadModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApartmentDetailController {
    private final ApartmentDetailService service;
    Logger logger = LoggerFactory.getLogger(ApartmentController.class);

    public ApartmentDetailController(ApartmentDetailService service) {
        this.service = service;
    }

    @GetMapping
    @RequestMapping("/apartments/read/{id}")
    ResponseEntity<ApartmentDetailReadModel> readApartmentDetails(@PathVariable int id){
        try {
            logger.info("reading apartment with id: " + id);
            return ResponseEntity.ok(service.readApartmentDetails(id));
        }catch (NullPointerException e){
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }


}
