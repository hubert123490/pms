package com.pai.pms.logic.service;

import com.pai.pms.model.dto.ApartmentReadModel;
import com.pai.pms.model.dto.ApartmentWriteModel;
import com.pai.pms.model.entities.AdditionalField;
import com.pai.pms.model.entities.Address;
import com.pai.pms.model.entities.Apartment;
import com.pai.pms.model.entities.User;
import com.pai.pms.model.repository.AdditionalFieldsRepository;
import com.pai.pms.model.repository.AddressRepository;
import com.pai.pms.model.repository.ApartmentRepository;
import com.pai.pms.model.repository.UserRepository;
import com.pai.pms.payload.request.AddApartmentRequest;
import com.pai.pms.security.services.UserDetailsImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApartmentService {
    private final ApartmentRepository repository;
    private final AdditionalFieldsRepository additionalFieldsRepository;
    private final AddressRepository addressRepository;
    private final UserRepository userRepository;
    Logger logger = LoggerFactory.getLogger(ApartmentService.class);


    public ApartmentService(ApartmentRepository repository, AdditionalFieldsRepository additionalFieldsRepository, AddressRepository addressRepository, UserRepository userRepository) {
        this.repository = repository;
        this.additionalFieldsRepository = additionalFieldsRepository;
        this.addressRepository = addressRepository;
        this.userRepository = userRepository;
    }

    public List<ApartmentReadModel> readAll() {
        return repository.findAll().stream().map(ApartmentReadModel::new).collect(Collectors.toList());
    }

    public List<ApartmentReadModel> readByCity(String name) {
        return repository.findAllByAddress_City(name).stream().map(ApartmentReadModel::new).collect(Collectors.toList());
    }

    public List<ApartmentReadModel> readAllInCertainTimePeriod(LocalDate from, LocalDate to) {
        return repository.findAllByDateFromLessThanEqualAndDateToGreaterThanEqual(from, to).stream().map(ApartmentReadModel::new).collect(Collectors.toList());
    }

    public List<ApartmentReadModel> readAllInCertainTimePeriodAndCity(LocalDate from, LocalDate to, String city){
        return repository.findAllByDateFromLessThanAndDateToGreaterThanAndAddress_City(from, to, city).stream().map(ApartmentReadModel::new).collect(Collectors.toList());
    }

    public List<ApartmentReadModel> readAllFrom(LocalDate from){
        //return repository.findAllByDateToGreaterThanEqualDateFromLessThanEqual(from).stream().map(ApartmentReadModel::new).collect(Collectors.toList());
        List<Apartment> apartments = repository.findAll();
        List<ApartmentReadModel> availableApartments = new ArrayList<ApartmentReadModel>();
        for (Apartment apartment:
             apartments) {
            if(isWithinRange(from, apartment)){
                availableApartments.add(new ApartmentReadModel(apartment));
            }
        }
        return availableApartments;
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

    public String addNewApartment(AddApartmentRequest request) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userImpl = (UserDetailsImpl)authentication.getPrincipal();

        User user = userRepository.findById(userImpl.getId()).orElse(null);
        if(user == null){
            System.out.println("User is null");
        }

        Apartment apartment = request.getApartment().toApartment();

        AdditionalField additionalField = request.getAdditionalField().toAdditionalField();
        Address address = request.getAddress().toAddress();

        apartment.setAdditionalField(additionalField);
        apartment.setAddress(address);
        apartment.setLandlord(user.getLandlord());

        additionalFieldsRepository.save(additionalField);
        addressRepository.save(address);
        repository.save(apartment);
        return "Ok";
    }

    private boolean isWithinRange(LocalDate date, Apartment apartment) {
        return !(date.isBefore(apartment.getDateFrom()) || date.isAfter(apartment.getDateTo()));
    }
}