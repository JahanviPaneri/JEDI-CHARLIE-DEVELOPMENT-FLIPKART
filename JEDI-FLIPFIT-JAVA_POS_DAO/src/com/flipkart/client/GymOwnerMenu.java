package com.flipkart.client;

import com.flipkart.bean.GymCenter;
import com.flipkart.bean.Slot;
import com.flipkart.business.GymOwnerService;
import com.flipkart.business.GymCenterService;

import java.util.List;
import java.util.Scanner;

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
                    addGym(ownerId);
                    break;
                case 2:
                    addSlot();
                    break;
                case 3:
                    List<GymCenter>gyms= ownerService.viewMyGyms(ownerId);
                    for(GymCenter g:gyms){
                        System.out.println("GymId ->" + g.getGymId() + " GymLocation ->" +g.getGymName() + " GymName -->" + g.getGymName());
                    }
                    break;
                case 4:
                    return;
            }
        }
    }

    private void addGym(String ownerId) {
        System.out.println("Enter Gym Name:");
        String name = scanner.next();
        System.out.println("Enter Location:");
        String loc = scanner.next();

        GymCenter gym = new GymCenter();
        gym.setGymName(name);
        gym.setGymLocation(loc);
        gym.setGymOwnerId(ownerId);

        ownerService.requestGymAddition(gym);
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