package com.pai.pms.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "opinions")
public class Opinion {
    @Id
    @GeneratedValue(generator = "inc")
    @GenericGenerator(name = "inc", strategy = "increment")
    private int id;
    @NotBlank
    private String text;
    @JoinColumn(name = "tenant_id")
    @ManyToOne
    private Tenant tenant;
    @JoinColumn(name = "landlord_id")
    @ManyToOne
    private Landlord landlord;
}