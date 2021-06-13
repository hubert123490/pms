package com.pai.pms.logic.service;

import com.pai.pms.model.dto.*;
import com.pai.pms.model.entities.AdditionalField;
import com.pai.pms.model.entities.Address;
import com.pai.pms.model.entities.Apartment;
import com.pai.pms.model.entities.User;
import com.pai.pms.model.repository.*;
import com.pai.pms.payload.request.AddApartmentRequest;
import com.pai.pms.payload.request.UpdateApartmentRequest;
import com.pai.pms.security.services.UserDetailsImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LandlordApartmentsService {
    private final ApartmentRepository apartmentRepository;
    private final AdditionalFieldsRepository additionalFieldsRepository;
    private final AddressRepository addressRepository;
    private final UserRepository userRepository;

    public LandlordApartmentsService(ApartmentRepository apartmentRepository, AdditionalFieldsRepository additionalFieldsRepository, AddressRepository addressRepository, UserRepository userRepository) {
        this.apartmentRepository = apartmentRepository;
        this.additionalFieldsRepository = additionalFieldsRepository;
        this.addressRepository = addressRepository;
        this.userRepository = userRepository;
    }

    public List<LandlordApartmentsReadModel> readLandlordApartments(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userImpl = (UserDetailsImpl)authentication.getPrincipal();

        return apartmentRepository.findAllByLandlord_User_Id(userImpl.getId()).stream().map(LandlordApartmentsReadModel::new).collect(Collectors.toList());
    }

    @Transactional
    public ApartmentReadModel updateApartment(int id, UpdateApartmentRequest updateApartmentRequest) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userImpl = (UserDetailsImpl)authentication.getPrincipal();

        User user = userRepository.findById(userImpl.getId()).orElse(null);
        if(user == null){
            System.out.println("User is null");
        }

        Apartment apartment = apartmentRepository.findById(id).orElseThrow();
        AdditionalField additionalField = apartment.getAdditionalField();
        Address address = apartment.getAddress();

        updateApartmentRequest.getApartment().updateEntity(apartment);
        updateApartmentRequest.getAdditionalField().updateEntity(additionalField);
        updateApartmentRequest.getAddress().updateEntity(address);

        additionalFieldsRepository.save(additionalField);
        addressRepository.save(address);
        apartmentRepository.save(apartment);
        return new ApartmentReadModel(apartment);
    }

    public AddApartmentRequest readApartmentDetails(int id){
        AddApartmentRequest addApartmentRequest = new AddApartmentRequest();
        Apartment apartment = apartmentRepository.findById(id).orElseThrow();
        AdditionalField additionalField = apartment.getAdditionalField();
        Address address = apartment.getAddress();
        addApartmentRequest.setApartment(new ApartmentWriteModel(apartment));
        addApartmentRequest.setAdditionalField(new AdditionalFieldWriteModel(additionalField));
        addApartmentRequest.setAddress(new AddressWriteModel(address));
        return addApartmentRequest;
    }
}
