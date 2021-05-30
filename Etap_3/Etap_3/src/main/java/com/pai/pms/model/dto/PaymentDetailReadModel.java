package com.pai.pms.model.dto;

import com.pai.pms.model.entities.Payment;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PaymentDetailReadModel {
    private int paymentId;
    private String apartmentName;
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private double fee;
    private boolean paymentDone;

    public PaymentDetailReadModel(Payment payment){
        this.paymentId = payment.getId();
        this.apartmentName = payment.getAgreement().getApartment().getName();
        this.dateFrom = payment.getAgreement().getDateFrom();
        this.dateTo = payment.getAgreement().getDateTo();
        this.fee = payment.getFee();
        this.paymentDone = payment.isPaymentDone();
    }
}
