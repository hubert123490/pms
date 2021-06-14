package com.pai.pms.logic.service;

import com.pai.pms.model.dto.*;
import com.pai.pms.model.entities.*;
import com.pai.pms.model.repository.AdditionalFieldsRepository;
import com.pai.pms.model.repository.AddressRepository;
import com.pai.pms.model.repository.ApartmentRepository;
import com.pai.pms.model.repository.UserRepository;
import com.pai.pms.payload.request.AddApartmentRequest;
import com.pai.pms.payload.request.UpdateApartmentRequest;
import com.pai.pms.security.services.UserDetailsImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class LandlordApartmentsServiceTest {

    //setting security context
    @BeforeAll
    static void beforeAll() {
        Authentication authentication = new Authentication() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return null;
            }

            @Override
            public Object getCredentials() {
                return null;
            }

            @Override
            public Object getDetails() {
                return null;
            }

            @Override
            public Object getPrincipal() {
                return new UserDetailsImpl(1, "test@mail.com", "123456789", List.of(new SimpleGrantedAuthority("LANDLORD")));
            }

            @Override
            public boolean isAuthenticated() {
                return false;
            }

            @Override
            public void setAuthenticated(boolean b) throws IllegalArgumentException {

            }

            @Override
            public String getName() {
                return String.valueOf(1);
            }
        };
        // Mockito.whens() for your authorization object
        SecurityContext securityContext = Mockito.mock(SecurityContext.class);
        when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securityContext);
    }

    @Test
    @DisplayName("update apartment should throw exception")
    void updateApartment_shouldWorkAsIntended(){
        //given
        ApartmentRepository apartmentRepository = mock(ApartmentRepository.class);
        AdditionalFieldsRepository additionalFieldsRepository = mock(AdditionalFieldsRepository.class);
        AddressRepository addressRepository = mock(AddressRepository.class);
        UserRepository userRepository = mock(UserRepository.class);

        UpdateApartmentRequest updateApartmentRequest = new UpdateApartmentRequest();
        updateApartmentRequest.setApartment(new ApartmentWriteModel());
        updateApartmentRequest.setAddress(new AddressWriteModel());
        updateApartmentRequest.setAdditionalField(new AdditionalFieldWriteModel());

        Apartment apartment = mock(Apartment.class);
        Address address = new Address();
        AdditionalField additionalField = new AdditionalField();
        //set required data

        additionalField.setNoSmoking(true);
        apartment.setAddress(address);
        apartment.setAdditionalField(additionalField);

        //get user from security context
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userImpl = (UserDetailsImpl)authentication.getPrincipal();

        when(apartmentRepository.findById(1)).thenReturn(Optional.of(apartment));
        when(userRepository.findById(any())).thenReturn(null);
        //SUT
        LandlordApartmentsService SUT = new LandlordApartmentsService(apartmentRepository, additionalFieldsRepository,
                addressRepository, userRepository);
        //when
        var exception = catchThrowable(() -> SUT.updateApartment(2, updateApartmentRequest));

        //then
        assertThat(exception).isInstanceOf(NullPointerException.class);

    }

    @Test
    @DisplayName("read landlord apartments should work as intended")
    void readApartments_shouldWorkAsIntended(){
        //given
        ApartmentRepository apartmentRepository = mock(ApartmentRepository.class);
        AdditionalFieldsRepository additionalFieldsRepository = mock(AdditionalFieldsRepository.class);
        AddressRepository addressRepository = mock(AddressRepository.class);
        UserRepository userRepository = mock(UserRepository.class);
        //set required data

        Apartment apartment = mock(Apartment.class);

        when(apartmentRepository.findAllByLandlord_User_Id(1)).thenReturn(List.of(apartment));

        //get user from security context
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userImpl = (UserDetailsImpl)authentication.getPrincipal();
        //SUT
        LandlordApartmentsService SUT = new LandlordApartmentsService(apartmentRepository, additionalFieldsRepository,
                addressRepository, userRepository);
        //when
        List<LandlordApartmentsReadModel> expected = List.of(new LandlordApartmentsReadModel(apartment));
        List<LandlordApartmentsReadModel> result = SUT.readLandlordApartments();

        //then
        assertThat(result).containsSequence(expected);
    }


}