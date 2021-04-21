package com.pai.pms.logic.service;

import com.pai.pms.model.dto.ApartmentReadModel;
import com.pai.pms.model.repository.ApartmentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApartmentService {
    private final ApartmentRepository repository;

    public ApartmentService(ApartmentRepository repository) {
        this.repository = repository;
    }

    public List<ApartmentReadModel> readAll() {
        return repository.findAll().stream().map(ApartmentReadModel::new).collect(Collectors.toList());
    }

    public List<ApartmentReadModel> readAllInCertainTimePeriod(LocalDate from, LocalDate to) {
        return repository.findAllByDateFromGreaterThanAndDateToLessThan(from, to).stream().map(ApartmentReadModel::new).collect(Collectors.toList());
    }
}
