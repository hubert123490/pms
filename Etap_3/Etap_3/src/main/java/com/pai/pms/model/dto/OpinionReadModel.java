package com.pai.pms.model.dto;

import com.pai.pms.model.entities.Opinion;
import lombok.Data;

import java.time.LocalDate;

@Data
public class OpinionReadModel {
    private String firstName;
    private String lastName;
    private String text;
    private LocalDate publishedDate;

    public OpinionReadModel(Opinion opinion) {
        this.firstName = opinion.getUser().getName();
        this.lastName = opinion.getUser().getLastName();
        this.text = opinion.getText();
        this.publishedDate = opinion.getPublishedDate();
    }
}
