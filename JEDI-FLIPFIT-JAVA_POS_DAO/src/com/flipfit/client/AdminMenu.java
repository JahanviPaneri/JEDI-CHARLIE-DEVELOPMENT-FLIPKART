package com.flipfit.client;

import com.flipfit.business.AdminService;
import com.flipfit.bean.GymCenter;
import com.flipfit.bean.GymOwner;
import java.util.List;
import java.util.Scanner;

public class AdminMenu {
    Scanner scanner = new Scanner(System.in);
    AdminService adminService = new AdminService();

    public void showMenu() {
        while (true) {
            System.out.println("\n--- Admin Menu ---");
            System.out.println("1. View Pending Gym Owner Requests");
            System.out.println("2. Approve Gym Owner");
            System.out.println("3. View Pending Gym Center Requests");
            System.out.println("4. Approve Gym Center");
            System.out.println("5. Logout");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    List<GymOwner> owners = adminService.viewPendingOwners();
                    System.out.println("\n--- Pending Gym Owners ---");
                    for(GymOwner owner : owners){
                        System.out.println("ID: " + owner.getOwnerId() + " | Name: " + owner.getName() + " | Email: " + owner.getEmail());
                    }
                    break;
                case 2:
                    System.out.println("Enter Owner ID to approve:");
                    String ownerId = scanner.next();
                    adminService.approveGymOwner(ownerId);
                    break;
                case 3:
                    List<GymCenter> gyms = adminService.viewPendingGyms();
                    System.out.println("\n--- Pending Gym Centers ---");
                    for(GymCenter g : gyms){
                        System.out.println("ID: " + g.getGymId() + " | Name: " + g.getGymName() + " | Location: " + g.getGymLocation());
                    }
                    break;
                case 4:
                    System.out.println("Enter Gym ID to approve:");
                    String gymId = scanner.next();
                    adminService.approveGymCenter(gymId);
                    break;
                case 5:
                    return; // Go back to main menu
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}