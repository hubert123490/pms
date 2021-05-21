package com.pai.pms.logic.service;

import com.pai.pms.model.dto.ApartmentReadModel;
import com.pai.pms.model.dto.ClientReadModel;
import com.pai.pms.model.repository.ApartmentRepository;
import com.pai.pms.model.repository.ClientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {
    private final ClientRepository repository;
    Logger logger = LoggerFactory.getLogger(ClientService.class);


    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    public List<ClientReadModel> readAll() {
        return repository.findAll().stream().map(ClientReadModel::new).collect(Collectors.toList());
    }
}
