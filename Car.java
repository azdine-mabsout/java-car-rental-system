/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.car_rental_system;

/**
 *
 * @author PC
 */
public class Car {
    private String cardId;
    private String brand ;
    private String model;
    private double basePricePerDay;
    private boolean isAvailable;
    public Car(String cardId,String brand,String model,double basePricePerDay,boolean isAvailable){
        this.cardId=cardId;
        this.brand=brand;
        this.model=model;
        this.basePricePerDay=basePricePerDay;
        this.isAvailable=isAvailable;
    }
    public String getCardId(){
        return cardId;
    }
    public String getbrand(){
        return brand;
    }
    public String getmodel(){
        return model;
    }
    public double calculatePrice(int rentalday){
        return basePricePerDay*rentalday;
    }
    public boolean isAvailable(){
        return isAvailable;
    }
    public void rent(){
        isAvailable = false;
    }
    public void returncar(){
        isAvailable = true;
    }
    
    
}
