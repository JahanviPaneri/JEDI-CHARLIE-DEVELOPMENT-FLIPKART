package com.flipfit.client;

import com.flipfit.business.AdminService;
import com.flipfit.bean.GymCenter;
import com.flipfit.bean.GymOwner;
import com.flipfit.bean.GymOwnerWaitlist;
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
                    viewPendingOwnerRequests();
                    break;
                case 2:
                    approveOwnerRequest();
                    break;
                case 3:
                    List<GymCenter> gyms = adminService.viewPendingGyms();
                    for(GymCenter g:gyms){
                        System.out.println("GymId ->" + g.getGymId() + " GymLocation ->" +g.getGymName() + " GymName -->" + g.getGymName());
                    }
                    break;
                case 4:
                    System.out.println("Enter Gym ID to approve:");
                    String gymId = scanner.next();
                    adminService.approveGymCenter(gymId);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private void viewPendingOwnerRequests() {
        List<GymOwnerWaitlist> pendingRequests = adminService.viewPendingWaitlistEntries();
        
        if (pendingRequests.isEmpty()) {
            System.out.println("No pending gym owner requests.");
        } else {
            System.out.println("\n--- Pending Gym Owner Requests ---");
            for (GymOwnerWaitlist request : pendingRequests) {
                System.out.println("Owner ID: " + request.getOwnerId());
                System.out.println("  Email: " + request.getEmail());
                System.out.println("  Account Number: " + request.getAccountNumber());
                System.out.println("  PAN Number: " + request.getPanNumber());
                System.out.println("---");
            }
        }
    }

    private void approveOwnerRequest() {
        System.out.println("Enter Owner ID to approve:");
        String ownerId = scanner.next();
        adminService.approveGymOwner(ownerId);
    }
}