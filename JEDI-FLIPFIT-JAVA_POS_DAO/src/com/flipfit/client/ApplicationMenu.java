package com.flipfit.client;

import com.flipfit.bean.User;
import com.flipfit.business.CustomerService;
import com.flipfit.business.GymOwnerService;
import com.flipfit.business.AdminService;
import com.flipfit.business.UserService;
import com.flipfit.business.UserInterface;
import com.flipfit.exception.RegistrationFailedException;
import com.flipfit.exception.InvalidCredentialsException;

import java.util.Scanner;

public class ApplicationMenu {

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
                scanner.nextLine();
            }
        }
    }

    private static void registerUserFlow(Scanner scanner) {
        try {
            System.out.println("\n=== User Registration ===");
            System.out.println("Select Role to Register:");
            System.out.println("1. Admin");
            System.out.println("2. Customer");
            System.out.println("3. Gym Owner");
            System.out.print("Enter your choice: ");
            int roleChoice = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Email: ");
            String email = scanner.nextLine();
            System.out.print("Enter Phone Number: ");
            String phoneNumber = scanner.nextLine();
            System.out.print("Enter Password: ");
            String password = scanner.nextLine();

            if (roleChoice == 1) {
                System.out.print("Enter Aadhar Number: ");
                String aadhar = scanner.nextLine();
                System.out.print("Enter PAN Number: ");
                String pan = scanner.nextLine();
                new AdminService().registerAdmin(name, email, phoneNumber, password, aadhar, pan);
            } else if (roleChoice == 2) {
                new CustomerService().registerCustomer(name, email, phoneNumber, password);
            } else if (roleChoice == 3) {
                System.out.print("Enter PAN Number: ");
                String pan = scanner.nextLine();
                System.out.print("Enter Aadhar Number: ");
                String aadhar = scanner.nextLine();
                new GymOwnerService().registerOwner(name, email, phoneNumber, password, pan, aadhar);
            } else {
                System.out.println("Invalid Role Selection!");
            }
        } catch (RegistrationFailedException e) {
            System.err.println("Registration Failed: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error during registration: " + e.getMessage());
        }
    }

    private static void login(Scanner scanner) {
        try {
            System.out.println("\n=== User Login ===");
            System.out.print("Enter Email: ");
            String email = scanner.nextLine();
            System.out.print("Enter Password: ");
            String password = scanner.nextLine();

            UserInterface userService = new UserService();
            User user = userService.login(email, password);

            if (user == null) {
                System.out.println("Login Failed. User not found.");
                return;
            }

            String roleName = user.getRole().getRoleName();
            System.out.println("Logged in as: " + roleName);

            if ("Admin".equalsIgnoreCase(roleName)) {
                new AdminMenu().showMenu();
            } else if ("Customer".equalsIgnoreCase(roleName)) {
                new CustomerMenu().showMenu(email);
            } else if ("GymOwner".equalsIgnoreCase(roleName)) {
                new GymOwnerMenu().showMenu(email);
            } else {
                System.out.println("Access Denied: Unknown Role.");
            }

        } catch (InvalidCredentialsException e) {
            System.err.println("Login Failed: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error during login: " + e.getMessage());
            e.printStackTrace();
        }
    }
}