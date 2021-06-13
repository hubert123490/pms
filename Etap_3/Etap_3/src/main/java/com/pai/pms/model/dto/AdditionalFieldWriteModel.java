package com.pai.pms.model.dto;

import com.pai.pms.model.entities.AdditionalField;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AdditionalFieldWriteModel {
    private boolean noSmoking;
    private boolean noAnimals;
    private boolean noParties;
    private boolean balconyAvailable;
    private boolean shopsNearby;

    public AdditionalFieldWriteModel(AdditionalField additionalField){
        this.noSmoking = additionalField.isNoSmoking();
        this.noAnimals = additionalField.isNoAnimals();
        this.noParties = additionalField.isNoParties();
        this.balconyAvailable = additionalField.isBalconyAvailable();
        this.shopsNearby = additionalField.isShopsNearby();
    }

    public AdditionalField toAdditionalField(){
        AdditionalField additionalField = new AdditionalField();
        additionalField.setNoSmoking(this.noSmoking);
        additionalField.setNoAnimals(this.noAnimals);
        additionalField.setNoParties(this.noParties);
        additionalField.setBalconyAvailable(this.balconyAvailable);
        additionalField.setShopsNearby(this.shopsNearby);
        return additionalField;
    }

    public void updateEntity(AdditionalField additionalField){
        additionalField.setNoSmoking(this.noSmoking);
        additionalField.setNoAnimals(this.noAnimals);
        additionalField.setNoParties(this.noParties);
        additionalField.setBalconyAvailable(this.balconyAvailable);
        additionalField.setShopsNearby(this.shopsNearby);
    }
}
