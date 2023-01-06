package org.acme;

import lombok.Data;

@Data
public class Payment {
    int customerId;
    int merchantId;
    int paymentAmount;

    public Payment(int customerId, int merchantId, int paymentAmount) {
        this.customerId = customerId;
        this.merchantId = merchantId;
        this.paymentAmount = paymentAmount;
    }

}
