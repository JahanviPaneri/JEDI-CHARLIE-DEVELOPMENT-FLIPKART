package com.flipfit.dao;

import com.flipfit.bean.Slot;
import com.flipfit.constant.SQLConstants;
import com.flipfit.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Data Access implementation for managing gym workout slots in memory.
 */
public class SlotDaoImpl implements SlotDaoInterface {

    // Storage for workout slots using slotId as the unique key
    private static Map<String, Slot> slotMap = new HashMap<>();

    @Override
    public void addSlot(Slot slot) {
        // Save a new workout timing slot into the system
        slotMap.put(slot.getSlotId(), slot);
    }

    @Override
    public void removeSlot(String slotId) {
        // Delete a workout timing slot from the storage
        slotMap.remove(slotId);
    }

    @Override
    public Slot getSlotById(String slotId) {
        // Find and return a specific slot using its unique ID
        return slotMap.get(slotId);
    }

    @Override
    public void changeAvailableCapacity(String slotId, int newAvailableCapacity) {
        // Update how many spots are left after a booking or cancellation
        Slot slot = slotMap.get(slotId);
        if (slot != null) {
            slot.setAvailableCapacity(newAvailableCapacity);
            System.out.println("DAO: Availability updated for Slot " + slotId);
        }
    }

    @Override
    public void changeTotalCapacity(String slotId, int newTotalCapacity) {
        // Update the maximum number of people allowed in a specific slot
        Slot slot = slotMap.get(slotId);
        if (slot != null) {
            slot.setTotalCapacity(newTotalCapacity);
            System.out.println("DAO: Total Capacity updated for Slot " + slotId);
        }
    }

    @Override
    public Slot getSlotByDetails(String gymId) {
        Slot slot = null;
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SQLConstants.SELECT_SLOT_BY_CRITERIA)) {

            stmt.setString(1, gymId);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    slot = new Slot();
                    slot.setSlotId(rs.getString("slotId"));
                    slot.setGymId(rs.getString("gymId"));
                    slot.setStartTime(rs.getString("startTime"));
                    slot.setEndTime(rs.getString("endTime"));
                    slot.setDate(rs.getString("date"));
                    slot.setTotalCapacity(rs.getInt("totalCapacity"));
                    slot.setAvailableCapacity(rs.getInt("availableCapacity"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Database error while fetching slot: " + e.getMessage());
        }
        return slot; // Returns null if not found
    }

    @Override
    public List<Slot> getAllSlots() {
        // Get a complete list of every workout slot in the entire system
        return new ArrayList<>(slotMap.values());
    }
}