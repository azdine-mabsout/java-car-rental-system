/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.car_rental_system;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author PC
 */
public class CarRentalSystem {
    private List<Car> cars ;
    private List<Customer> customers ;
    private List<Rental> rentals ;
    
    public CarRentalSystem(){
        cars = new ArrayList<>();
        customers = new ArrayList<>();
        rentals = new ArrayList<>();
        
    }
    public void addCar(Car car){
        cars.add(car);
    }
    public void addCustomer(Customer customer){
        customers.add(customer);
    }
    public void rentCar(Car car,Customer customer,int days){
        if(car.isAvailable()){
            car.rent();
            rentals.add(new Rental(car,customer,days));
        }
        else{
            System.out.println("Car is not available for rent.");
        }
    }
    public void returnCar(Car car) {
        
        car.returncar();

    Rental rentalToRemove = null;

    for (Rental rental : rentals) {
         if (rental.getcar() == car) {
           rentalToRemove = rental;
            break;
        }
    }
    
    if (rentalToRemove != null) {
        rentals.remove(rentalToRemove);
        System.out.println("Car returned successfully.");
    } else {
        System.out.println("Car was not rented.");
    }
}
    public void menu(){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("--- Car Rental System ---");
            System.out.println("1. Rent a Car");
            System.out.println("2. Return a Car");
            System.out.println("3. Exit");
           
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline
            
            if(choice == 1){
                System.out.println("-- Rent a car : --");
                System.out.println("Enter your name :");
                String customername = sc.nextLine();
                System.out.println("Available Cars :");
                for(Car car : cars){
                    if(car.isAvailable()){
                        System.out.println(car.getCardId()+ " "+ car.getbrand()+ " "+ car.getmodel());
                        
                    }
                }
                System.out.println("Enter the car id you want to rent :");
                String carId = sc.nextLine();
                System.out.println("Enter the number of day for rental : :");
                int rentalsDays = sc.nextInt();
                sc.nextLine();
                Customer newCustomer = new Customer("CUS"+ (customers.size()+1),customername);
                addCustomer(newCustomer);
                Car selectedcar = null ;
                for(Car car:cars){
                    if(car.getCardId().equals(carId) && car.isAvailable()){
                        selectedcar = car;
                        break;
                    }
                }
                if(selectedcar!=null){
                    double totalprice = selectedcar.calculatePrice(rentalsDays);
                    System.out.println("----Rentals Informations :----");
                    System.out.println("Customer Id :"+ newCustomer.getcustomerId());
                    System.out.println("Customer Name :"+ newCustomer.getname());
                    System.out.println("Car :"+ selectedcar.getbrand()+ " "+ selectedcar.getmodel());
                    System.out.println("Rental days : "+rentalsDays );
                    System.out.println("Total price $"+totalprice );
                    System.out.println("Confirm Rental (Y/N) :");
                    String confirm = sc.nextLine();
                    if(confirm.equalsIgnoreCase("Y")){
                        rentCar(selectedcar,newCustomer,rentalsDays);
                        System.out.println("Car rented succefully.");

                    }
                    else{
                        System.out.println("Rental canceled");
                        

                    }
                }
                else{
                    System.out.println("Invalid car selection or car not available for rent.");
                }
            }
            else if(choice==2){
                System.out.println("== Return a Car ==");
                System.out.println("Enter the carId you want to return :");
                String cardId = sc.nextLine();
                Car carToReturn = null;
                for(Car car : cars){
                    if(car.getCardId().equals(cardId) && !car.isAvailable()){
                        carToReturn = car;
                        break;
                    }
                }
                if(carToReturn !=null){
                    Customer customer = null ;
                    for(Rental rental:rentals){
                        if(rental.getcar() == carToReturn){
                            customer = rental.getcustomer();
                            break;
                        }
                    }
                    if(customer != null){
                        returnCar(carToReturn);
                        System.out.println("Car returned succefully by"+ customer.getname());
                    } else{
                        System.out.println("Car was not rented  or rental informaation is missing.");
                    }
                }
                else{
                    System.out.println("Invalid car ID or car is not rented.");
                }
            } else if(choice == 3){
                break;
            }
            else {
                System.out.println("Invalid choice. please enter a valid option");
            }
        }
        System.out.println("Thank you for using the Car Rental System.");
        
    }
    
}
