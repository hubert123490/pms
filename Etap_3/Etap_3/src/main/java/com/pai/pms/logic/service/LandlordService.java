package com.pai.pms.logic.service;

import com.pai.pms.model.dto.ClientReadModel;
import com.pai.pms.model.dto.LandlordReadModel;
import com.pai.pms.model.entities.Landlord;
import com.pai.pms.model.repository.ClientRepository;
import com.pai.pms.model.repository.LandlordRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LandlordService {

    private final LandlordRepository repository;
    Logger logger = LoggerFactory.getLogger(LandlordService.class);

    public LandlordService(LandlordRepository repository) {
        this.repository = repository;
    }
    public List<LandlordReadModel> readAll() {
        return repository.findAll().stream().map(LandlordReadModel::new).collect(Collectors.toList());
    }

}
