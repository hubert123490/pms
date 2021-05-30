package com.pai.pms.payload.request;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class PaymentRequest {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateFrom;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateTo;
    private int apartmentId;

    public PaymentRequest(LocalDate dateFrom, LocalDate dateTo, int apartmentId) {
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.apartmentId = apartmentId;
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

    public int getApartmentId() {
        return apartmentId;
    }

    public void setApartmentId(int apartmentId) {
        this.apartmentId = apartmentId;
    }
}
