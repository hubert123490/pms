package com.pai.pms.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "landlords")
public class Landlord {
    @Id
    @GeneratedValue(generator = "inc")
    @GenericGenerator(name = "inc", strategy = "increment")
    private int id;
    @OneToOne(mappedBy = "landlord")
    private User user;
    @OneToMany(mappedBy = "landlord")
    private Set<Opinion> opinions;
    @OneToMany(mappedBy = "landlord")
    private Set<Apartment> apartments;

}
