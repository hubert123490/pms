package com.pai.pms.model.dto;

import com.pai.pms.model.entities.Apartment;
import com.pai.pms.model.entities.Opinion;
import lombok.Data;

@Data
public class OpinionReadModel {
    private String firstName;
    private String lastName;
    private String text;

    public OpinionReadModel(Opinion opinion) {
        this.firstName = opinion.getUser().getName();
        this.lastName = opinion.getUser().getLastName();
        this.text = opinion.getText();
    }
}
