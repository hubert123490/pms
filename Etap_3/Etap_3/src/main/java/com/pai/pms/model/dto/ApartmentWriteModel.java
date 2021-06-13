package com.pai.pms.model.dto;

import com.pai.pms.model.entities.Apartment;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class ApartmentWriteModel {
    private String name;
    private boolean discount;
    private int roomNumber;
    private int sleepingPlaces;
    private int flatArea;
    private boolean isEmpty;
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private double price;
    private boolean wiFi;
    private boolean parkingAvailable;
    private String photo;
    private String type;

    public ApartmentWriteModel(Apartment apartment){
        this.name = apartment.getName();
        this.discount = apartment.isDiscount();
        this.roomNumber = apartment.getRoomNumber();
        this.sleepingPlaces = apartment.getSleepingPlaces();
        this.flatArea = apartment.getFlatArea();
        this.isEmpty = apartment.isEmpty();
        this.dateFrom = apartment.getDateFrom();
        this.dateTo = apartment.getDateTo();
        this.price = apartment.getPrice();
        this.wiFi = apartment.isWiFi();
        this.parkingAvailable = apartment.isParkingAvailable();
        this.photo = apartment.getPhoto();
        this.type = apartment.getType();
    }

   public Apartment toApartment(){
       Apartment apartment = new Apartment();
       apartment.setName(this.name);
       apartment.setDiscount(this.discount);
       apartment.setRoomNumber(this.roomNumber);
       apartment.setSleepingPlaces(this.sleepingPlaces);
       apartment.setFlatArea(this.flatArea);
       apartment.setEmpty(this.isEmpty);
       apartment.setDateFrom(this.dateFrom);
       apartment.setDateTo(this.dateTo);
       apartment.setPrice(this.price);
       apartment.setWiFi(this.wiFi);
       apartment.setParkingAvailable(this.parkingAvailable);
       apartment.setPhoto(this.photo);
       apartment.setType(this.type);
       return apartment;
   }

   public void updateEntity(Apartment apartment){
       apartment.setName(this.name);
       apartment.setDiscount(this.discount);
       apartment.setRoomNumber(this.roomNumber);
       apartment.setSleepingPlaces(this.sleepingPlaces);
       apartment.setFlatArea(this.flatArea);
       apartment.setEmpty(this.isEmpty);
       apartment.setDateFrom(this.dateFrom);
       apartment.setDateTo(this.dateTo);
       apartment.setPrice(this.price);
       apartment.setWiFi(this.wiFi);
       apartment.setParkingAvailable(this.parkingAvailable);
       apartment.setPhoto(this.photo);
       apartment.setType(this.type);
   }
}
