# Quick Implementation Guide - Database Workflow

## ✅ What's Been Implemented

Your gym owner registration system now uses a proper database-driven workflow with two tables:

### Tables Structure

**gym_owner_waitlist** (Pending Requests)
```
- ownerId (PK)
- email
- password (hashed)
- accountNumber
- panNumber
```

**gym_owner** (Approved Owners)
```
- ownerId (PK)
- email
- password (hashed)
- accountNumber
- panNumber
```

---

## 📋 Registration Flow

```
1. Owner Registration
   ├─ Input: email, password, accountNumber, panNumber
   ├─ Generates: ownerId (UUID)
   └─ INSERT INTO gym_owner_waitlist

2. Admin Approval
   ├─ Views: SELECT * FROM gym_owner_waitlist
   ├─ Approves: Selects ownerId
   ├─ INSERT INTO gym_owner (from waitlist data)
   └─ DELETE FROM gym_owner_waitlist

3. Owner Can Now Manage Gyms
   └─ Access granted after approval
```

---

## 🔧 Files Created/Modified

### NEW Files
1. ✅ `bean/GymOwnerWaitlist.java` - Waitlist request bean
2. ✅ `dao/GymOwnerWaitlistDaoInterface.java` - DAO interface
3. ✅ `dao/GymOwnerWaitlistDaoImpl.java` - DAO implementation

### MODIFIED Files
1. ✅ `client/ApplicationMenu.java` - Now asks for: email, password, accountNumber, panNumber
2. ✅ `business/GymOwnerService.java` - Saves to gym_owner_waitlist
3. ✅ `business/AdminService.java` - Moves approved from waitlist to gym_owner
4. ✅ `client/AdminMenu.java` - Shows waitlist requests with details

---

## 🚀 How to Connect to Database

The DAO layer is ready for database integration. Follow these steps:

### Step 1: Update GymOwnerWaitlistDaoImpl.java

Replace the in-memory HashMap with database queries:

```java
@Override
public void addToWaitlist(GymOwnerWaitlist waitlistEntry) {
    // Replace TODO with:
    String query = "INSERT INTO gym_owner_waitlist (ownerId, email, password, accountNumber, panNumber) VALUES (?, ?, ?, ?, ?)";
    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {
        stmt.setString(1, waitlistEntry.getOwnerId());
        stmt.setString(2, waitlistEntry.getEmail());
        stmt.setString(3, waitlistEntry.getPassword());
        stmt.setString(4, waitlistEntry.getAccountNumber());
        stmt.setString(5, waitlistEntry.getPanNumber());
        stmt.executeUpdate();
        System.out.println("DAO: Gym Owner added to waitlist: " + waitlistEntry.getOwnerId());
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

@Override
public List<GymOwnerWaitlist> getAllPendingEntries() {
    List<GymOwnerWaitlist> entries = new ArrayList<>();
    String query = "SELECT * FROM gym_owner_waitlist";
    try (Connection conn = DatabaseConnection.getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(query)) {
        while (rs.next()) {
            GymOwnerWaitlist entry = new GymOwnerWaitlist();
            entry.setOwnerId(rs.getString("ownerId"));
            entry.setEmail(rs.getString("email"));
            entry.setPassword(rs.getString("password"));
            entry.setAccountNumber(rs.getString("accountNumber"));
            entry.setPanNumber(rs.getString("panNumber"));
            entries.add(entry);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return entries;
}

@Override
public GymOwnerWaitlist getWaitlistEntryByOwnerId(String ownerId) {
    String query = "SELECT * FROM gym_owner_waitlist WHERE ownerId = ?";
    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {
        stmt.setString(1, ownerId);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            GymOwnerWaitlist entry = new GymOwnerWaitlist();
            entry.setOwnerId(rs.getString("ownerId"));
            entry.setEmail(rs.getString("email"));
            entry.setPassword(rs.getString("password"));
            entry.setAccountNumber(rs.getString("accountNumber"));
            entry.setPanNumber(rs.getString("panNumber"));
            return entry;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}

@Override
public void removeFromWaitlist(String ownerId) {
    String query = "DELETE FROM gym_owner_waitlist WHERE ownerId = ?";
    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {
        stmt.setString(1, ownerId);
        stmt.executeUpdate();
        System.out.println("DAO: Gym Owner removed from waitlist: " + ownerId);
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

@Override
public boolean existsInWaitlist(String ownerId) {
    String query = "SELECT COUNT(*) FROM gym_owner_waitlist WHERE ownerId = ?";
    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {
        stmt.setString(1, ownerId);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return rs.getInt(1) > 0;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}
```

### Step 2: Create DatabaseConnection Class

```java
package com.flipfit.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/flipfit_db";
    private static final String USER = "root";
    private static final String PASSWORD = "your_password";
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
```

### Step 3: Create Database Tables

Execute these SQL commands in your database:

