package com.pai.pms.entities;

import com.pai.pms.model.entities.Apartment;
import com.pai.pms.model.entities.Client;
import com.pai.pms.model.entities.Landlord;
import com.pai.pms.model.entities.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class Opinion {
    private int id;
    private String text;
    private LocalDate publishedDate;
    private Client client;
    private Landlord landlord;
    private Apartment apartment;
    private User user;

    public Opinion(int id, String text, LocalDate publishedDate, Client client, Landlord landlord,
                   Apartment apartment, User user) {
        this.id = id;
        this.text = text;
        this.publishedDate = publishedDate;
        this.client = client;
        this.landlord = landlord;
        this.apartment = apartment;
        this.user = user;
    }
}
