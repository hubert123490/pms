package com.pai.pms.model.dto;

import com.pai.pms.model.entities.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@NoArgsConstructor
public class AgreementWriteModel {
    private double discount;
    private double deposit;
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private double dailyFee;

    public AgreementWriteModel(double discount, double deposit, LocalDate dateFrom, LocalDate dateTo,
                               double dailyFee) {
        this.discount = discount;
        this.deposit = deposit;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.dailyFee = dailyFee;
    }

    public Agreement toAgreement(Client client, Apartment apartment, Payment payment){
        Agreement agreement = new Agreement();

        agreement.setDiscount(this.getDiscount());
        agreement.setDeposit(this.getDeposit());
        agreement.setDateFrom(this.getDateFrom());
        agreement.setDateTo(this.getDateTo());
        agreement.setDailyFee(this.getDailyFee());
        agreement.setClient(client);
        agreement.setApartment(apartment);
        agreement.setLandlord(apartment.getLandlord());
        agreement.setPayment(payment);

        return agreement;
    }

    public void setAgreementFields(Agreement agreement){
        agreement.setDiscount(this.getDiscount());
        agreement.setDeposit(this.getDeposit());
        agreement.setDateFrom(this.getDateFrom());
        agreement.setDateTo(this.getDateTo());
        agreement.setDailyFee(this.getDailyFee());
    }
}

