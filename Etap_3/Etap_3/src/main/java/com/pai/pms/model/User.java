package com.pai.pms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(generator = "inc")
    @GenericGenerator(name = "inc", strategy = "increment")
    private int id;
    @NotBlank
    private String email;
    @NotBlank
    private String login;
    @OneToOne
    @JoinColumn(name = "tenant_id")
    private Tenant tenant;
    @OneToOne
    @JoinColumn(name = "landlord_id")
    private Landlord landlord;



}
