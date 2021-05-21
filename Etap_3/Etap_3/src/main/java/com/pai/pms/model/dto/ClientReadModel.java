package com.pai.pms.model.dto;
import com.pai.pms.model.entities.Client;
import com.pai.pms.model.entities.User;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ClientReadModel {

    private int id;
    private String name;
    private String lastName;
    private String email;
    private int age;
    private int amountOfRents;
    private String occupation;

    public ClientReadModel(Client client) {
        this.id = client.getId();
        this.name = client.getUser().getName();
        this.lastName = client.getUser().getLastName();
        this.email = client.getUser().getEmail();
        this.amountOfRents = client.getAmountOfRents();
        this.age = client.getAge();
        this.occupation = client.getOccupation();
    }
}
