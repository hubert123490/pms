package com.pai.pms.entities;

import com.pai.pms.model.entities.Agreement;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class Payment {
    private int id;
    private LocalDate date;
    private double fee;
    private boolean paymentDone;
    private Agreement agreement;

    public Payment(int id, LocalDate date, double fee, boolean paymentDone, Agreement agreement) {
        this.id = id;
        this.date = date;
        this.fee = fee;
        this.paymentDone = paymentDone;
        this.agreement = agreement;
    }
}
