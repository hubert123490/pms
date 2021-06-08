package com.pai.pms.model.entities;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "apartments")
public class Apartment {
    @Id
    @GeneratedValue(generator = "inc")
    @GenericGenerator(name = "inc", strategy = "increment")
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
    private boolean noSmoking;
    private boolean noAnimals;
    private boolean noParties;
    private boolean parkingAvailable;
    private boolean balconyAvailable;
    private boolean shopsNearby;
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
    private String country;
    private String photo;

    @JoinColumn(name = "landlord_id")
    @ManyToOne
    private Landlord landlord;
    @OneToMany(mappedBy = "apartment")
    private Set<Agreement> agreements;

    @OneToMany(mappedBy = "apartment")
    private List<Opinion> opinions;



    public Apartment() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDiscount() {
        return discount;
    }

    public void setDiscount(boolean discount) {
        this.discount = discount;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getSleepingPlaces() {
        return sleepingPlaces;
    }

    public void setSleepingPlaces(int sleepingPlaces) {
        this.sleepingPlaces = sleepingPlaces;
    }

    public int getFlatArea() {
        return flatArea;
    }

    public void setFlatArea(int flatArea) {
        this.flatArea = flatArea;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isWiFi() {
        return wiFi;
    }

    public void setWiFi(boolean wiFi) {
        this.wiFi = wiFi;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Landlord getLandlord() {
        return landlord;
    }

    public void setLandlord(Landlord landlord) {
        this.landlord = landlord;
    }

    public Set<Agreement> getAgreements() {
        return agreements;
    }

    public void setAgreement(Set<Agreement> agreements) {
        this.agreements = agreements;
    }

    public List<Opinion> getOpinions() {
        return opinions;
    }

    public void setOpinions(List<Opinion> opinions) {
        this.opinions = opinions;
    }

    public boolean isNoSmoking() {
        return noSmoking;
    }

    public void setNoSmoking(boolean noSmoking) {
        this.noSmoking = noSmoking;
    }

    public boolean isNoAnimals() {
        return noAnimals;
    }

    public void setNoAnimals(boolean noAnimals) {
        this.noAnimals = noAnimals;
    }

    public boolean isNoParties() {
        return noParties;
    }

    public void setNoParties(boolean noParties) {
        this.noParties = noParties;
    }

    public boolean isParkingAvailable() {
        return parkingAvailable;
    }

    public void setParkingAvailable(boolean parkingAvailable) {
        this.parkingAvailable = parkingAvailable;
    }

    public boolean isBalconyAvailable() {
        return balconyAvailable;
    }

    public void setBalconyAvailable(boolean balconyAvailable) {
        this.balconyAvailable = balconyAvailable;
    }

    public boolean isShopsNearby() {
        return shopsNearby;
    }

    public void setShopsNearby(boolean shopsNearby) {
        this.shopsNearby = shopsNearby;
    }

    public void setAgreements(Set<Agreement> agreements) {
        this.agreements = agreements;
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
}
