package com.pai.pms.model.dto;

import com.pai.pms.model.entities.Apartment;
import com.pai.pms.model.entities.Image;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class ApartmentReadModel {
    private int id;
    private String description;
    private double price;
    private String city;
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private List<ImageReadModel> images;

    public ApartmentReadModel(Apartment apartment) {
        this.id = apartment.getId();
        this.description = makeApartmentDescription(apartment);
        this.price = apartment.getPrice();
        this.city = apartment.getAddress().getCity();
        this.dateFrom = apartment.getDateFrom();
        this.dateTo = apartment.getDateTo();
        this.images = readImages(apartment);
    }

    private List<ImageReadModel> readImages(Apartment apartment){
        if(apartment.getImages() != null) {
            List<ImageReadModel> images = apartment.getImages().stream().map(ImageReadModel::new).collect(Collectors.toList());
            return images;
        }else{
            return List.of();
        }
    }

    private String makeApartmentDescription(Apartment apartment) {
        return apartment.getName() + " apartament z " + apartment.getSleepingPlaces() + " wolnymi pokojami.";
    }
}