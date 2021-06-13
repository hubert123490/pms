package com.pai.pms.logic.service;

import com.pai.pms.model.dto.ApartmentDetailReadModel;
import com.pai.pms.model.dto.PaymentDetailReadModel;
import com.pai.pms.model.repository.ApartmentRepository;
import com.pai.pms.model.repository.PaymentRepository;
import com.pai.pms.security.services.UserDetailsImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LandlordApartmentsService {
    private final ApartmentRepository apartmentRepository;

    public LandlordApartmentsService(ApartmentRepository apartmentRepository) {
        this.apartmentRepository = apartmentRepository;
    }

    public List<ApartmentDetailReadModel> readLandlordApartments(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userImpl = (UserDetailsImpl)authentication.getPrincipal();

        return apartmentRepository.findAllByLandlord_User_Id(userImpl.getId()).stream().map(ApartmentDetailReadModel::new).collect(Collectors.toList());
    }
}
