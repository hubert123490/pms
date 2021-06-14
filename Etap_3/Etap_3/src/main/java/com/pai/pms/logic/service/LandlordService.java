package com.pai.pms.logic.service;

import com.pai.pms.model.dto.LandlordClientReadModel;
import com.pai.pms.model.entities.Agreement;
import com.pai.pms.model.entities.Apartment;
import com.pai.pms.model.entities.Client;
import com.pai.pms.model.entities.User;
import com.pai.pms.model.repository.ApartmentRepository;
import com.pai.pms.model.repository.UserRepository;
import com.pai.pms.security.services.UserDetailsImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class LandlordService {
    private final UserRepository userRepository;
    private final ApartmentRepository apartmentRepository;
    Logger logger = LoggerFactory.getLogger(LandlordService.class);

    public LandlordService(UserRepository userRepository, ApartmentRepository apartmentRepository) {
        this.userRepository = userRepository;
        this.apartmentRepository = apartmentRepository;
    }

    public List<LandlordClientReadModel> readAllClients() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userImpl = (UserDetailsImpl)authentication.getPrincipal();

        User user = userRepository.findById(userImpl.getId()).orElse(null);
        List<Apartment> apartments = user.getLandlord().getApartments().stream().collect(Collectors.toList());
        Set<Client> landlordClients = new HashSet<>();
        for (Apartment apartment:
             apartments) {
            List<Agreement> agreements = new ArrayList<>(apartment.getAgreements());
            for (Agreement agreement:
                 agreements) {
                landlordClients.add(agreement.getClient());
            }
        }
        return landlordClients.stream().map(LandlordClientReadModel::new).collect(Collectors.toList());
    }

}
