package com.flipfit.client;

import com.flipfit.bean.GymCenter;
import com.flipfit.bean.Slot;
import com.flipfit.business.GymOwnerService;
import com.flipfit.business.GymCenterService;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class GymOwnerMenu {
    Scanner scanner = new Scanner(System.in);
    GymOwnerService ownerService = new GymOwnerService();
    GymCenterService gymService = new GymCenterService();

    public void showMenu(String ownerId) {
        while (true) {
            System.out.println("\n--- Gym Owner Menu ---");
            System.out.println("1. Add Gym Center");
            System.out.println("2. Add Slot to Gym");
            System.out.println("3. View My Gyms");
            System.out.println("4. Logout");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter Gym Name:");
                    String gymName = scanner.next();
                    System.out.println("Enter Gym Location:");
                    String gymLocation = scanner.next();
                    gymService.registerGym(ownerId,gymName,gymLocation);
                    break;
                case 2:
                    addSlot();
                    break;
                case 3:
                    List<GymCenter>gyms= ownerService.viewMyGyms(ownerId);
                    // Print the Table Header
                    System.out.println("\n" + "=".repeat(65));
                    System.out.printf("%-10s | %-25s | %-20s%n", "GYM ID", "GYM NAME", "LOCATION");
                    System.out.println("-".repeat(65));

// Print the Table Rows
                    for (GymCenter g : gyms) {
                        System.out.printf("%-10s | %-25s | %-20s%n",
                                g.getGymId(),
                                g.getGymName(),
                                g.getGymLocation());
                    }

                    System.out.println("=".repeat(65) + "\n");
                    break;
                case 4:
                    return;
            }
        }
    }



    private void addSlot() {
        System.out.println("Enter Gym ID:");
        String gymId = scanner.next();
        System.out.println("Enter Start Time (HH:MM):");
        String time = scanner.next();

        Slot slot = new Slot();
        slot.setStartTime(time);

        gymService.addSlot(gymId, slot);
    }
}