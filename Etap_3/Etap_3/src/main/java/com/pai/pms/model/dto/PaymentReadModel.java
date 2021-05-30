package com.pai.pms.model.dto;

import com.pai.pms.model.entities.Payment;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PaymentReadModel {
    private int id;
    private LocalDate date;
    private double fee;
    private int agreementId;
    private boolean paymentDone;

    public PaymentReadModel(Payment payment){
        this.id = payment.getId();
        this.date = payment.getDate();
        this.fee = payment.getFee();
        this.agreementId = payment.getAgreement().getId();
        this.paymentDone = payment.isPaymentDone();
    }
}

