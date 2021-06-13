package com.pai.pms.entities;

import com.pai.pms.model.entities.Agreement;
import com.pai.pms.model.entities.Apartment;
import com.pai.pms.model.entities.Opinion;
import com.pai.pms.model.entities.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
public class Landlord {
    private int id;
    private int idCard;
    private User user;
    private Set<Opinion> opinions;
    private Set<Apartment> apartments;
    private Set<Agreement> agreements;

    public Landlord(int id, int idCard, User user, Set<Opinion> opinions, Set<Apartment> apartments,
                    Set<Agreement> agreements) {
        this.id = id;
        this.idCard = idCard;
        this.user = user;
        this.opinions = opinions;
        this.apartments = apartments;
        this.agreements = agreements;
    }
}
