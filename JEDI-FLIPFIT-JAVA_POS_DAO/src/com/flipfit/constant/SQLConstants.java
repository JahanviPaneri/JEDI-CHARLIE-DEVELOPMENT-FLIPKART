package com.flipfit.constant;

// TODO: Auto-generated Javadoc
/**
 * The Class SQLConstants.
 * Contains all SQL query constants used in the FlipFit application.
 * Centralizes SQL statements for better maintainability and consistency.
 *
 * @author FlipFit Development Team
 * @version 1.0
 */
public class SQLConstants {

    // ======================== ADMIN QUERIES ========================

    /** The SQL query to insert a new admin record. */
    public static final String INSERT_ADMIN = "INSERT INTO ADMIN (adminId, name, email, userId,aadharNumber,panNumber) VALUES (?, ?, ?, ?,?,?)";

    /** The SQL query to select admin by ID. */
    public static final String SELECT_ADMIN_BY_ID = "SELECT * FROM ADMIN WHERE adminId = ?";

    /** The SQL query to select admin by email. */
    public static final String SELECT_ADMIN_BY_EMAIL = "SELECT * FROM ADMIN WHERE email = ?";

    /** The SQL query to select all admins. */
    public static final String SELECT_ALL_ADMINS = "SELECT * FROM ADMIN";

    // ======================== USER QUERIES ========================

    /** The SQL query to insert a new user record. */
    public static final String INSERT_USER = "INSERT INTO User (userId, name, email, passwordHash, phoneNumber, role) VALUES (?, ?, ?, ?, ?, ?)";

    /** The SQL query to select user by ID. */
    public static final String SELECT_USER_BY_ID = "SELECT * FROM User WHERE userId = ?";

    /** The SQL query to select user by email. */
    public static final String SELECT_USER_BY_EMAIL = "SELECT * FROM User WHERE email = ?";

    /** The SQL query to select all users. */
    public static final String SELECT_ALL_USERS = "SELECT * FROM User";

    /** The SQL query to update user password. */
    public static final String UPDATE_USER_PASSWORD = "UPDATE User SET passwordHash = ? WHERE userId = ?";

    // ======================== CUSTOMER QUERIES ========================

    /** The SQL query to insert a new customer record. */
    public static final String INSERT_CUSTOMER = "INSERT INTO Customer (customerId, name, email, phoneNumber, password) VALUES (?, ?, ?, ?, ?)";

    /** The SQL query to select customer by ID. */
    public static final String SELECT_CUSTOMER_BY_ID = "SELECT * FROM Customer WHERE customerId = ?";

    /** The SQL query to select customer by email. */
    public static final String SELECT_CUSTOMER_BY_EMAIL = "SELECT * FROM Customer WHERE email = ?";

    /** The SQL query to select all customers. */
    public static final String SELECT_ALL_CUSTOMERS = "SELECT * FROM Customer";

    /** The SQL query to update customer details. */
    public static final String UPDATE_CUSTOMER = "UPDATE Customer SET name = ?, email = ?, phoneNumber = ? WHERE customerId = ?";

    // ======================== GYM OWNER QUERIES ========================

    /** The SQL query to insert a new gym owner record. */
    public static final String INSERT_GYM_OWNER = "INSERT INTO GYM_OWNER (ownerId, accountNumber, panNumber, ownerStatus) VALUES (?, ?, ?, ?)";

    /** The SQL query to select gym owner by ID. */
    public static final String SELECT_GYM_OWNER_BY_ID = "SELECT * FROM GYM_OWNER WHERE ownerId = ?";

    /** The SQL query to select gym owner by email. */
    public static final String SELECT_GYM_OWNER_BY_EMAIL = "SELECT * FROM GYM_OWNER WHERE email = ?";

    /** The SQL query to select all gym owners. */
    public static final String SELECT_ALL_GYM_OWNERS = "SELECT * FROM GYM_OWNER";

    /** The SQL query to update gym owner status. */
    public static final String UPDATE_GYM_OWNER_STATUS = "UPDATE GYM_OWNER SET status = ? WHERE ownerId = ?";

    /** The SQL query to delete gym owner. */
    public static final String DELETE_GYM_OWNER = "DELETE FROM GYM_OWNER WHERE ownerId = ?";

    /** Query for Admin to see all pending gym registrations */
    public static final String SELECT_PENDING_GYM_OWNERS =
            "SELECT * FROM GYM_OWNER WHERE ownerStatus = 'PENDING'";

    // ======================== GYM CENTER QUERIES ========================

    /** The SQL query to insert a new gym center record. */
    public static final String INSERT_GYM_CENTER = "INSERT INTO GYM_CENTER (gymId, name, location, ownerId, capacity, status) VALUES (?, ?, ?, ?, ?, ?)";

    /** The SQL query to select gym center by ID. */
    public static final String SELECT_GYM_CENTER_BY_ID = "SELECT * FROM GYM_CENTER WHERE gymId = ?";

    /** The SQL query to select gym centers by owner ID. */
    public static final String SELECT_GYM_CENTERS_BY_OWNER = "SELECT * FROM GYM_CENTER WHERE ownerId = ?";

