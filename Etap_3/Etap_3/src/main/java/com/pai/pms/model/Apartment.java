package com.pai.pms.model;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "apartments")
public class Apartment {
    @Id
    @GeneratedValue(generator = "inc")
    @GenericGenerator(name = "inc", strategy = "increment")
    private int id;
    private String name;
    private int roomNumber;
    private int sleepingPlaces;
    private int flatArea;
    private boolean isEmpty;
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private double price;
    private boolean parking;
    private boolean wiFi;
    private String photo;

    @JoinColumn(name = "address_id")
    @OneToOne
    private Address address;
    @JoinColumn(name = "landlord_id")
    @ManyToOne
    private Landlord landlord;
    @OneToOne(mappedBy = "apartment")
    private Agreement agreement;
    @JoinColumn(name = "additional_field_id")
    @OneToOne
    private AdditionalFields additionalFields;

}
