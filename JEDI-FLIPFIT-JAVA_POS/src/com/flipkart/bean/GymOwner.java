package flipkart.bean;

public class GymOwner {

    private String ownerId;
    private String accountNumber;
    private String panNumber;

    public GymOwner(String ownerId, String accountNumber, String panNumber) {
        this.ownerId = ownerId;
        this.accountNumber = accountNumber;
        this.panNumber = panNumber;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getPanNumber() {
        return panNumber;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }
}