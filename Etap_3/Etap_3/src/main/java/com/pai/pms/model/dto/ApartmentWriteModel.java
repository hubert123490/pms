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
        this.apartmentNumber = apartment.getApartmentNumber();
        this.apartmentBuilding = apartment.getApartmentBuilding();
        this.street = apartment.getStreet();
        this.postcode = apartment.getPostcode();
        this.city = apartment.getCity();
        this.noSmoking = apartment.isNoSmoking();
        this.noAnimals = apartment.isNoAnimals();
        this.noParties = apartment.isNoParties();
        this.parkingAvailable = apartment.isParkingAvailable();
        this.balconyAvailable = apartment.isBalconyAvailable();
        this.shopsNearby = apartment.isShopsNearby();
    }
}
