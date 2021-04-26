package com.pai.pms.logic.service;

import com.pai.pms.model.dto.ApartmentReadModel;
import com.pai.pms.model.entities.Apartment;
import com.pai.pms.model.repository.ApartmentRepository;
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
        Apartment apartment1 = initApartment("test 0", 20.00, 3);
        Apartment apartment2 = initApartment("test 1", 34.00, 5);
        when(mockRepository.findAll()).thenReturn(List.of(apartment1, apartment2));
        //SUT
        ApartmentService SUT = new ApartmentService(mockRepository);

        //when
        List<ApartmentReadModel> result = SUT.readAll();
        List<ApartmentReadModel> expected = List.of(new ApartmentReadModel(apartment1), new ApartmentReadModel(apartment2));

        //then
        assertThat(result).containsSequence(expected);
    }

    @Test
    void readAllInCertainTimePeriod() {
        //given
        var mockRepository = mock(ApartmentRepository.class);
        LocalDate from = LocalDate.of(2021, 4, 2);
        LocalDate to = LocalDate.of(2021, 7, 3);

        Apartment apartment1 = initApartmentDates(LocalDate.of(2021, 3, 1), LocalDate.of(2021, 6, 22));
        Apartment apartment2 = initApartmentDates(LocalDate.of(2021, 4, 22), LocalDate.of(2021, 8, 10));

        when(mockRepository.findAllByDateFromGreaterThanAndDateToLessThan(from, to)).thenReturn(List.of(apartment2));

        //SUT
        ApartmentService SUT = new ApartmentService(mockRepository);

        //when
        List<ApartmentReadModel> result = SUT.readAllInCertainTimePeriod(from, to);
        List<ApartmentReadModel> expected = List.of(new ApartmentReadModel(apartment2));

        //then
        assertThat(result).isEqualTo(expected);
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
}