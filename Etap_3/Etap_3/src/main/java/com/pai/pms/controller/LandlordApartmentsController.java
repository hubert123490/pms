package com.pai.pms.controller;

import com.pai.pms.logic.service.LandlordApartmentsService;
import com.pai.pms.model.dto.ApartmentReadModel;
import com.pai.pms.model.dto.LandlordApartmentsReadModel;
import com.pai.pms.payload.request.AddApartmentRequest;
import com.pai.pms.payload.request.UpdateApartmentRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@Controller
public class LandlordApartmentsController {
    private final LandlordApartmentsService service;
    Logger logger = LoggerFactory.getLogger(AddOpinionController.class);

    public LandlordApartmentsController(LandlordApartmentsService service) {
        this.service = service;
    }

    @GetMapping
    @RequestMapping("/landlord/apartments")
    ResponseEntity<List<LandlordApartmentsReadModel>> readLandlordApartments() {
        try {
            logger.info("Reading landlord apartments");
            return ResponseEntity.ok(service.readLandlordApartments());
        }catch (Exception e){
            logger.error(e.getMessage());
            return ResponseEntity.status(500).build();
        }
    }

    @Transactional
    @RequestMapping(value = "/landlord/apartment/update/{id}", method = RequestMethod.PUT)
    ResponseEntity<ApartmentReadModel> updateApartment(@PathVariable(value = "id") Integer id, @RequestBody UpdateApartmentRequest updateApartmentRequest) {
        try {
            logger.info("Updating landlord apartment");
            return ResponseEntity.ok(service.updateApartment(id, updateApartmentRequest));
        }catch (Exception e){
            logger.error(e.getMessage());
            return ResponseEntity.status(500).build();
        }
    }

    @RequestMapping(value = "landlord/apartment/{id}", method = RequestMethod.GET)
    ResponseEntity<AddApartmentRequest> getApartmentDetails(@PathVariable(value = "id") Integer id){
        try {
            logger.info("Reading apartment details for update");
            return ResponseEntity.ok(service.readApartmentDetails(id));
        }catch (Exception e){
            logger.error(e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }
}
