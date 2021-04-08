package com.pai.pms.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "additional_fields")
public class AdditionalFields {
    @Id
    @GeneratedValue(generator = "inc")
    @GenericGenerator(name = "inc", strategy = "increment")
    private int id;
    @OneToOne(mappedBy = "additionalFields")
    private Apartment apartment;
}
