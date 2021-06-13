package com.pai.pms.model.dto;

import com.pai.pms.model.entities.TouristAttraction;
import lombok.Data;

@Data
public class TouristAttractionReadModel {

        private int id;
        private String name;
        private String city;
        private String firstImage;
        private String secondImage;

        public TouristAttractionReadModel(TouristAttraction touristAttraction) {
            this.id = touristAttraction.getId();
            this.name = touristAttraction.getName();
            this.city = touristAttraction.getAddress().getCity();
            this.firstImage = touristAttraction.getFirstImage();
            this.secondImage = touristAttraction.getSecondImage();
        }
}
