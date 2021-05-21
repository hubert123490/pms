package com.pai.pms.controller;

import com.pai.pms.logic.service.ApartmentService;
import com.pai.pms.model.dto.ApartmentReadModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
public class ApartmentController {
    private final ApartmentService service;
    Logger logger = LoggerFactory.getLogger(ApartmentController.class);

    public ApartmentController(ApartmentService service) {
        this.service = service;
    }

    @GetMapping
    @RequestMapping("/")
    ResponseEntity<List<ApartmentReadModel>> readAllApartments() {
        return ResponseEntity.ok(service.readAll());
    }


}
