package com.pai.pms.controller;

import com.pai.pms.logic.service.ApartmentService;
import com.pai.pms.model.dto.ApartmentReadModel;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class ApartmentController {
    private final ApartmentService service;

    public ApartmentController(ApartmentService service) {
        this.service = service;
    }

    @GetMapping
    @RequestMapping("/")
    ResponseEntity<List<ApartmentReadModel>> readAllApartments() {
        return ResponseEntity.ok(service.readAll());
    }

    @GetMapping
    @RequestMapping("/otherRoute")
    ResponseEntity<List<ApartmentReadModel>> readAllApartmentsInTimePeriod(@DateTimeFormat(pattern = "yyyy-MM-dd") @Param("from") LocalDate from,
                                                                           @DateTimeFormat(pattern = "yyyy-MM-dd") @Param("to") LocalDate to) {
        return ResponseEntity.ok(service.readAllInCertainTimePeriod(from, to));
    }
}
