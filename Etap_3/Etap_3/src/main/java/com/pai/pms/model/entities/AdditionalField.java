package com.pai.pms.model.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "additional_fields")
public class AdditionalField {
    @Id
    @GeneratedValue(generator = "inc")
    @GenericGenerator(name = "inc", strategy = "increment")
    private int id;
    private boolean noSmoking;
    private boolean noAnimals;
    private boolean noParties;
    private boolean parkingAvailable;
    private boolean balconyAvailable;
    private boolean shopsNearby;
    @OneToOne(mappedBy = "additionalField")
    private Apartment apartment;

    public AdditionalField() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }
}
