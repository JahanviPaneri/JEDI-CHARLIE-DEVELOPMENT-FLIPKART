package com.flipkart.bean;

import com.flipkart.constants.RefundStatus;

public class Refund {

    private String refundId;
    private String originalPaymentId;
    private String reason;
    private RefundStatus status;

    public Refund(String refundId, String originalPaymentId, String reason, RefundStatus status) {
        this.refundId = refundId;
        this.originalPaymentId = originalPaymentId;
        this.reason = reason;
        this.status = status;
    }

    public String getRefundId() {
        return refundId;
    }

    public void setRefundId(String refundId) {
        this.refundId = refundId;
    }

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

    public RefundStatus getStatus() {
        return status;
    }

    public void setStatus(RefundStatus status) {
        this.status = status;
    }
}