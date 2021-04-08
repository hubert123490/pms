package com.pai.pms.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(generator = "inc")
    @GenericGenerator(name = "inc", strategy = "increment")
    private int number;
    private String street;
    private String postcode;
    private String city;
    private String country;
    @OneToOne(mappedBy = "address")
    private Apartment apartment;
}
