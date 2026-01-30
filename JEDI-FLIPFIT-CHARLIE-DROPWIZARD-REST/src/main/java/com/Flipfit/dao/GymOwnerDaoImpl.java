package com.Flipfit.dao;

import com.Flipfit.bean.GymCenter;
import com.Flipfit.bean.GymOwner;

import java.util.ArrayList;
import java.util.List;

public class GymOwnerDaoImpl implements GymOwnerDaoInterface {
    @Override
    public void addGymOwner(GymOwner owner) {
        // SQL Logic: INSERT INTO GymOwner (ownerId, userId, name...) VALUES (?, ?, ?);
        System.out.println("DAO: Gym Owner registered in DB: " + owner.getName());
    }

    @Override
    public void requestGymAddition(GymCenter gym) {
        // SQL Logic: INSERT INTO Gym (gymId, name, location, status...) VALUES (?, ?, ?, ?);
        System.out.println("DAO: Gym addition request stored for: " + gym.getGymName());
    }

    @Override
    public void requestGymRemoval(String gymId) {
        // SQL Logic: DELETE FROM Gym WHERE gymId = ?;
        System.out.println("DAO: Gym removal request processed for ID: " + gymId);
    }

    @Override
    public List<GymCenter> viewMyGyms(String ownerId) {
        // SQL Logic: SELECT * FROM Gym WHERE ownerId = ?;
        return new ArrayList<>();
    }
}
