package com.pai.pms.entities;

import com.pai.pms.model.entities.AdditionalField;
import com.pai.pms.model.entities.Address;
import com.pai.pms.model.entities.Agreement;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
public class Apartment {
    private int id;
    private String name;
    private boolean discount;
    private int roomNumber;
    private int sleepingPlaces;
    private int flatArea;
    private boolean isEmpty;
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private double price;
    private boolean wiFi;
    private boolean parkingAvailable;
    private String photo;
    private String type;
    private Address address;
    private Landlord landlord;
    private Set<Agreement> agreements;
    private AdditionalField additionalField;
    private List<Opinion> opinions;
    private List<Image> images;

    public Apartment(int id, String name, boolean discount, int roomNumber, int sleepingPlaces, int flatArea,
                     boolean isEmpty, LocalDate dateFrom, LocalDate dateTo, double price, boolean wiFi,
                     boolean parkingAvailable, String photo, String type, Address address, Landlord landlord,
                     Set<Agreement> agreements, AdditionalField additionalField, List<Opinion> opinions, List<Image> images) {
        this.id = id;
        this.name = name;
        this.discount = discount;
        this.roomNumber = roomNumber;
        this.sleepingPlaces = sleepingPlaces;
        this.flatArea = flatArea;
        this.isEmpty = isEmpty;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.price = price;
        this.wiFi = wiFi;
        this.parkingAvailable = parkingAvailable;
        this.photo = photo;
        this.type = type;
        this.address = address;
        this.landlord = landlord;
        this.agreements = agreements;
        this.additionalField = additionalField;
        this.opinions = opinions;
        this.images = images;
    }
}
