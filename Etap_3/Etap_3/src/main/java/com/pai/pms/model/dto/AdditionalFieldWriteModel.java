package com.pai.pms.model.dto;

import com.pai.pms.model.entities.AdditionalField;
import lombok.Data;

@Data
public class AdditionalFieldWriteModel {
    private boolean noSmoking;
    private boolean noAnimals;
    private boolean noParties;
    private boolean balconyAvailable;
    private boolean shopsNearby;

    public AdditionalField toAdditionalField(){
        AdditionalField additionalField = new AdditionalField();
        additionalField.setNoSmoking(this.noSmoking);
        additionalField.setNoAnimals(this.noAnimals);
        additionalField.setNoParties(this.noParties);
        additionalField.setBalconyAvailable(this.balconyAvailable);
        additionalField.setShopsNearby(this.shopsNearby);
        return additionalField;
    }
}
