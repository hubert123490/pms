package com.pai.pms.model.dto;

import com.pai.pms.model.entities.Apartment;
import com.pai.pms.model.entities.Opinion;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class ApartmentDetailReadModel {
    private int apartmentId;
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
    private List<OpinionReadModel> opinionReadModel;


    public ApartmentDetailReadModel(Apartment apartment) {
        this.apartmentId = apartment.getId();
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
        this.opinionReadModel = getAllOpinionsFromApartment(apartment);
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
        if(apartment.getAdditionalField().isNoAnimals())
            result.add("Nie można trzymać zwierząt");
        if(apartment.getAdditionalField().isBalconyAvailable())
            result.add("Balkon dostępny");
        if (apartment.getAdditionalField().isNoSmoking())
            result.add("Nie można palić");
        if(result.isEmpty()){
            result.add("Brak");
        }

        return result;
    }

    private List<OpinionReadModel> getAllOpinionsFromApartment(Apartment apartment){
        return apartment.getOpinions().stream().filter(opinion -> {
            return opinion.getApartment() != null;
        }).map(OpinionReadModel::new).collect(Collectors.toList());
    }
}
