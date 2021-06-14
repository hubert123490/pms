package com.pai.pms.model.dto;
import com.pai.pms.model.entities.Client;
import com.pai.pms.model.entities.Landlord;
import lombok.Data;

@Data
public class LandlordClientReadModel {
    private int id;
    private String name;
    private String lastName;
    private int age;
    private int amountOfRents;
    private String email;


    public LandlordClientReadModel(Landlord landlord) {
        this.id = landlord.getId();
        this.name = landlord.getUser().getName();
        this.lastName = landlord.getUser().getLastName();
        this.email = landlord.getUser().getEmail();
    }

    public LandlordClientReadModel(Client client) {
        this.id = client.getId();
        this.name = client.getUser().getName();
        this.lastName = client.getUser().getLastName();
        this.amountOfRents = client.getAmountOfRents();
        this.email = client.getUser().getEmail();
    }
}
