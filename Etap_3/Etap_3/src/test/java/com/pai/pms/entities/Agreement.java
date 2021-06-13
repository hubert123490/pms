package com.pai.pms.entities;

import com.pai.pms.model.entities.Apartment;
import com.pai.pms.model.entities.Client;
import com.pai.pms.model.entities.Landlord;
import com.pai.pms.model.entities.Payment;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class Agreement {
    private int id;
    private double discount;
    private double deposit;
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private double dailyFee;
    private Client client;
    private Apartment apartment;
    private Landlord landlord;
    private Payment payment;

    public Agreement(int id, double discount, double deposit, LocalDate dateFrom, LocalDate dateTo,
                     double dailyFee, Client client, Apartment apartment, Landlord landlord, Payment payment) {
        this.id = id;
        this.discount = discount;
        this.deposit = deposit;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.dailyFee = dailyFee;
        this.client = client;
        this.apartment = apartment;
        this.landlord = landlord;
        this.payment = payment;
    }
}
