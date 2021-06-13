package com.pai.pms.entities;

import com.pai.pms.model.entities.Apartment;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AdditionalField {
    private int id;
    private boolean noSmoking;
    private boolean noAnimals;
    private boolean noParties;
    private boolean balconyAvailable;
    private boolean shopsNearby;
    private Apartment apartment;

    public AdditionalField(int id, boolean noSmoking, boolean noAnimals, boolean noParties, boolean balconyAvailable, boolean shopsNearby, Apartment apartment) {
        this.id = id;
        this.noSmoking = noSmoking;
        this.noAnimals = noAnimals;
        this.noParties = noParties;
        this.balconyAvailable = balconyAvailable;
        this.shopsNearby = shopsNearby;
        this.apartment = apartment;
    }
}
