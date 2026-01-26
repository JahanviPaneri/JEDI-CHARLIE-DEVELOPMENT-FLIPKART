package com.flipkart.dao;

import com.flipkart.bean.GymOwner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GymOwnerDaoImpl implements GymOwnerDaoInterface {

    // Key: ownerId, Value: GymOwner Object
    private static final Map<String, GymOwner> ownerMap = new HashMap<>();

    @Override
    public void addGymOwner(GymOwner owner) {
        ownerMap.put(owner.getOwnerId(), owner);
        System.out.println("DAO: Gym Owner registered: " + owner.getOwnerId());
    }

    @Override
    public GymOwner getOwnerById(String ownerId) {
        return ownerMap.get(ownerId);
    }

    @Override
    public GymOwner getOwnerByEmail(String email) {
        return ownerMap.values().stream()
                .filter(owner -> owner.getEmail().equalsIgnoreCase(email))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<GymOwner> getAllOwners() {
        return new ArrayList<>(ownerMap.values());
    }

    @Override
    public void deleteOwner(String ownerId) {
        if (ownerMap.containsKey(ownerId)) {
            ownerMap.remove(ownerId);
            System.out.println("DAO: Gym Owner " + ownerId + " removed.");
        }
    }
}