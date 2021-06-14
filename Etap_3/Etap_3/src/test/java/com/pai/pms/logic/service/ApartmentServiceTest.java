package com.pai.pms.logic.service;

import com.pai.pms.model.dto.ApartmentReadModel;
import com.pai.pms.model.entities.Address;
import com.pai.pms.model.entities.Apartment;
import com.pai.pms.model.entities.Image;
import com.pai.pms.model.repository.AdditionalFieldsRepository;
import com.pai.pms.model.repository.AddressRepository;
import com.pai.pms.model.repository.ApartmentRepository;
import com.pai.pms.model.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class ApartmentServiceTest {

    @Test
    @DisplayName("should return list of apartments")
    void readAll() {
        //given
        var mockRepository = mock(ApartmentRepository.class);
        var mockRepositoryUser = mock(UserRepository.class);
        var mockRepositoryAdditionalField = mock(AdditionalFieldsRepository.class);
        var mockRepositoryAddress = mock(AddressRepository.class);

        //set required data
        Address address = new Address();
        Apartment apartment1 = initApartment("test 0", 20.00, 3);
        Apartment apartment2 = initApartment("test 1", 34.00, 5);
        apartment1.setAddress(address);
        apartment2.setAddress(address);

        when(mockRepository.findAll()).thenReturn(List.of(apartment1, apartment2));
        //SUT
        ApartmentService SUT = new ApartmentService(mockRepository, mockRepositoryAdditionalField, mockRepositoryAddress,
                mockRepositoryUser);

        //when
        List<ApartmentReadModel> result = SUT.readAllWithFilters(null, null, null);
        List<ApartmentReadModel> expected = List.of(new ApartmentReadModel(apartment1), new ApartmentReadModel(apartment2));

        //then
        assertThat(result).containsSequence(expected);
    }

    @Test
    @DisplayName("should return list of apartments in certain period (from, to)")
    void readAllInCertainTimePeriod_AllParamsSet() {
        //given
        var mockRepository = mock(ApartmentRepository.class);
        var mockRepositoryUser = mock(UserRepository.class);
        var mockRepositoryAdditionalField = mock(AdditionalFieldsRepository.class);
        var mockRepositoryAddress = mock(AddressRepository.class);
        LocalDate from = LocalDate.of(2021, 4, 22);
        LocalDate to = LocalDate.of(2021, 7, 3);

        Address address = new Address();
        Apartment apartment1 = initApartment("test 0", 20.00, 3);
        Apartment apartment2 = initApartment("test 1", 34.00, 5);
        Apartment apartment3 = initApartment("test 2", 50.00, 7);

        apartment1.setDateFrom(LocalDate.of(2021, 3, 1));
        apartment1.setDateTo(LocalDate.of(2021, 6, 22));

        apartment2.setDateFrom(LocalDate.of(2021, 5, 22));
        apartment2.setDateTo(LocalDate.of(2021, 6, 10));

        apartment3.setDateFrom(LocalDate.of(2021, 4, 22));
        apartment3.setDateTo(LocalDate.of(2021 , 8, 11));

        apartment1.setAddress(address);
        apartment2.setAddress(address);
        apartment3.setAddress(address);

        when(mockRepository.findAllByDateFromLessThanEqualAndDateToGreaterThanEqual(from, to)).thenReturn(List.of(apartment2));
        //SUT
        ApartmentService SUT = new ApartmentService(mockRepository, mockRepositoryAdditionalField, mockRepositoryAddress,
                mockRepositoryUser);

        //when
        List<ApartmentReadModel> result = SUT.readAllWithFilters(from, to, null);
        List<ApartmentReadModel> expected = List.of(new ApartmentReadModel(apartment2));

        //then
        assertThat(result).containsSequence(expected);
    }

    @Test
    @DisplayName("should return list of apartments from (possibly within) certain date")
    void readAllFromCertainDate_DateFromSet() {
        //given
        var mockRepository = mock(ApartmentRepository.class);
        var mockRepositoryUser = mock(UserRepository.class);
        var mockRepositoryAdditionalField = mock(AdditionalFieldsRepository.class);
        var mockRepositoryAddress = mock(AddressRepository.class);
        LocalDate from = LocalDate.of(2021, 4, 22);

        Address address = new Address();
        Apartment apartment1 = initApartment("test 0", 20.00, 3);
        Apartment apartment2 = initApartment("test 1", 34.00, 5);
        Apartment apartment3 = initApartment("test 2", 50.00, 7);

        apartment1.setDateFrom(LocalDate.of(2021, 3, 1));
        apartment1.setDateTo(LocalDate.of(2021, 6, 22));

        apartment2.setDateFrom(LocalDate.of(2021, 5, 22));
        apartment2.setDateTo(LocalDate.of(2021, 6, 10));

        apartment3.setDateFrom(LocalDate.of(2021, 4, 23));
        apartment3.setDateTo(LocalDate.of(2021 , 8, 11));

        apartment1.setAddress(address);
        apartment2.setAddress(address);
        apartment3.setAddress(address);

        when(mockRepository.findAll()).thenReturn(List.of(apartment1, apartment2, apartment3));
        //SUT
        ApartmentService SUT = new ApartmentService(mockRepository, mockRepositoryAdditionalField, mockRepositoryAddress,
                mockRepositoryUser);

        //when
        List<ApartmentReadModel> result = SUT.readAllWithFilters(from, null, null);
        List<ApartmentReadModel> expected = List.of(new ApartmentReadModel(apartment1));

        //then
        assertThat(result).containsSequence(expected);
    }

    private Apartment initApartment(String name, double price, int sleepingPlaces) {
        Apartment apartment = new Apartment();
        apartment.setName(name);
        apartment.setPrice(price);
        apartment.setSleepingPlaces(sleepingPlaces);
        return apartment;
    }

    private Apartment initApartmentDates(LocalDate from, LocalDate to) {
        Apartment apartment = new Apartment();
        apartment.setDateFrom(from);
        apartment.setDateTo(to);
        return apartment;
    }

    private Image initImage(long id){
        Image image = new Image();
        return image;
    }
}