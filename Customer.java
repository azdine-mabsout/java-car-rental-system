/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.car_rental_system;

/**
 *
 * @author PC
 */
public class Customer {
    private String customerId ;
    private String name ;
    public Customer(String customerId,String name){
        this.customerId=customerId;
        this.name=name;
    }
    public String getcustomerId(){
        return customerId;
    }
    public String getname(){
        return name;
    }
}
