package org.design.payments;

import org.design.payments.domain.PaymentDetails;
import org.design.payments.domain.Payments;

import java.util.List;

class PaymentAggregator {
    List<Payments> paymentTypeList;

    public boolean pay(PaymentDetails details) {
        int i = 0;
        Payments paymentType = null;
        boolean isPaymentSuccessful = false;

        do {
            paymentType = paymentTypeList.get(i++);
            isPaymentSuccessful = paymentType.pay(details);
        } while (!isPaymentSuccessful && i < paymentTypeList.size());

        return isPaymentSuccessful;
    }
}