package com.pai.pms.model;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tenants")
public class Tenant {
    @Id
    @GeneratedValue(generator = "inc")
    @GenericGenerator(name = "inc", strategy = "increment")
    private int id;
    @OneToOne(mappedBy = "tenant")
    private User user;
    @OneToMany(mappedBy = "tenant")
    private Set<Opinion> opinions;
    @OneToOne(mappedBy = "tenant")
    private Rent rent;
}
