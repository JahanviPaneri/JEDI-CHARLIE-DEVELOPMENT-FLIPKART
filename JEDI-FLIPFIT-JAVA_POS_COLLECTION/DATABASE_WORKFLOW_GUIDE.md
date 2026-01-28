# Database-Driven Gym Owner Registration Workflow

## Overview
The gym owner registration system now uses a proper database workflow with two tables:
- **gym_owner_waitlist**: Holds pending registration requests
- **gym_owner**: Holds approved gym owners

---

## Database Schema

### gym_owner_waitlist Table
```
Columns:
- ownerId (VARCHAR, PRIMARY KEY) - Unique identifier for the request
- email (VARCHAR)
- password (VARCHAR) - Hashed password in production
- accountNumber (VARCHAR)
- panNumber (VARCHAR)
```

### gym_owner Table
```
Columns:
- ownerId (VARCHAR, PRIMARY KEY)
- email (VARCHAR)
- password (VARCHAR) - Hashed password
- accountNumber (VARCHAR)
- panNumber (VARCHAR)
[Other fields as needed]
```

---

## Complete Registration & Approval Flow

### Phase 1: Gym Owner Registration

#### Step 1: Registration Inputs
**User Action**: New gym owner starts registration
**Inputs Required**:
- Email
- Password
- Account Number
- PAN Number

**Code**: `ApplicationMenu.registerGymOwner()`
```java
System.out.println("Enter email:");
String email = scanner.next();
System.out.println("Enter Password:");
String password = scanner.next();
System.out.println("Enter Account Number:");
String accountNumber = scanner.next();
System.out.println("Enter PAN Number:");
String panNumber = scanner.next();

GymOwnerService gymOwnerService = new GymOwnerService();
gymOwnerService.registerOwner(email, password, accountNumber, panNumber);
```

#### Step 2: Entry Created in Waitlist
**Service**: `GymOwnerService.registerOwner()`
```java
String ownerId = UUID.randomUUID().toString();

GymOwnerWaitlist waitlistEntry = new GymOwnerWaitlist();
waitlistEntry.setOwnerId(ownerId);
waitlistEntry.setEmail(email);
waitlistEntry.setPassword(password);  // Hash in production
waitlistEntry.setAccountNumber(accountNumber);
waitlistEntry.setPanNumber(panNumber);

// Save to gym_owner_waitlist table
waitlistDao.addToWaitlist(waitlistEntry);
```

**Database Query Executed**:
```sql
INSERT INTO gym_owner_waitlist (ownerId, email, password, accountNumber, panNumber)
VALUES (?, ?, ?, ?, ?)
```

**Output**:
```
Gym Owner registration request submitted successfully!
Your request ID is: [ownerId]
Your request is pending admin approval.
```

---

### Phase 2: Admin Reviews Waitlist

#### Step 3: Admin Logs In and Views Requests
**User Action**: Admin selects "1. View Pending Gym Owner Requests"
**Code**: `AdminMenu.viewPendingOwnerRequests()`

**Service Called**: `AdminService.viewPendingWaitlistEntries()`
```java
public List<GymOwnerWaitlist> viewPendingWaitlistEntries() {
    return waitlistDao.getAllPendingEntries();
}
```

**Database Query Executed**:
```sql
SELECT * FROM gym_owner_waitlist
```

**Display Output**:
```
--- Pending Gym Owner Requests ---
Owner ID: [ownerId1]
  Email: owner1@example.com
  Account Number: 123456789
  PAN Number: ABCD1234E
---
Owner ID: [ownerId2]
  Email: owner2@example.com
  Account Number: 987654321
  PAN Number: XYZW5678F
---
```

---

### Phase 3: Admin Approves Owner

#### Step 4: Admin Selects Owner to Approve
**User Action**: Admin selects "2. Approve Gym Owner"
**Input**: Owner ID to approve

**Code**: `AdminMenu.approveOwnerRequest()`
```java
System.out.println("Enter Owner ID to approve:");
String ownerId = scanner.next();
adminService.approveGymOwner(ownerId);
```

#### Step 5: Owner Entry Created in gym_owner Table
**Service**: `AdminService.approveGymOwner()`

**Step 5.1**: Fetch from waitlist
```java
GymOwnerWaitlist waitlistEntry = waitlistDao.getWaitlistEntryByOwnerId(ownerId);
```

**Database Query**:
```sql
SELECT * FROM gym_owner_waitlist WHERE ownerId = ?
```

