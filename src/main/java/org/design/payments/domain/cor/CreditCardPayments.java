package org.design.payments.domain.cor;

import org.design.payments.domain.cor.Payments;
import org.design.payments.domain.PaymentDetails;

//COR stands for Chain of responsibility.
public class CreditCardPayments implements Payments {
    Payments nextPaymentHandler;

    @Override
    public boolean pay(PaymentDetails details) {
        boolean isSuccessfulPayment = false;

        // process credit card payment
        System.out.println("Calling Credit Card payment");

        //Code to process credit card payment

        //if payment was not successful, call the next handler in the chain
        if (!isSuccessfulPayment) {
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

    //Implement a method to set the next handler in the chain\
    public void setNextPaymentHandler(Payments nextPaymentHandler) {
        this.nextPaymentHandler = nextPaymentHandler;
    }
}
