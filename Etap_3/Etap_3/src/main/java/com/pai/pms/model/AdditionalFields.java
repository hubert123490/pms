package com.pai.pms.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "additional_fields")
public class AdditionalFields {
    @Id
    @GeneratedValue(generator = "inc")
    @GenericGenerator(name = "inc", strategy = "increment")
    private int id;
    private boolean smoke_permission;
    private boolean animals_permission;
    private boolean parking_available;
    private boolean balcony_available;
    @OneToOne(mappedBy = "additionalFields")
    private Apartment apartment;

    public AdditionalFields() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isSmoke_permission() {
        return smoke_permission;
    }

    public void setSmoke_permission(boolean smoke_permission) {
        this.smoke_permission = smoke_permission;
    }

    public boolean isAnimals_permission() {
        return animals_permission;
    }

    public void setAnimals_permission(boolean animals_permission) {
        this.animals_permission = animals_permission;
    }

    public boolean isParking_available() {
        return parking_available;
    }

    public void setParking_available(boolean parking_available) {
        this.parking_available = parking_available;
    }

    public boolean isBalcony_available() {
        return balcony_available;
    }

    public void setBalcony_available(boolean balcony_available) {
        this.balcony_available = balcony_available;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }
}
