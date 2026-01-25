package flipkart.business;

import flipkart.bean.GymCenter;
import flipkart.bean.Slot;

import java.util.List;

public interface GymCenterInterface {
    void addSlot(String gymId, Slot slot);
    void removeSlot(String slotId);
    List<GymCenter> getAllGymCenters();
    List<GymCenter> getGymCentersByCity(String city);
    List<Slot> getAvailableSlotsByGym(String gymId);

    void updateGymStatus(String gymId, String status);
}
