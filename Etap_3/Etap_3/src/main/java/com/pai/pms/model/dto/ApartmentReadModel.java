package com.pai.pms.model.dto;

import com.pai.pms.model.entities.Apartment;
import lombok.Data;

@Data
public class ApartmentReadModel {
    private int id;
    private String description;
    private double price;
    private String city;

    public ApartmentReadModel(Apartment apartment) {
        this.id = apartment.getId();
        this.description = makeApartmentDescription(apartment);
        this.price = apartment.getPrice();
        this.city = apartment.getAddress().getCity();
    }


    private String makeApartmentDescription(Apartment apartment) {
        return apartment.getName() + " apartment, with " + apartment.getSleepingPlaces() + " free rooms.";
    }
}
