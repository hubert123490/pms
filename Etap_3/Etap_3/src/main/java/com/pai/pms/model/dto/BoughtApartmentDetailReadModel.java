package com.pai.pms.model.dto;

import com.pai.pms.model.entities.Address;
import com.pai.pms.model.entities.Apartment;
import com.pai.pms.model.entities.Payment;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class BoughtApartmentDetailReadModel {
    private String apartmentName;
    private String address;
    private int phoneNumber;
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private double price;
    private String clientFirstName;
    private String clientLastName;
    private List<String> additionalFields;

    public BoughtApartmentDetailReadModel(Payment payment) {
        this.apartmentName = payment.getAgreement().getApartment().getName();
        this.address = makeAddress(payment.getAgreement().getApartment());
        this.phoneNumber = payment.getAgreement().getLandlord().getUser().getPhone();
        this.dateFrom = payment.getAgreement().getDateFrom();
        this.dateTo = payment.getAgreement().getDateTo();
        this.price = payment.getFee();
        this.clientFirstName = payment.getAgreement().getClient().getUser().getName();
        this.clientLastName = payment.getAgreement().getClient().getUser().getLastName();;
        this.additionalFields = additionalFieldsDescription(payment);
    }

    private List<String> additionalFieldsDescription(Payment payment){
        List<String> result = new ArrayList<String>();
        if(payment.getAgreement().getApartment().isNoAnimals())
            result.add("Możliwość trzymania zwierząt");
        if(payment.getAgreement().getApartment().isBalconyAvailable())
            result.add("Balkon dostępny");
        if (payment.getAgreement().getApartment().isNoSmoking())
            result.add("Możliwość palenia");
        if(result.isEmpty()){
            result.add("Brak");
        }
        return result;
    }

    private String makeAddress(Apartment apartment){
        return apartment.getCountry() + " " + apartment.getCity() + " " + apartment.getStreet() + " " + apartment.getApartmentBuilding();
    }
}
