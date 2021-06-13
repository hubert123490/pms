package com.pai.pms.entities;

import com.pai.pms.model.entities.Apartment;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Address {
    private int id;
    private int apartmentNumber;
    private int apartmentBuilding;
    private String street;
    private String postcode;
    private String city;
    private String country;
    private Apartment apartment;

    public Address(int id, int apartmentNumber, int apartmentBuilding,
                   String street, String postcode, String city, String country, Apartment apartment) {
        this.id = id;
        this.apartmentNumber = apartmentNumber;
        this.apartmentBuilding = apartmentBuilding;
        this.street = street;
        this.postcode = postcode;
        this.city = city;
        this.country = country;
        this.apartment = apartment;
    }
}
