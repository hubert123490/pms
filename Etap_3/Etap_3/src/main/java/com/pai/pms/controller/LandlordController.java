package com.pai.pms.controller;
import com.pai.pms.logic.service.LandlordService;
import com.pai.pms.model.dto.LandlordReadModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
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
    @RequestMapping("/landlords")
    ResponseEntity<List<LandlordReadModel>> readAllLandlords() {
        return ResponseEntity.ok(service.readAll());
    }
}