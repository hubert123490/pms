package com.pai.pms.entities;

import com.pai.pms.model.entities.Agreement;
import com.pai.pms.model.entities.Opinion;
import com.pai.pms.model.entities.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
public class Client {
    private int id;
    private int amountOfRents;
    private int age;
    private String occupation;
    private User user;
    private List<Opinion> opinions;
    private Set<Agreement> agreements;

    public Client(int id, int amountOfRents, int age, String occupation, User user, List<Opinion> opinions,
                  Set<Agreement> agreements) {
        this.id = id;
        this.amountOfRents = amountOfRents;
        this.age = age;
        this.occupation = occupation;
        this.user = user;
        this.opinions = opinions;
        this.agreements = agreements;
    }
}
