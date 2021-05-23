package com.pai.pms.model.dto;
import com.pai.pms.model.entities.Landlord;
import lombok.Data;

@Data
public class LandlordReadModel {
    private int id;
    private String name;
    private String lastName;
    private String email;
    private int phone;
    private int idCard;

    public LandlordReadModel(Landlord landlord) {
        this.id = landlord.getId();
        this.name = landlord.getUser().getName();
        this.lastName = landlord.getUser().getLastName();
        this.idCard = landlord.getIdCard();
        this.phone = landlord.getUser().getPhone();
        this.email = landlord.getUser().getEmail();
    }
}
