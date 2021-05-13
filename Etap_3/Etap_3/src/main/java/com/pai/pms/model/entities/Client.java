package com.pai.pms.model.entities;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(generator = "inc")
    @GenericGenerator(name = "inc", strategy = "increment")
    private int id;
    private int amountOfRents;
    private int age;
    @NotBlank
    private String occupation;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "client")
    private List<Opinion> opinions;

    @OneToOne(mappedBy = "client")
    private Agreement agreement;

    public Client() {
    }

    public Client(int amountOfRents, int age, String occupation, User user) {
        this.amountOfRents = amountOfRents;
        this.age = age;
        this.occupation = occupation;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmountOfRents() {
        return amountOfRents;
    }

    public void setAmountOfRents(int amountOfRents) {
        this.amountOfRents = amountOfRents;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }


    public void setUser(User user) {
        this.user = user;
    }


    public void setOpinions(List<Opinion> opinions) {
        this.opinions = opinions;
    }

    public void setAgreement(Agreement agreement) {
        this.agreement = agreement;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