**Step 5.2**: Create entry in gym_owner table
```java
GymOwner approvedOwner = new GymOwner();
approvedOwner.setOwnerId(ownerId);
approvedOwner.setEmail(waitlistEntry.getEmail());
approvedOwner.setPasswordHash(waitlistEntry.getPassword());
approvedOwner.setAccountNumber(waitlistEntry.getAccountNumber());
approvedOwner.setPanNumber(waitlistEntry.getPanNumber());

gymOwnerDao.addGymOwner(approvedOwner);
```

**Database Query**:
```sql
INSERT INTO gym_owner (ownerId, email, password, accountNumber, panNumber)
VALUES (?, ?, ?, ?, ?)
```

**Step 5.3**: Remove from waitlist
```java
waitlistDao.removeFromWaitlist(ownerId);
```

**Database Query**:
```sql
DELETE FROM gym_owner_waitlist WHERE ownerId = ?
```

**Output**:
```
Admin approved Owner ID: [ownerId]
Owner moved to gym_owner table successfully.
```

---

## Key Changes Made

### 1. New Bean: GymOwnerWaitlist
**File**: `bean/GymOwnerWaitlist.java`
- Represents a pending registration request
- Fields: ownerId, email, password, accountNumber, panNumber

### 2. New DAO Interface: GymOwnerWaitlistDaoInterface
**File**: `dao/GymOwnerWaitlistDaoInterface.java`
- Methods for CRUD operations on gym_owner_waitlist table

### 3. New DAO Implementation: GymOwnerWaitlistDaoImpl
**File**: `dao/GymOwnerWaitlistDaoImpl.java`
- Currently uses in-memory HashMap storage
- TODO comments show where to add actual database queries

### 4. Updated ApplicationMenu
**File**: `client/ApplicationMenu.java`
- Now collects: email, password, accountNumber, panNumber
- Removed: name, phoneNumber

### 5. Updated GymOwnerService
**File**: `business/GymOwnerService.java`
- `registerOwner()` now takes: email, password, accountNumber, panNumber
- Creates entry in gym_owner_waitlist instead of gym_owner table

### 6. Updated AdminService
**File**: `business/AdminService.java`
- `approveGymOwner()` now:
  - Fetches from gym_owner_waitlist
  - Creates entry in gym_owner table
  - Deletes from gym_owner_waitlist
- New method: `viewPendingWaitlistEntries()`

### 7. Updated AdminMenu
**File**: `client/AdminMenu.java`
- Displays pending requests from gym_owner_waitlist table
- Shows: ownerId, email, accountNumber, panNumber

---

## Data Flow Diagram

```
┌─────────────────────────────────────────────────────────────────┐
│                     REGISTRATION FLOW                           │
└─────────────────────────────────────────────────────────────────┘

Owner Registration Input
│
├─ Email
├─ Password
├─ Account Number
└─ PAN Number
│
▼
ApplicationMenu.registerGymOwner()
│
▼
GymOwnerService.registerOwner()
│
├─ Generate ownerId (UUID)
├─ Create GymOwnerWaitlist object
└─ waitlistDao.addToWaitlist()
   │
   ▼
   INSERT INTO gym_owner_waitlist
   (ownerId, email, password, accountNumber, panNumber)

Output: "Your request ID is: [ownerId]"


┌─────────────────────────────────────────────────────────────────┐
│                     APPROVAL FLOW                               │
└─────────────────────────────────────────────────────────────────┘

Admin Logs In
│
▼
AdminMenu (Option 1: View Pending Requests)
│
▼
AdminService.viewPendingWaitlistEntries()
│
▼
waitlistDao.getAllPendingEntries()
│
▼
SELECT * FROM gym_owner_waitlist
│
▼
Display List of Pending Requests
│
├─ ownerId
├─ Email
├─ Account Number
└─ PAN Number


Admin Selects Approval
│
▼
AdminMenu (Option 2: Approve Gym Owner)
│
▼
Enter Owner ID to Approve
│
▼
AdminService.approveGymOwner(ownerId)
│
├─ waitlistDao.getWaitlistEntryByOwnerId(ownerId)
│  └─ SELECT * FROM gym_owner_waitlist WHERE ownerId = ?
│
├─ gymOwnerDao.addGymOwner(approvedOwner)
│  └─ INSERT INTO gym_owner
│     (ownerId, email, password, accountNumber, panNumber)
│
└─ waitlistDao.removeFromWaitlist(ownerId)
   └─ DELETE FROM gym_owner_waitlist WHERE ownerId = ?

Output: "Owner moved to gym_owner table successfully."
```

---

## SQL Queries Reference

