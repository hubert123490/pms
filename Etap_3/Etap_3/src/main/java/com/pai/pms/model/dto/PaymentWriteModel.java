package com.pai.pms.model.dto;

import com.pai.pms.model.entities.Agreement;
import com.pai.pms.model.entities.Payment;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PaymentWriteModel {
    private LocalDate date;
    private double fee;

    public PaymentWriteModel(double fee) {
        this.date = LocalDate.now();
        this.fee = fee;
    }

    public Payment toPayment(Agreement agreement){
        Payment payment = new Payment();
        payment.setDate(this.getDate());
        payment.setFee(this.getFee());
        payment.setAgreement(agreement);
        return payment;
    }
}