package org.design.payments.domain.cor;

import org.design.payments.domain.cor.Payments;
import org.design.payments.domain.PaymentDetails;

public class UPIPayments implements Payments {

    Payments nextPaymentHandler;

    @Override
    public boolean pay(PaymentDetails details) {
        boolean isSuccessful = false;

        // process UPI payment
        System.out.println("Calling UPI payment");

        //Code for handling UPI payment

        //After processing the payment, if it is not successful, call the next handler in the chain
        if (!isSuccessful) {
            return nextHandler(details);
        }

        //if the payment is successful, return true
        return true;
    }

    @Override
    public boolean nextHandler(PaymentDetails detail) {
        if (nextPaymentHandler != null) {
            return nextPaymentHandler.pay(detail);
        }

        //if there are no more handlers in the chain, return false
        return false;
    }

    //Implement a method to set the next handler in the chain
    public void setNextPaymentHandler(org.design.payments.domain.cor.Payments nextPaymentHandler) {
        this.nextPaymentHandler = nextPaymentHandler;
    }
}