package com.pai.pms.model.dto;

import com.pai.pms.model.entities.Agreement;
import com.pai.pms.model.entities.Payment;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class PaymentWriteModel {

    public Payment toPayment(Agreement agreement){
        Payment payment = new Payment();
        payment.setDate(LocalDate.now());
        payment.setPaymentDone(false);
        payment.setFee((DAYS.between(agreement.getDateFrom(), agreement.getDateTo()) * agreement.getApartment().getPrice())* (agreement.getApartment().isDiscount() ? 0.9 : 1)); //calculating fee from period
        payment.setAgreement(agreement);
        return payment;
    }
}