    /** The SQL query to select all gym centers. */
    public static final String SELECT_ALL_GYM_CENTERS = "SELECT * FROM GYM_CENTER";

    /** The SQL query to update gym center status. */
    public static final String UPDATE_GYM_CENTER_STATUS = "UPDATE GYM_CENTER SET status = ? WHERE gymId = ?";

    /** The SQL query to update gym center details. */
    public static final String UPDATE_GYM_CENTER = "UPDATE GYM_CENTER SET name = ?, location = ?, capacity = ? WHERE gymId = ?";

    /** Query for Admin to see all pending gym registrations */
    public static final String SELECT_PENDING_GYM_CENTERS =
            "SELECT * FROM GYM_CENTER WHERE gymStatus = 'PENDING'";

    /** Query to update status upon approval */
    public static final String APPROVE_GYM_CENTER_QUERY =
            "UPDATE GYM_CENTER SET status = 'APPROVED' WHERE gymId = ?";

    // ======================== SLOT QUERIES ========================

    /** The SQL query to insert a new slot record. */
    public static final String INSERT_SLOT = "INSERT INTO Slot (slotId, gymId, startTime, endTime, availableSeats, totalCapacity) VALUES (?, ?, ?, ?, ?, ?)";

    /** The SQL query to select slot by ID. */
    public static final String SELECT_SLOT_BY_ID = "SELECT * FROM Slot WHERE slotId = ?";

    /** The SQL query to select slots by gym ID. */
    public static final String SELECT_SLOTS_BY_GYM = "SELECT * FROM Slot WHERE gymId = ?";

    /** The SQL query to select all slots. */
    public static final String SELECT_ALL_SLOTS = "SELECT * FROM Slot";

    /** The SQL query to update slot availability. */
    public static final String UPDATE_SLOT_AVAILABILITY = "UPDATE Slot SET availableSeats = ? WHERE slotId = ?";

    /** The SQL query to update slot capacity. */
    public static final String UPDATE_SLOT_CAPACITY = "UPDATE Slot SET totalCapacity = ? WHERE slotId = ?";

    // ======================== BOOKING QUERIES ========================

    /** The SQL query to insert a new booking record. */
    public static final String INSERT_BOOKING = "INSERT INTO Booking (bookingId, customerId, slotId, bookingDate, status) VALUES (?, ?, ?, ?, ?)";

    /** The SQL query to select booking by ID. */
    public static final String SELECT_BOOKING_BY_ID = "SELECT * FROM Booking WHERE bookingId = ?";

    /** The SQL query to select bookings by customer ID. */
    public static final String SELECT_BOOKINGS_BY_CUSTOMER = "SELECT * FROM Booking WHERE customerId = ?";

    /** The SQL query to select bookings by slot ID. */
    public static final String SELECT_BOOKINGS_BY_SLOT = "SELECT * FROM Booking WHERE slotId = ?";

    /** The SQL query to select all bookings. */
    public static final String SELECT_ALL_BOOKINGS = "SELECT * FROM Booking";

    /** The SQL query to update booking status. */
    public static final String UPDATE_BOOKING_STATUS = "UPDATE Booking SET status = ? WHERE bookingId = ?";

    /** The SQL query to cancel booking. */
    public static final String CANCEL_BOOKING = "UPDATE Booking SET status = 'CANCELLED' WHERE bookingId = ?";

    // ======================== PAYMENT QUERIES ========================

    /** The SQL query to insert a new payment record. */
    public static final String INSERT_PAYMENT = "INSERT INTO Payment (paymentId, bookingId, amount, paymentDate, status) VALUES (?, ?, ?, ?, ?)";

    /** The SQL query to select payment by ID. */
    public static final String SELECT_PAYMENT_BY_ID = "SELECT * FROM Payment WHERE paymentId = ?";

    /** The SQL query to select payment by booking ID. */
    public static final String SELECT_PAYMENT_BY_BOOKING = "SELECT * FROM Payment WHERE bookingId = ?";

    /** The SQL query to update payment status. */
    public static final String UPDATE_PAYMENT_STATUS = "UPDATE Payment SET status = ? WHERE paymentId = ?";

    // ======================== WAITLIST QUERIES ========================

    /** The SQL query to insert a new waitlist entry. */
    public static final String INSERT_WAITLIST = "INSERT INTO Waitlist (waitlistId, customerId, slotId, addedDate, status) VALUES (?, ?, ?, ?, ?)";

    /** The SQL query to select waitlist by ID. */
    public static final String SELECT_WAITLIST_BY_ID = "SELECT * FROM Waitlist WHERE waitlistId = ?";

    /** The SQL query to select waitlist by slot ID. */
    public static final String SELECT_WAITLIST_BY_SLOT = "SELECT * FROM Waitlist WHERE slotId = ?";

    /** The SQL query to delete waitlist entry. */
    public static final String DELETE_WAITLIST_ENTRY = "DELETE FROM Waitlist WHERE waitlistId = ?";


}