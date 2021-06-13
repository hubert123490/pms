package com.pai.pms.model.dto;

import com.pai.pms.model.entities.Apartment;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class ApartmentReadModel {
    private int id;
    private String description;
    private double price;
    private String city;
    private List<ImageReadModel> images;

    public ApartmentReadModel(Apartment apartment) {
        this.id = apartment.getId();
        this.description = makeApartmentDescription(apartment);
        this.price = apartment.getPrice();
        this.city = apartment.getAddress().getCity();
        this.images = apartment.getImages().stream().map(ImageReadModel::new).collect(Collectors.toList());
    }

    private String makeApartmentDescription(Apartment apartment) {
        return apartment.getName() + " apartament z " + apartment.getSleepingPlaces() + " wolnymi pokojami.";
    }
}