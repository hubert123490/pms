package com.pai.pms.model.dto;

import com.pai.pms.model.entities.Apartment;
import lombok.Data;

import java.time.LocalDate;

@Data
public class LandlordApartmentsReadModel {
    private int id;
    private String apartmentName;
    private LocalDate from;
    private LocalDate to;
    private double price;
    private boolean hasPhotos;

    public LandlordApartmentsReadModel(Apartment apartment) {
        this.id = apartment.getId();
        this.apartmentName = apartment.getName();
        this.from = apartment.getDateFrom();
        this.to = apartment.getDateTo();
        this.price = apartment.getPrice();
        this.hasPhotos = !apartment.getImages().isEmpty();
    }
}
