package com.pai.pms.model.dto;

import com.pai.pms.model.entities.Apartment;

public class ApartmentWriteModel {

    private boolean noSmoking;
    private boolean noAnimals;
    private boolean noParties;
    private boolean parkingAvailable;
    private boolean balconyAvailable;
    private boolean shopsNearby;
    private int apartmentNumber;
    private int apartmentBuilding;
    private String street;
    private String postcode;
    private String city;

    public ApartmentWriteModel(Apartment apartment) {
        this.apartmentNumber = apartment.getAddress().getApartmentNumber();
        this.apartmentBuilding = apartment.getAddress().getApartmentBuilding();
        this.street = apartment.getAddress().getStreet();
        this.postcode = apartment.getAddress().getPostcode();
        this.city = apartment.getAddress().getCity();
        this.noSmoking = apartment.getAdditionalField().isNoSmoking();
        this.noAnimals = apartment.getAdditionalField().isNoAnimals();
        this.noParties = apartment.getAdditionalField().isNoParties();
        this.parkingAvailable = apartment.getAdditionalField().isParkingAvailable();
        this.balconyAvailable = apartment.getAdditionalField().isBalconyAvailable();
        this.shopsNearby = apartment.getAdditionalField().isShopsNearby();
    }
}
