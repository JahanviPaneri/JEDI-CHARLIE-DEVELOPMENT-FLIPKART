package flipkart.bean;

public class Admin extends User { private String adminID;

    public Admin(String adminID) {
        this.adminID = adminID;
    }

    public String getAdminID() {
        return adminID;
    }

    public void setAdminID(String adminID) {
        this.adminID = adminID;
    }
}