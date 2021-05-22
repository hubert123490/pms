package com.pai.pms.model.dto;
import com.pai.pms.model.entities.Landlord;
import lombok.Data;

@Data
public class LandlordReadModel {
    private int id;
    private String name;
    private String lastName;
    private String email;
    private int phone;
    private int idCard;
    private String password;
    private int apartmentNumber;
    private int apartmentBuilding;
    private String street;
    private String postcode;
    private String city;

    public LandlordReadModel(Landlord landlord) {
        this.id = landlord.getId();
        this.name = landlord.getUser().getName();
        this.lastName = landlord.getUser().getLastName();
        this.idCard = landlord.getIdCard();
        this.phone = landlord.getUser().getPhone();
        this.email = landlord.getUser().getEmail();
        this.password = landlord.getUser().getPassword();
        this.apartmentNumber = landlord.getAddress().getApartmentNumber();
        this.apartmentBuilding = landlord.getAddress().getApartmentBuilding();
        this.street = landlord.getAddress().getStreet();
        this.postcode = landlord.getAddress().getPostcode();
        this.city = landlord.getAddress().getCity();
    }
}
