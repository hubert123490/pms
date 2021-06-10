package com.pai.pms.model.dto;

import com.pai.pms.model.entities.Address;
import lombok.Data;

@Data
public class AddressWriteModel {
    private int apartmentNumber;
    private int apartmentBuilding;
    private String street;
    private String postcode;
    private String city;
    private String country;



    public Address toAddress(){
        Address address = new Address();
        address.setApartmentNumber(this.apartmentNumber);
        address.setApartmentBuilding(this.apartmentBuilding);
        address.setStreet(this.street);
        address.setPostcode(this.postcode);
        address.setCity(this.city);
        address.setCountry(this.country);
        return address;
    }
}
