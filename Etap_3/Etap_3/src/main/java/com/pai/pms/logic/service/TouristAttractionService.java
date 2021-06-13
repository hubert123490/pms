package com.pai.pms.logic.service;
import com.pai.pms.model.dto.TouristAttractionReadModel;
import com.pai.pms.model.repository.TouristAttractionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TouristAttractionService {


    private final TouristAttractionRepository repository;
    Logger logger = LoggerFactory.getLogger(TouristAttractionService.class);

    public TouristAttractionService(TouristAttractionRepository repository) {
        this.repository = repository;
    }
    public List<TouristAttractionReadModel> readAll() {
        return repository.findAll().stream().map(TouristAttractionReadModel::new).collect(Collectors.toList());
    }

}
