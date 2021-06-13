package com.pai.pms.model.entities;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(generator = "inc")
    @GenericGenerator(name = "inc", strategy = "increment")
    private int id;
    private int apartmentNumber;
    @Column(name = "apartmentBuilding", nullable = false)
    @Range(min = 1, message= "Address's number of the building must not be empty")
    private int apartmentBuilding;
    @NotBlank(message = "Address's street must not be empty")
    private String street;
    @NotBlank(message = "Address's postcode must not be empty")
    private String postcode;
    @NotBlank(message = "Address's city must not be empty")
    private String city;
    @NotBlank(message = "Address's country must not be empty")
    private String country;
    @OneToOne(mappedBy = "address")
    private Apartment apartment;
    @OneToOne(mappedBy = "address")
    private TouristAttraction touristAttraction;

    public Address() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(int apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public int getApartmentBuilding() {
        return apartmentBuilding;
    }

    public void setApartmentBuilding(int apartmentBuilding) {
        this.apartmentBuilding = apartmentBuilding;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }

    public TouristAttraction getTouristAttraction() {
        return touristAttraction;
    }

    public void setTouristAttraction(TouristAttraction touristAttraction) {
        this.touristAttraction = touristAttraction;
    }
}