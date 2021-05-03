package com.pai.pms.controller;

import com.pai.pms.model.entities.Client;
import com.pai.pms.model.repository.ClientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientController {
    private static final Logger logger = LoggerFactory.getLogger(ClientController.class);
    private final ClientRepository repository;
    public ClientController(ClientRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    @RequestMapping("/clients")
    ResponseEntity<List<Client>> readAllClients() {
        logger.warn("Exposing all the clients!");
        List<Client> test = repository.findAll();
        return ResponseEntity.ok(test);
    }
}
