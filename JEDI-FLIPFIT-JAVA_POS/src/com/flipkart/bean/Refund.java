package flipkart.bean;

import flipkart.constants.RefundStatus;

public class Refund {
    private String refundId;

    public String getOriginalPaymentId() {
        return originalPaymentId;
    }

    public void setOriginalPaymentId(String originalPaymentId) {
        this.originalPaymentId = originalPaymentId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getRefundId() {
        return refundId;
    }

    public void setRefundId(String refundId) {
        this.refundId = refundId;
    }

    public RefundStatus getStatus() {
        return status;
    }

    public void setStatus(RefundStatus status) {
        this.status = status;
    }

    private String originalPaymentId;
    private String reason;
    private RefundStatus status;
}
