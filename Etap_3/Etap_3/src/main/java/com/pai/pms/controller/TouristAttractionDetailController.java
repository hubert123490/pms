package com.pai.pms.controller;

import com.pai.pms.logic.service.TouristAttractionDetailService;
import com.pai.pms.model.dto.TouristAttractionDetailReadModel;
import com.pai.pms.model.entities.TouristAttraction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TouristAttractionDetailController {
    private final TouristAttractionDetailService service;
    Logger logger = LoggerFactory.getLogger(TouristAttractionController.class);

    public TouristAttractionDetailController(TouristAttractionDetailService service) {
        this.service = service;
    }

    @GetMapping
    @RequestMapping("/tourist_attraction/{id}")
    ResponseEntity<TouristAttractionDetailReadModel> readTouristAttractionDetails(@PathVariable int id){
        try {
            logger.info("reading tourist_attraction with id: " + id);
            return ResponseEntity.ok(service.readTouristAttractionDetails(id));
        }catch (NullPointerException e){
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }


}
