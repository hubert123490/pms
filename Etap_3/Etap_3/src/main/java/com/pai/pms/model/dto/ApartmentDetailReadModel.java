package com.pai.pms.model.dto;

import com.pai.pms.model.entities.Apartment;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class ApartmentDetailReadModel {
    private String apartmentName;
    private String description;
    private LocalDate from;
    private LocalDate to;
    private int sleepingPlaces;
    private int flatArea;
    private String country;
    private String city;
    private String wifi;
    private String parking;
    private List<String> additionalFields;
    private int contact;
    private double price;


    public ApartmentDetailReadModel(Apartment apartment) {
        this.apartmentName = apartment.getName();
        this.description = "tmp description, add description to apartment in database please!";
        this.from = apartment.getDateFrom();
        this.to = apartment.getDateTo();
        this.sleepingPlaces = apartment.getSleepingPlaces();
        this.flatArea = apartment.getFlatArea();
        this.country = apartment.getAddress().getCountry();
        this.city = apartment.getAddress().getCity();
        this.wifi = wifiDescription(apartment.isWiFi());
        this.parking = parkingDescription(apartment.isParking());
        this.additionalFields = additionalFieldsDescription(apartment);
        this.contact = apartment.getLandlord().getUser().getPhone();
        this.price = apartment.getPrice();

    }

    private String wifiDescription(Boolean isWifi){
        if(isWifi)
            return "Tak";
        else
            return "Nie";
    }

    private String parkingDescription(Boolean isParking){
        if(isParking)
            return "Tak";
        else
            return "Nie";
    }

    private List<String> additionalFieldsDescription(Apartment apartment){
        List<String> result = new ArrayList<String>();
        if(apartment.getAdditionalField().isAnimals_permission())
            result.add("Możliwość trzymania zwierząt");
        if(apartment.getAdditionalField().isBalcony_available())
            result.add("Balkon dostępny");
        if (apartment.getAdditionalField().isSmoke_permission())
            result.add("Możliwość palenia");
        if(result.isEmpty()){
            result.add("Brak");
        }

        return result;
    }
}
