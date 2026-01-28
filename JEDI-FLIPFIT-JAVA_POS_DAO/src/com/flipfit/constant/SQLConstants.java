package com.flipfit.constant;

public class SQLConstants {

    // ======================== ADMIN QUERIES ========================
    // Updated to include aadharNumber and panNumber
    public static final String INSERT_ADMIN = "INSERT INTO ADMIN (adminId, name, email, userId, aadharNumber, panNumber) VALUES (?, ?, ?, ?, ?, ?)";
    public static final String SELECT_ADMIN_BY_ID = "SELECT * FROM ADMIN WHERE adminId = ?";
    public static final String SELECT_ADMIN_BY_EMAIL = "SELECT * FROM ADMIN WHERE email = ?";
    public static final String SELECT_ALL_ADMINS = "SELECT * FROM ADMIN";

    // ======================== USER QUERIES ========================
    public static final String INSERT_USER = "INSERT INTO User (userId, name, email, passwordHash, phoneNumber, role) VALUES (?, ?, ?, ?, ?, ?)";
    public static final String SELECT_USER_BY_ID = "SELECT * FROM User WHERE userId = ?";
    public static final String SELECT_USER_BY_EMAIL = "SELECT * FROM User WHERE email = ?";
    public static final String SELECT_ALL_USERS = "SELECT * FROM User";
    public static final String UPDATE_USER_PASSWORD = "UPDATE User SET passwordHash = ? WHERE userId = ?";

    // ======================== CUSTOMER QUERIES ========================
    public static final String INSERT_CUSTOMER = "INSERT INTO Customer (customerId, name, email, phoneNumber, password) VALUES (?, ?, ?, ?, ?)";
    public static final String SELECT_CUSTOMER_BY_ID = "SELECT * FROM Customer WHERE customerId = ?";
    public static final String SELECT_CUSTOMER_BY_EMAIL = "SELECT * FROM Customer WHERE email = ?";
    public static final String SELECT_ALL_CUSTOMERS = "SELECT * FROM Customer";
    public static final String UPDATE_CUSTOMER = "UPDATE Customer SET name = ?, email = ?, phoneNumber = ? WHERE customerId = ?";

    // ======================== GYM OWNER QUERIES ========================
    // Updated to include aadharNumber and fixed panCard column name consistency
    public static final String INSERT_GYM_OWNER = "INSERT INTO GymOwner (ownerId, name, email, phoneNumber, panNumber, aadharNumber, status) VALUES (?, ?, ?, ?, ?, ?, ?)";
    public static final String SELECT_GYM_OWNER_BY_ID = "SELECT * FROM GymOwner WHERE ownerId = ?";
    public static final String SELECT_GYM_OWNER_BY_EMAIL = "SELECT * FROM GymOwner WHERE email = ?";
    public static final String SELECT_ALL_GYM_OWNERS = "SELECT * FROM GymOwner";
    public static final String UPDATE_GYM_OWNER_STATUS = "UPDATE GymOwner SET status = ? WHERE ownerId = ?";
    public static final String DELETE_GYM_OWNER = "DELETE FROM GymOwner WHERE ownerId = ?";

    // ... (Remaining constants for GymCenter, Slot, Booking, Payment, Waitlist remain unchanged) ...
    public static final String INSERT_GYM_CENTER = "INSERT INTO GymCenter (gymId, name, location, ownerId, capacity, status) VALUES (?, ?, ?, ?, ?, ?)";
    public static final String SELECT_GYM_CENTER_BY_ID = "SELECT * FROM GymCenter WHERE gymId = ?";
    public static final String SELECT_GYM_CENTERS_BY_OWNER = "SELECT * FROM GymCenter WHERE ownerId = ?";
    public static final String SELECT_ALL_GYM_CENTERS = "SELECT * FROM GymCenter";
    public static final String UPDATE_GYM_CENTER_STATUS = "UPDATE GymCenter SET status = ? WHERE gymId = ?";
    public static final String UPDATE_GYM_CENTER = "UPDATE GymCenter SET name = ?, location = ?, capacity = ? WHERE gymId = ?";

    public static final String INSERT_SLOT = "INSERT INTO Slot (slotId, gymId, startTime, endTime, availableSeats, totalCapacity) VALUES (?, ?, ?, ?, ?, ?)";
    public static final String SELECT_SLOT_BY_ID = "SELECT * FROM Slot WHERE slotId = ?";
    public static final String SELECT_SLOTS_BY_GYM = "SELECT * FROM Slot WHERE gymId = ?";
    public static final String SELECT_ALL_SLOTS = "SELECT * FROM Slot";
    public static final String UPDATE_SLOT_AVAILABILITY = "UPDATE Slot SET availableSeats = ? WHERE slotId = ?";
    public static final String UPDATE_SLOT_CAPACITY = "UPDATE Slot SET totalCapacity = ? WHERE slotId = ?";

    public static final String INSERT_BOOKING = "INSERT INTO Booking (bookingId, customerId, slotId, bookingDate, status) VALUES (?, ?, ?, ?, ?)";
    public static final String SELECT_BOOKING_BY_ID = "SELECT * FROM Booking WHERE bookingId = ?";
    public static final String SELECT_BOOKINGS_BY_CUSTOMER = "SELECT * FROM Booking WHERE customerId = ?";
    public static final String SELECT_BOOKINGS_BY_SLOT = "SELECT * FROM Booking WHERE slotId = ?";
    public static final String SELECT_ALL_BOOKINGS = "SELECT * FROM Booking";
    public static final String UPDATE_BOOKING_STATUS = "UPDATE Booking SET status = ? WHERE bookingId = ?";
    public static final String CANCEL_BOOKING = "UPDATE Booking SET status = 'CANCELLED' WHERE bookingId = ?";

    public static final String INSERT_PAYMENT = "INSERT INTO Payment (paymentId, bookingId, amount, paymentDate, status) VALUES (?, ?, ?, ?, ?)";
    public static final String SELECT_PAYMENT_BY_ID = "SELECT * FROM Payment WHERE paymentId = ?";
    public static final String SELECT_PAYMENT_BY_BOOKING = "SELECT * FROM Payment WHERE bookingId = ?";
    public static final String UPDATE_PAYMENT_STATUS = "UPDATE Payment SET status = ? WHERE paymentId = ?";

    public static final String INSERT_WAITLIST = "INSERT INTO Waitlist (waitlistId, customerId, slotId, addedDate, status) VALUES (?, ?, ?, ?, ?)";
    public static final String SELECT_WAITLIST_BY_ID = "SELECT * FROM Waitlist WHERE waitlistId = ?";
    public static final String SELECT_WAITLIST_BY_SLOT = "SELECT * FROM Waitlist WHERE slotId = ?";
    public static final String DELETE_WAITLIST_ENTRY = "DELETE FROM Waitlist WHERE waitlistId = ?";
}