package com.pai.pms.model;


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
}
