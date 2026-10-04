/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.car_rental_system;

/**
 *
 * @author PC
 */
public class Rental {
    private Car car ;
    private Customer customer;
    private int days ;
    public Rental(Car car,Customer customer,int days){
        this.car=car;
        this.customer=customer;
        this.days=days;
    }
    public Car getcar(){
        return car;
    }
    public Customer getcustomer(){
        return customer;
    }
    public int getdays(){
        return days;
    }
}
