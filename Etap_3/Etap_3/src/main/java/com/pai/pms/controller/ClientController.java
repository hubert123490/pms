package com.pai.pms.controller;

import com.pai.pms.logic.service.ClientService;
import com.pai.pms.model.dto.ClientReadModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class ClientController {
    private final ClientService service;
    Logger logger = LoggerFactory.getLogger(ClientController.class);

    public ClientController(ClientService service) {
        this.service = service;
    }

    @GetMapping
    @RequestMapping("/clients")
    ResponseEntity<List<ClientReadModel>> readAllClients() {
        return ResponseEntity.ok(service.readAll());
    }

}
