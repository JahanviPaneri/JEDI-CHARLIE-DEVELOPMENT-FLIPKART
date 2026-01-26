package com.flipkart.business;

import com.flipkart.bean.Waitlist;
import java.util.List;

public interface WaitlistInterface {
    void addToWaitlist(String userId, String slotId);
    void promoteUserFromWaitlist(String slotId);
    void removeWaitlistEntry(String waitlistId);
    List<Waitlist> getWaitlistBySlot(String slotId);
}