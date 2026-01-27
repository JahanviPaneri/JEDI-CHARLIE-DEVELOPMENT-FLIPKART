package com.flipkart.dao;

import com.flipkart.bean.Slot;
import java.util.List;

public interface SlotDaoInterface {
    void addSlot(Slot slot);
    void removeSlot(String slotId);
    Slot getSlotById(String slotId);
    List<Slot> getSlotsByGymId(String gymId);

    // Distinct methods for different business needs
    void changeAvailableCapacity(String slotId, int newAvailableCapacity);
    void changeTotalCapacity(String slotId, int newTotalCapacity);

    List<Slot> getAllSlots();
}