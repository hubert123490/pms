package com.pai.pms.controller;

import com.pai.pms.logic.service.ApartmentService;
import com.pai.pms.model.dto.ApartmentReadModel;
import com.pai.pms.security.services.UserDetailsImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

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

    @GetMapping
    @RequestMapping("/period")
    ResponseEntity<List<ApartmentReadModel>> readAllApartmentsInTimePeriod(@DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam("from") LocalDate from,
                                                                           @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam("to") LocalDate to) {
        return ResponseEntity.ok(service.readAllInCertainTimePeriod(from, to));
    }

}
