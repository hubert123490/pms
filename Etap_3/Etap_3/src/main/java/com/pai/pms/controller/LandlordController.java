package com.pai.pms.controller;
import com.pai.pms.logic.service.LandlordService;
import com.pai.pms.model.dto.LandlordClientReadModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LandlordController {

    private final LandlordService service;
    Logger logger = LoggerFactory.getLogger(LandlordController.class);

    public LandlordController(LandlordService service) {
        this.service = service;
    }

    @GetMapping
    @PreAuthorize("hasRole('LANDLORD')")
    @RequestMapping("/landlords")
    ResponseEntity<List<LandlordClientReadModel>> readAllLandlords() {
        return ResponseEntity.ok(service.readAllClients());
    }
}