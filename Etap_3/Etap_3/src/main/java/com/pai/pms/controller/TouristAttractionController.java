package com.pai.pms.controller;

import com.pai.pms.logic.service.ApartmentService;
import com.pai.pms.logic.service.TouristAttractionService;
import com.pai.pms.model.dto.ApartmentReadModel;
import com.pai.pms.model.dto.TouristAttractionReadModel;
import com.pai.pms.model.entities.TouristAttraction;
import com.pai.pms.model.repository.TouristAttractionRepository;
import com.pai.pms.payload.request.AddApartmentRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class TouristAttractionController {
//    private static final Logger logger = LoggerFactory.getLogger(TouristAttractionController.class);
//    private final TouristAttractionRepository repository;
//    public TouristAttractionController(TouristAttractionRepository repository) {
//        this.repository = repository;
//    }
//
//    @GetMapping
//    @RequestMapping("/tourist_attraction")
//    ResponseEntity<List<TouristAttraction>> readAllTouristAttraction() {
//        logger.warn("Exposing all the tourist_attractions!");
//        List<TouristAttraction> test = repository.findAll();
//        return ResponseEntity.ok(test);
//    }
@Autowired
private final TouristAttractionService service;
    Logger logger = LoggerFactory.getLogger(TouristAttractionController.class);

    public TouristAttractionController(TouristAttractionService service) {
        this.service = service;
    }

    @GetMapping
    @RequestMapping("/tourist_attraction")
    ResponseEntity<List<TouristAttractionReadModel>> readAllTouristAttraction() {
        return ResponseEntity.ok(service.readAll());
    }

}