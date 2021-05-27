package com.pai.pms.model.dto;

import com.pai.pms.model.entities.*;
import com.pai.pms.payload.request.PaymentRequest;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
public class AgreementWriteModel {
    private LocalDate dateFrom;
    private LocalDate dateTo;

    public AgreementWriteModel(PaymentRequest paymentRequest){
        this.dateFrom = paymentRequest.getDateFrom();
        this.dateTo = paymentRequest.getDateTo();
    }

    public Agreement toAgreement(Client client, Apartment apartment){
        Agreement agreement = new Agreement();
        agreement.setDiscount(1.0);
        agreement.setDeposit(0);
        agreement.setDateFrom(this.getDateFrom());
        agreement.setDateTo(this.getDateTo());
        agreement.setDailyFee(apartment.getPrice());
        agreement.setClient(client);
        agreement.setApartment(apartment);
        agreement.setLandlord(apartment.getLandlord());
        return agreement;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }

}

