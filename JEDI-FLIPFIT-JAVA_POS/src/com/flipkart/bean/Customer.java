package flipkart.bean;

public class Customer extends User {
    private String customerId;
    private String cardNumber;

    public Customer(String customerId, String cardNumber) {
        this.customerId = customerId;
        this.cardNumber = cardNumber;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}