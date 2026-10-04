/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.car_rental_system;
/**
 *
 * @author PC
 */
public class Car_Rental_System {

    public static void main(String[] args) {
        CarRentalSystem rentalSystem = new CarRentalSystem();
        Car car1 = new Car("C001", "Toyota", "Camry", 60.0,true); // Different base price per day for each car
        Car car2 = new Car("C002", "Honda", "Accord", 70.0,true);
        Car car3 = new Car("C003", "Mahindra", "Thar", 150.0,true);
        rentalSystem.addCar(car1);
        rentalSystem.addCar(car2);
        rentalSystem.addCar(car3);
        rentalSystem.menu();
    }
}
