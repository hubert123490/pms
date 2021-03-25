package com.pai.pms.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Table(name = "rents")
public class Rent {
    @Id
    @GeneratedValue(generator = "inc")
    @GenericGenerator(name = "inc", strategy = "increment")
    private int id;
    @NotBlank
    private LocalDate dateFrom;
    @NotBlank
    private LocalDate dateTo;
    @NotBlank
    private double monthlyFee;
    @JoinColumn(name = "tenant_id")
    @OneToOne
    private Tenant tenant;
    @JoinColumn(name = "apartment_id")
    @OneToOne
    private Apartment apartment;


}