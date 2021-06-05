package com.pai.pms.logic.service;

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

    public List<ApartmentReadModel> readByCity(String name) {
        return repository.findAllByCity(name).stream().map(ApartmentReadModel::new).collect(Collectors.toList());
    }

    public List<ApartmentReadModel> readAllInCertainTimePeriod(LocalDate from, LocalDate to) {
        return repository.findAllByDateFromLessThanAndDateToGreaterThan(from, to).stream().map(ApartmentReadModel::new).collect(Collectors.toList());
    }

    public List<ApartmentReadModel> readAllInCertainTimePeriodAndCity(LocalDate from, LocalDate to, String city){
        return repository.findAllByDateFromLessThanAndDateToGreaterThanAndCity(from, to, city).stream().map(ApartmentReadModel::new).collect(Collectors.toList());
    }

    public List<ApartmentReadModel> readAllFrom(LocalDate from){
        return repository.findAllByDateFromLessThan(from).stream().map(ApartmentReadModel::new).collect(Collectors.toList());
    }

    public List<ApartmentReadModel> readAllWithFilters(LocalDate from, LocalDate to, String name) {
        if (from == null  && to == null && (name == null || name.equals(""))) {
            logger.info("everything nulls");
            return readAll();
        }
        else {
            if (name != null && !name.equals("") && (from != null && to != null)){
                logger.info("all filters up");
                return readAllInCertainTimePeriodAndCity(from, to, name);
            }
            else{
                if(name != null && !name.equals("")){
                    logger.info("city not null");
                    return readByCity(name);
                }
                else if (from != null && to != null){
                    logger.info("reading period");
                    return readAllInCertainTimePeriod(from, to);
                }
                else if (from != null){
                    logger.info("reading from");
                    return readAllFrom(from);
                }
            }

        }
        throw new IllegalStateException();
    }
}
