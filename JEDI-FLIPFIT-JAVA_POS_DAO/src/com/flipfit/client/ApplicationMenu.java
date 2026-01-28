package com.flipfit.client;

import com.flipfit.business.CustomerService;
import com.flipfit.business.GymOwnerService;
import com.flipfit.business.AdminService;
import com.flipfit.exception.RegistrationFailedException;
import com.flipfit.exception.InvalidCredentialsException;

import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * The Class ApplicationMenu.
 * Main entry point for the FlipFit application with user menu.
 *
 * @author FlipFit Development Team
 * @version 1.0
 */
public class ApplicationMenu {
    
    /**
     * The main method.
     * Entry point of the FlipFit application.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Welcome to FlipFit Application ===");

        while (true) {
            try {
                System.out.println("\n1. Login");
                System.out.println("2. Register User");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        login(scanner);
                        break;
                    case 2:
                        registerUserFlow(scanner);
                        break;
                    case 3:
                        System.out.println("Exiting Application... Thank you!");
                        scanner.close();
                        System.exit(0);
                    default:
                        System.out.println("Invalid Choice! Please try again.");
                }
            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
                scanner.nextLine(); // Clear invalid input
            }
        }
    }

    /**
     * Register user flow.
     * Handles user registration based on selected role.
     *
     * @param scanner the scanner for user input
     */
    private static void registerUserFlow(Scanner scanner) {
        try {
            System.out.println("\n=== User Registration ===");
            System.out.println("Select Role to Register:");
            System.out.println("1. Admin");
            System.out.println("2. Customer");
            System.out.println("3. Gym Owner");
            System.out.print("Enter your choice: ");
            int roleChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Email: ");
            String email = scanner.nextLine();
            System.out.print("Enter Phone Number: ");
            String phoneNumber = scanner.nextLine();
            System.out.print("Enter Password: ");
            String password = scanner.nextLine();

            if (roleChoice == 1) {
                new AdminService().registerAdmin(name, email, phoneNumber, password);
                System.out.println("Admin registration successful!");
            } else if (roleChoice == 2) {
                new CustomerService().registerCustomer(name, email, phoneNumber, password);
                System.out.println("Customer registration successful!");
            } else if (roleChoice == 3) {
                new GymOwnerService().registerOwner(name, email, phoneNumber, password);
                System.out.println("Gym Owner registration successful!");
            } else {
                System.out.println("Invalid Role Selection!");
            }
        } catch (RegistrationFailedException e) {
            System.err.println("Registration Failed: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error during registration: " + e.getMessage());
        }
    }

    /**
     * Login.
     * Handles user login and redirects to appropriate menu.
     *
     * @param scanner the scanner for user input
     */
    private static void login(Scanner scanner) {
        try {
            System.out.println("\n=== User Login ===");
            System.out.print("Enter Email: ");
            scanner.nextLine(); // Consume newline
            String email = scanner.nextLine();
            System.out.print("Enter Password: ");
            String password = scanner.nextLine();
            System.out.println("Select Role:");
            System.out.println("1. Admin");
            System.out.println("2. Customer");
            System.out.println("3. Gym Owner");
            System.out.print("Enter your choice: ");
            int role = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (role == 1) {
                // Admin login validation would go here
                new AdminMenu().showMenu();
            } else if (role == 2) {
                CustomerService customerService = new CustomerService();
                if (customerService.login(email, password)) {
                    new CustomerMenu().showMenu(email);
                }
            } else if (role == 3) {
                // Gym Owner login validation would go here
                new GymOwnerMenu().showMenu(email);
            } else {
                System.out.println("Invalid Role Selection!");
            }
        } catch (InvalidCredentialsException e) {
            System.err.println("Login Failed: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error during login: " + e.getMessage());
        }
    }
}