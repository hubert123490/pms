package com.pai.pms.controller;

import com.pai.pms.logic.service.AddOpinionService;
import com.pai.pms.model.entities.Opinion;
import com.pai.pms.payload.request.AddOpinionRequest;
import com.pai.pms.payload.request.PaymentRequest;
import com.pai.pms.payload.response.AddOpinionResponse;
import com.pai.pms.payload.response.PaymentResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;

@RestController
public class AddOpinionController {
    private final AddOpinionService service;
    Logger logger = LoggerFactory.getLogger(AddOpinionController.class);

    public AddOpinionController(AddOpinionService service) {
        this.service = service;
    }

    @RequestMapping(value = "api/opinion/add", method = RequestMethod.POST)
    @PreAuthorize("hasRole('CLIENT')")
    ResponseEntity<?> addOpinion(@RequestBody @Valid AddOpinionRequest addOpinionRequest) {
        try {
            AddOpinionResponse response = service.addOpinion(addOpinionRequest);
            return ResponseEntity.created(URI.create("/" + response.getId())).body(response);
        }catch (Exception e){
            logger.info(e.getMessage());
            return new ResponseEntity<>(
                    "Klient nie jest powiązany z nieruchomością do której chce wystawić opinię",
                    HttpStatus.BAD_REQUEST);
        }

    }
}
