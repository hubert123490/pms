package com.pai.pms.model.dto;

import com.pai.pms.model.entities.TouristAttraction;
import lombok.Data;

@Data
public class TouristAttractionDetailReadModel {

    private int id;
    private String name;
    private String description;
    private int number;
    private int buildingNumber;
    private String street;
    private String city;

    public TouristAttractionDetailReadModel(TouristAttraction touristAttraction) {
        this.id = touristAttraction.getId();
        this.name = touristAttraction.getName();
        this.description = touristAttraction.getDescription();
        this.number = touristAttraction.getAddress().getApartmentNumber();
        this.buildingNumber = touristAttraction.getAddress().getApartmentBuilding();
        this.street = touristAttraction.getAddress().getStreet();
        this.city = touristAttraction.getAddress().getCity();
    }
}
