package com.pai.pms.model.dto;

import com.pai.pms.model.entities.Image;
import lombok.Data;

@Data
public class ImageReadModel {
    private long id;
    private String url;

    public ImageReadModel(){
        this.url = "";
    }

    public ImageReadModel(Image image){
        this.id = image.getId();
        this.url = "http://localhost:8090/file-system/image/" + image.getId();
    }
}
