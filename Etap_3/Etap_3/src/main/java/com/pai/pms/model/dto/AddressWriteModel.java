package com.pai.pms.model.dto;

import com.pai.pms.model.entities.Address;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressWriteModel {
    private int apartmentNumber;
    private int apartmentBuilding;
    private String street;
    private String postcode;
    private String city;
    private String country;

    public AddressWriteModel(Address address){
        this.apartmentNumber = address.getApartmentNumber();
        this.apartmentBuilding = address.getApartmentBuilding();
        this.street = address.getStreet();
        this.postcode = address.getPostcode();
        this.city = address.getCity();
        this.country = address.getCountry();
    }

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

    public void updateEntity(Address address){
        address.setApartmentNumber(this.apartmentNumber);
        address.setApartmentBuilding(this.apartmentBuilding);
        address.setStreet(this.street);
        address.setPostcode(this.postcode);
        address.setCity(this.city);
        address.setCountry(this.country);
    }
}
