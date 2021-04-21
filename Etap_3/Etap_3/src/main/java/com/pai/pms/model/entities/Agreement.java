package com.pai.pms.model.entities;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Table(name = "agreements")
public class Agreement {
    @Id
    @GeneratedValue(generator = "inc")
    @GenericGenerator(name = "inc", strategy = "increment")
    private int id;
    private double discount;
    private double deposit;
    @NotBlank
    private LocalDate dateFrom;
    @NotBlank
    private LocalDate dateTo;
    @NotBlank
    private double monthlyFee;
    @JoinColumn(name = "client_id")
    @OneToOne
    private Client client;
    @JoinColumn(name = "apartment_id")
    @OneToOne
    private Apartment apartment;
    @JoinColumn(name = "landlord_id")
    @OneToOne
    private Landlord landlord;
    @OneToOne(mappedBy = "agreement")
    private Payment payment;

    public Agreement() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
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

    public double getMonthlyFee() {
        return monthlyFee;
    }

    public void setMonthlyFee(double monthlyFee) {
        this.monthlyFee = monthlyFee;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }

    public Landlord getLandlord() {
        return landlord;
    }

    public void setLandlord(Landlord landlord) {
        this.landlord = landlord;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
