package com.flipkart.client;

import com.flipkart.business.BookingService;
import com.flipkart.business.GymCenterService;
import com.flipkart.bean.GymCenter;
import com.flipkart.bean.Slot;
import java.util.List;
import java.util.Scanner;

public class CustomerMenu {
    Scanner scanner = new Scanner(System.in);
    GymCenterService gymService = new GymCenterService();
    BookingService bookingService = new BookingService();

    public void showMenu(String userId) {
        while (true) {
            System.out.println("\n--- Customer Menu ---");
            System.out.println("1. View All Gym Centers");
            System.out.println("2. View Available Slots in a Gym");
            System.out.println("3. Make a Booking");
            System.out.println("4. Cancel a Booking");
            System.out.println("5. View My Bookings");
            System.out.println("6. Logout");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    List<GymCenter> centers = gymService.viewAllCenters();
                    System.out.println("ID\tName\tLocation");
                    for(GymCenter g : centers) {
                        System.out.println(g.getGymId() + "\t" + g.getGymName() + "\t" + g.getGymLocation());
                    }
                    break;
                case 2:

                    System.out.println("Enter Gym ID:");
                    String gymId = scanner.next();
                    List<Slot> slots = gymService.getAvailableSlots(gymId);

                    for(Slot s:slots){
                        System.out.println("slot id --> " +s.getSlotId());
                        System.out.println("start time --> " +s.getStartTime());
                        System.out.println("Date --> " +s.getDate());
                        System.out.println("total capacity --> " +s.getTotalCapacity());
                        System.out.println("available capacity--> " +s.getAvailableCapacity());
                    }

                    break;
                case 3:
                    System.out.println("Enter Gym ID:");
                    String gId = scanner.next();
                    System.out.println("Enter Slot ID:");
                    String slotId = scanner.next();
                    System.out.println("Enter Date (DD/MM/YYYY):");
                    String date = scanner.next();
                    bookingService.makeBooking(userId, gId, slotId, date);
                    break;

                case 4:
                    System.out.println("Enter Booking ID to cancel:");
                    String bId = scanner.next();
                    bookingService.cancelBooking(bId);
                    break;
                case 5:
                    bookingService.getCustomerBookings(userId);
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}