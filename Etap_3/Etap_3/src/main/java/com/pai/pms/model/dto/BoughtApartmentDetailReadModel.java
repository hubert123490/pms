package com.pai.pms.model.dto;

import com.pai.pms.model.entities.Address;
import com.pai.pms.model.entities.Image;
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
    private ImageReadModel image;

    public BoughtApartmentDetailReadModel(Payment payment) {
        this.apartmentName = payment.getAgreement().getApartment().getName();
        this.address = makeAddress(payment.getAgreement().getApartment().getAddress());
        this.phoneNumber = payment.getAgreement().getLandlord().getUser().getPhone();
        this.dateFrom = payment.getAgreement().getDateFrom();
        this.dateTo = payment.getAgreement().getDateTo();
        this.price = payment.getFee();
        this.clientFirstName = payment.getAgreement().getClient().getUser().getName();
        this.clientLastName = payment.getAgreement().getClient().getUser().getLastName();;
        this.additionalFields = additionalFieldsDescription(payment);
        this.image = imageToRead(payment);
    }

    private ImageReadModel imageToRead(Payment payment){
        List<Image> images = payment.getAgreement().getApartment().getImages();
        if(images.size() > 0){
            return new ImageReadModel(images.get(0));
        }else{
            return new ImageReadModel();
        }
    }

    private List<String> additionalFieldsDescription(Payment payment){
        List<String> result = new ArrayList<String>();
        if(payment.getAgreement().getApartment().getAdditionalField().isNoAnimals())
            result.add("Możliwość trzymania zwierząt");
        if(payment.getAgreement().getApartment().getAdditionalField().isBalconyAvailable())
            result.add("Balkon dostępny");
        if (payment.getAgreement().getApartment().getAdditionalField().isNoSmoking())
            result.add("Możliwość palenia");
        if (payment.getAgreement().getApartment().getAdditionalField().isNoParties())
            result.add("Możliwość palenia");
        if(result.isEmpty()){
            result.add("Brak");
        }
        return result;
    }

    private String makeAddress(Address address){
        return address.getCountry() + " " + address.getCity() + " " + address.getStreet() + " " + address.getApartmentBuilding();
    }
}