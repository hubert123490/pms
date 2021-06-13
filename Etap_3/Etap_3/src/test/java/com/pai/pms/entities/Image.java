package com.pai.pms.entities;

import com.pai.pms.model.entities.Apartment;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Image {
    Long id;
    String name;
    String location;
    private Apartment apartment;

    public Image(Long id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }
}