### Insert to Waitlist (Registration)
```sql
INSERT INTO gym_owner_waitlist (ownerId, email, password, accountNumber, panNumber)
VALUES ('550e8400-e29b-41d4-a716-446655440000', 'john@example.com', 'hashed_password', 'ACC123456', 'PAN98765');
```

### Select Pending Requests (Admin View)
```sql
SELECT * FROM gym_owner_waitlist;
```

### Insert Approved Owner (Approval)
```sql
INSERT INTO gym_owner (ownerId, email, password, accountNumber, panNumber)
VALUES ('550e8400-e29b-41d4-a716-446655440000', 'john@example.com', 'hashed_password', 'ACC123456', 'PAN98765');
```

### Delete from Waitlist (After Approval)
```sql
DELETE FROM gym_owner_waitlist WHERE ownerId = '550e8400-e29b-41d4-a716-446655440000';
```

---

## Implementation Status

### Current Implementation (In-Memory Storage)
✅ All business logic implemented
✅ Workflow correctly structured
✅ DAO layer ready for database integration

### TODO: Database Integration

Replace the TODO comments in `GymOwnerWaitlistDaoImpl.java` with actual SQL queries:

```java
// TODO: INSERT INTO gym_owner_waitlist (ownerId, email, password, accountNumber, panNumber) VALUES (...)
// TODO: SELECT * FROM gym_owner_waitlist WHERE ownerId = ?
// TODO: SELECT * FROM gym_owner_waitlist (all pending entries)
// TODO: DELETE FROM gym_owner_waitlist WHERE ownerId = ?
// TODO: SELECT COUNT(*) FROM gym_owner_waitlist WHERE ownerId = ?
```

Add a database connection class and update methods to use:
- JDBC Connection
- PreparedStatement
- ResultSet mapping

---

## Testing the Workflow

### Test Case 1: Single Registration and Approval

```
1. Run ApplicationMenu
2. Select "3. Register Gym Owner"
3. Input:
   - Email: john@example.com
   - Password: pass123
   - Account Number: 123456789
   - PAN Number: ABCD1234E
   
Output: "Your request ID is: [generated-id]"

4. Check database:
   SELECT * FROM gym_owner_waitlist;
   ✓ Should see one entry with above data

5. Switch to Admin
6. Select "1. View Pending Gym Owner Requests"
   
Output:
   Owner ID: [generated-id]
   Email: john@example.com
   Account Number: 123456789
   PAN Number: ABCD1234E

7. Select "2. Approve Gym Owner"
8. Enter Owner ID from step 6
   
Output: "Owner moved to gym_owner table successfully."

9. Check database:
   SELECT * FROM gym_owner;
   ✓ Should see entry moved from waitlist
   
   SELECT * FROM gym_owner_waitlist;
   ✓ Should be empty or missing the entry
```

### Test Case 2: Multiple Registrations

```
1. Register Owner 1
2. Register Owner 2
3. Register Owner 3
4. Admin views pending
   ✓ Should see all 3 requests
5. Approve Owner 1
   ✓ Owner 1 moves to gym_owner table
   ✓ Waitlist now shows 2 entries
6. Approve Owner 2
   ✓ Owner 2 moves to gym_owner table
   ✓ Waitlist now shows 1 entry
```

---

## Files Modified

1. ✅ `bean/GymOwnerWaitlist.java` - NEW
2. ✅ `dao/GymOwnerWaitlistDaoInterface.java` - NEW
3. ✅ `dao/GymOwnerWaitlistDaoImpl.java` - NEW
4. ✅ `client/ApplicationMenu.java` - MODIFIED
5. ✅ `business/GymOwnerService.java` - MODIFIED
6. ✅ `business/AdminService.java` - MODIFIED
7. ✅ `client/AdminMenu.java` - MODIFIED

---

## Next Steps

1. **Database Connection Setup**
   - Create DatabaseConnection class
   - Add connection pooling (optional)
   - Test connectivity

2. **Update DAO Implementation**
   - Replace in-memory HashMap with SQL queries
   - Add error handling
   - Add logging

3. **Add Data Validation**
   - Email format validation
   - PAN number validation
   - Account number validation

4. **Add Error Handling**
   - Duplicate email checks
   - Invalid owner ID checks
   - Database connection failures

5. **Security Enhancements**
   - Password hashing (SHA256 or BCrypt)
   - SQL injection prevention (use PreparedStatement)
   - Input sanitization

---

## Status

✅ **Workflow Implementation**: Complete
✅ **Business Logic**: Complete
✅ **DAO Layer**: Ready for database integration
⏳ **Database Integration**: TODO
⏳ **Error Handling**: TODO
⏳ **Security**: TODO

**Current State**: Ready for testing with in-memory storage or database integration
