package com.pai.pms.controller;

import com.pai.pms.model.entities.TouristAttraction;
import com.pai.pms.model.repository.TouristAttractionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TouristAttractionController {
    private static final Logger logger = LoggerFactory.getLogger(TouristAttractionController.class);
    private final TouristAttractionRepository repository;
    public TouristAttractionController(TouristAttractionRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    @RequestMapping("/tourist_attraction")
    ResponseEntity<List<TouristAttraction>> readAllTouristAttraction() {
        logger.warn("Exposing all the tourist_attractions!");
        List<TouristAttraction> test = repository.findAll();
        return ResponseEntity.ok(test);
    }
}