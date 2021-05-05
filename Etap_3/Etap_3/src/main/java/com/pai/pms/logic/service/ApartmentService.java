package com.pai.pms.logic.service;

import com.pai.pms.controller.ApartmentController;
import com.pai.pms.model.dto.ApartmentReadModel;
import com.pai.pms.model.repository.ApartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApartmentService {
    private final ApartmentRepository repository;
    Logger logger = LoggerFactory.getLogger(ApartmentService.class);


    public ApartmentService(ApartmentRepository repository) {
        this.repository = repository;
    }

    public List<ApartmentReadModel> readAll() {
        return repository.findAll().stream().map(ApartmentReadModel::new).collect(Collectors.toList());
    }

    public List<ApartmentReadModel> readByName(String name) {
        return repository.findAllByName(name).stream().map(ApartmentReadModel::new).collect(Collectors.toList());
    }

    public List<ApartmentReadModel> readAllInCertainTimePeriod(LocalDate from, LocalDate to) {
        return repository.findAllByDateFromLessThanAndDateToGreaterThan(from, to).stream().map(ApartmentReadModel::new).collect(Collectors.toList());
    }

    public List<ApartmentReadModel> readAllWithFilters(LocalDate from, LocalDate to, String name) {
        if (from == null  && to == null && (name == null || name.equals(""))) {
            logger.info("everything nulls");
            return readAll();
        }
        else {
            if(name != null && !name.equals("")){
                logger.info("name not null");
                return readByName(name);
            }
            else if (from != null && to != null){
                logger.info("reading period");
                return readAllInCertainTimePeriod(from, to);
            }
        }
        throw new IllegalStateException();
    }
}
