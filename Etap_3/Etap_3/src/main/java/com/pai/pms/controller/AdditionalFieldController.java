package com.pai.pms.controller;

import com.pai.pms.model.entities.AdditionalField;
import com.pai.pms.model.repository.AdditionalFieldsRepository;
import com.pai.pms.model.repository.TouristAttractionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.net.URI;

public class AdditionalFieldController {
    private static final Logger logger = LoggerFactory.getLogger(AdditionalFieldController.class);
    private final AdditionalFieldsRepository repository;
    public AdditionalFieldController(AdditionalFieldsRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/additionalFields")
    ResponseEntity<AdditionalField> createAdditionalField(@RequestBody @Valid AdditionalField toCreate) {
        AdditionalField result = repository.save(toCreate);
        return ResponseEntity.created(URI.create("/" +result.getId())).body(result);
    }

}
