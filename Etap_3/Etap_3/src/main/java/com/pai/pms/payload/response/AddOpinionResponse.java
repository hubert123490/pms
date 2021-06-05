package com.pai.pms.payload.response;

import com.pai.pms.model.entities.Opinion;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AddOpinionResponse {
    private int id;
    private String text;
    private LocalDate publishedDate;
    private int clientId;
    private int apartmentId;
    private int userId;

    public AddOpinionResponse(Opinion opinion) {
        this.id = opinion.getId();
        this.text = opinion.getText();
        this.publishedDate = opinion.getPublishedDate();
        this.clientId = opinion.getClient().getId();
        this.apartmentId = opinion.getApartment().getId();
        this.userId = opinion.getUser().getId();
    }
}