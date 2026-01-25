package flipkart.bean;

public class Admin extends User{
    public String getAdminID() {
        return adminID;
    }

    public void setAdminID(String adminID) {
        this.adminID = adminID;
    }

    private String adminID;

}
