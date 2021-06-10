package com.pai.pms.controller;

import com.pai.pms.logic.service.ApartmentService;
import com.pai.pms.model.dto.ApartmentReadModel;
import com.pai.pms.model.entities.AdditionalField;
import com.pai.pms.model.entities.Apartment;
import com.pai.pms.payload.request.AddApartmentRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class ApartmentController {
    @Autowired
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
    ResponseEntity<List<ApartmentReadModel>> readAllApartmentsInTimePeriod(@DateTimeFormat(pattern = "yyyy-MM-dd") @Param("from") LocalDate from,
                                                                           @DateTimeFormat(pattern = "yyyy-MM-dd") @Param("to") LocalDate to
    ) {
        return ResponseEntity.ok(service.readAllInCertainTimePeriod(from, to));
    }

    @GetMapping
    @RequestMapping("/apartments/read")
    ResponseEntity<List<ApartmentReadModel>> readAllApartmentsWithFilters(@DateTimeFormat(pattern = "yyyy-MM-dd") @Param("from") LocalDate from,
                                                                          @DateTimeFormat(pattern = "yyyy-MM-dd") @Param("to") LocalDate to,
                                                                          @Param("name") String name) {
        return ResponseEntity.ok(service.readAllWithFilters(from, to, name));
    }

//    @PostMapping("/apartment")
//    ResponseEntity<Apartment> createApartment(@RequestBody @Valid Apartment toCreate) {
//        Apartment result = service.save(toCreate);
//        return ResponseEntity.created(URI.create("/" +result.getId())).body(result);
//    }

    @PostMapping("/apartment/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ApartmentReadModel> addNewApartment(@RequestBody AddApartmentRequest request) {
        try {
            return ResponseEntity.ok(service.addNewApartment(request));
        }catch (NullPointerException e){
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }


}
