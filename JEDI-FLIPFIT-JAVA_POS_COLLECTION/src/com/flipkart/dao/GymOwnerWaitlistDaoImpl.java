package com.flipfit.dao;

import com.flipfit.bean.GymOwnerWaitlist;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GymOwnerWaitlistDaoImpl implements GymOwnerWaitlistDaoInterface {

    // In-memory storage: Key = ownerId, Value = GymOwnerWaitlist
    // TODO: Replace with actual database queries
    private static final Map<String, GymOwnerWaitlist> waitlistMap = new HashMap<>();

    @Override
    public void addToWaitlist(GymOwnerWaitlist waitlistEntry) {
        waitlistMap.put(waitlistEntry.getOwnerId(), waitlistEntry);
        System.out.println("DAO: Gym Owner added to waitlist: " + waitlistEntry.getOwnerId());
        // TODO: INSERT INTO gym_owner_waitlist (ownerId, email, password, accountNumber, panNumber) VALUES (...)
    }

    @Override
    public GymOwnerWaitlist getWaitlistEntryByOwnerId(String ownerId) {
        // TODO: SELECT * FROM gym_owner_waitlist WHERE ownerId = ?
        return waitlistMap.get(ownerId);
    }

    @Override
    public List<GymOwnerWaitlist> getAllPendingEntries() {
        // TODO: SELECT * FROM gym_owner_waitlist (all pending entries)
        return new ArrayList<>(waitlistMap.values());
    }

    @Override
    public void removeFromWaitlist(String ownerId) {
        if (waitlistMap.containsKey(ownerId)) {
            waitlistMap.remove(ownerId);
            System.out.println("DAO: Gym Owner removed from waitlist: " + ownerId);
            // TODO: DELETE FROM gym_owner_waitlist WHERE ownerId = ?
        }
    }

    @Override
    public boolean existsInWaitlist(String ownerId) {
        // TODO: SELECT COUNT(*) FROM gym_owner_waitlist WHERE ownerId = ?
        return waitlistMap.containsKey(ownerId);
    }
}
