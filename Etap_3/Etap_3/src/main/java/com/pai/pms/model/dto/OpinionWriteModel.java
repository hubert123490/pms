package com.pai.pms.model.dto;

import com.pai.pms.model.entities.Opinion;
import com.pai.pms.model.entities.Payment;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
public class OpinionWriteModel {
    private String opinion;

    public OpinionWriteModel() {
        this.opinion = "";
    }

    public OpinionWriteModel(String opinion) {
        this.opinion = opinion;
    }

    public Opinion toOpinion(Payment payment){
        Opinion opinion = new Opinion();
        opinion.setText(this.opinion);
        opinion.setPublishedDate(LocalDate.now());
        opinion.setUser(payment.getAgreement().getClient().getUser());
        opinion.setClient(payment.getAgreement().getClient());
        opinion.setApartment(payment.getAgreement().getApartment());
        return opinion;
    }
}
