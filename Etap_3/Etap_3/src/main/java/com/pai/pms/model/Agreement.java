package com.pai.pms.model;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "agreements")
public class Agreement {
    @Id
    @GeneratedValue(generator = "inc")
    @GenericGenerator(name = "inc", strategy = "increment")
    private int id;
    private double discount;
    private double deposit;
    @JoinColumn(name = "client_id")
    @OneToOne
    private Client client;
    @JoinColumn(name = "landlord_id")
    @OneToOne
    private Landlord landlord;


}
