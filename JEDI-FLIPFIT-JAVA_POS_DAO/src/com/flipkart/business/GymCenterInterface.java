package com.flipkart.business;

import com.flipkart.bean.GymCenter;
import com.flipkart.bean.Slot;
import java.util.List;

public interface GymCenterInterface {
    // Slot Logic
    void addSlot(String gymId, Slot slot);
    void removeSlot(String slotId);

    // Retrieval Logic
    List<GymCenter> viewAllCenters();
    List<Slot> getAvailableSlots(String gymId);
    void updateGymDetails(GymCenter gym);
}