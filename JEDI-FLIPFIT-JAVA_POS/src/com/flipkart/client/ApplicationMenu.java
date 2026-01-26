package com.flipkart.client;

import com.flipkart.business.CustomerService;
import com.flipkart.business.GymOwnerService;

import java.util.Scanner;

public class ApplicationMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to FlipFit Application");

        while (true) {
            System.out.println("1. Login");
            System.out.println("2. Register Customer");
            System.out.println("3. Register Gym Owner");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    login(scanner);
                    break;
                case 2:
                    registerCustomer(scanner);
                    break;
                case 3:
                    registerGymOwner(scanner);
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }

    private static void login(Scanner scanner) {
        System.out.println("Enter Username:");
        String user = scanner.next();
        System.out.println("Enter Password:");
        String pass = scanner.next();
        System.out.println("Enter Role (1: Admin, 2: Customer, 3: Owner):");
        int role = scanner.nextInt();

        // verify credentials

        if (role == 1) {
            new AdminMenu().showMenu();
        } else if (role == 2) {
            new CustomerMenu().showMenu(user);
        } else if (role == 3) {
            new GymOwnerMenu().showMenu(user);
        }
    }

    private static void registerCustomer(Scanner scanner) {
        System.out.println("Enter Username:");
        String name = scanner.next();
        System.out.println("Enter email:");
        String email = scanner.next();
        System.out.println("Enter phoneNumber:");
        String phoneNumber = scanner.next();
        System.out.println("Enter Password:");
        String password = scanner.next();

        CustomerService customerService=new CustomerService();
        customerService.registerCustomer(name,email,phoneNumber,password);

    }

    private static void registerGymOwner(Scanner scanner) {
        System.out.println("Enter Username:");
        String name = scanner.next();
        System.out.println("Enter email:");
        String email = scanner.next();
        System.out.println("Enter phoneNumber:");
        String phoneNumber = scanner.next();
        System.out.println("Enter Password:");
        String password = scanner.next();

        GymOwnerService gymOwnerService=new GymOwnerService();
        gymOwnerService.registerOwner(name,email,phoneNumber,password);
    }
}