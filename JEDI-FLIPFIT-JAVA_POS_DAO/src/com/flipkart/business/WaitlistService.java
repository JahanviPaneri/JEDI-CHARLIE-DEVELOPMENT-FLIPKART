package com.flipkart.business;

import com.flipkart.bean.Waitlist;
import java.util.List;

public class WaitlistService implements WaitlistInterface {

    @Override
    public void addToWaitlist(String userId, String slotId) {
        // Logic: Create new Waitlist entry with priority (timestamp based)
        System.out.println("User " + userId + " added to waitlist for slot " + slotId);
    }

    @Override
    public void promoteUserFromWaitlist(String slotId) {
        // Logic: Pick user with highest priority
        // Convert their waitlist status to 'PROMOTED'
        // Create a new Booking for them
        System.out.println("Promoting top user from waitlist for slot: " + slotId);
    }

    @Override
    public void removeWaitlistEntry(String waitlistId) {
        // Logic: Delete entry if user cancels their waitlist spot
    }

    @Override
    public List<Waitlist> getWaitlistBySlot(String slotId) {
        return null;
    }
}