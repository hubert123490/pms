package com.pai.pms.model.dto;

import com.pai.pms.model.entities.Payment;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PaymentReadModel {
    int id;
    LocalDate date;
    double fee;
    int agreementId;

    public PaymentReadModel(Payment payment){
        this.id = payment.getId();
        this.date = payment.getDate();
        this.fee = payment.getFee();
        this.agreementId = payment.getAgreement().getId();
    }
}

