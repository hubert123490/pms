package com.pai.pms.model.dto;

import com.pai.pms.model.entities.Agreement;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AgreementReadModel {
    int id;
    double discount;
    double deposit;
    LocalDate dateFrom;
    LocalDate dateTo;
    double dailyFee;
    int clientId;
    int landlordId;
    int apartmentId;

    public AgreementReadModel(Agreement agreement){
        this.id = agreement.getId();
        this.discount = agreement.getDiscount();
        this.deposit = agreement.getDeposit();
        this.dateFrom = agreement.getDateFrom();
        this.dateTo = agreement.getDateTo();
        this.dailyFee = agreement.getDailyFee();
        this.clientId = agreement.getClient().getId();
        this.landlordId = agreement.getLandlord().getId();
        this.apartmentId = agreement.getApartment().getId();
    }

}

