package com.pai.pms.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Table(name = "rentalHistory")
public class RentalHistory {
    @Id
    @GeneratedValue(generator = "inc")
    @GenericGenerator(name = "inc", strategy = "increment")
    private int id;

    @OneToOne
    @JoinColumn(name = "rents_id")
    private Rent rent;
}