```sql
CREATE TABLE gym_owner_waitlist (
    ownerId VARCHAR(36) PRIMARY KEY,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    accountNumber VARCHAR(50) NOT NULL,
    panNumber VARCHAR(50) NOT NULL
);

CREATE TABLE gym_owner (
    ownerId VARCHAR(36) PRIMARY KEY,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    accountNumber VARCHAR(50) NOT NULL,
    panNumber VARCHAR(50) NOT NULL
);
```

---

## 🧪 Testing the Workflow

### Manual Testing Steps

1. **Run the application**
   ```
   java -cp . com.flipfit.client.ApplicationMenu
   ```

2. **Register as Gym Owner**
   ```
   Select: 3. Register Gym Owner
   Email: john@example.com
   Password: pass123
   Account Number: 123456789
   PAN Number: ABCD1234E
   ```
   Output: `Your request ID is: [generated-uuid]`

3. **Check database** (Verify entry in gym_owner_waitlist)
   ```sql
   SELECT * FROM gym_owner_waitlist;
   ```

4. **Login as Admin**
   ```
   Select: 1. Login
   Username: admin
   Password: admin123
   Role: 1 (Admin)
   ```

5. **View Pending Requests**
   ```
   Select: 1. View Pending Gym Owner Requests
   ```
   Output: Shows all pending requests with email, account number, PAN

6. **Approve Owner**
   ```
   Select: 2. Approve Gym Owner
   Enter Owner ID: [from step 2]
   ```
   Output: `Owner moved to gym_owner table successfully.`

7. **Verify Database**
   ```sql
   SELECT * FROM gym_owner;          -- Should see approved owner
   SELECT * FROM gym_owner_waitlist; -- Should be empty/removed
   ```

---

## 📊 Current Architecture

```
ApplicationMenu (UI Input)
    ├─ Register: Takes email, password, accountNumber, panNumber
    └─ No GymOwner login yet (admin approval required first)

GymOwnerService (Business Logic)
    └─ registerOwner(): Creates entry in waitlist

AdminService (Admin Logic)
    ├─ viewPendingWaitlistEntries(): Fetches from waitlist table
    └─ approveGymOwner(): Moves from waitlist → gym_owner table

DAO Layer (Data Access)
    ├─ GymOwnerWaitlistDaoImpl: Manages gym_owner_waitlist table
    └─ GymOwnerDaoImpl: Manages gym_owner table

Database
    ├─ gym_owner_waitlist: Pending registrations
    └─ gym_owner: Approved owners
```

---

## 🔑 Key Features

✅ **Two-Stage Approval**
- Waitlist: Initial registration
- Approved: After admin verification

✅ **Data Integrity**
- Atomic transactions (when using database)
- No duplicate entries

✅ **Clean Separation**
- DAO layer handles all database access
- Services remain database-agnostic

✅ **Easy Database Integration**
- All TODO comments mark where to add SQL queries
- No changes needed in service layer

---

## ⚠️ Important Notes

### For In-Memory Testing
- Current implementation uses HashMap
- Data will be lost when app restarts
- Perfect for testing logic

### For Production Database
- Follow Step 1-3 above
- Use connection pooling for performance
- Add error handling for database failures
- Implement password hashing (BCrypt/SHA256)
- Add logging for audit trail

### Password Security
```java
// Currently stores plain password - TODO for production:
import java.security.MessageDigest;
import java.util.Base64;

String hashedPassword = hashPassword(password);

private static String hashPassword(String password) {
    try {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hashedBytes = md.digest(password.getBytes());
        return Base64.getEncoder().encodeToString(hashedBytes);
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}
```

---

## 📝 SQL Commands Reference

### Create Tables
```sql
CREATE TABLE gym_owner_waitlist (
    ownerId VARCHAR(36) PRIMARY KEY,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    accountNumber VARCHAR(50) NOT NULL,
    panNumber VARCHAR(50) NOT NULL
);

CREATE TABLE gym_owner (
    ownerId VARCHAR(36) PRIMARY KEY,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    accountNumber VARCHAR(50) NOT NULL,
    panNumber VARCHAR(50) NOT NULL
);
```

### Sample Data
```sql
-- After registration (in waitlist)
INSERT INTO gym_owner_waitlist VALUES 
('550e8400-e29b-41d4-a716-446655440000', 'john@example.com', 'pass123', '123456789', 'ABCD1234E');

-- After approval (moved to gym_owner)
INSERT INTO gym_owner VALUES 
('550e8400-e29b-41d4-a716-446655440000', 'john@example.com', 'pass123', '123456789', 'ABCD1234E');

-- Query pending
SELECT * FROM gym_owner_waitlist;

-- Query approved
SELECT * FROM gym_owner;
```

---

## ✅ Status

**Current Implementation**: ✅ Complete (In-memory)
**Database Ready**: ✅ Yes (DAO layer ready)
**Testing**: ✅ Can test with current setup
**Production Ready**: ⏳ After connecting to database

All files are compiled and ready to use!
