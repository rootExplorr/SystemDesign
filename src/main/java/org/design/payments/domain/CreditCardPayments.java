package org.design.payments.domain;

public class CreditCardPayments implements Payments {
    @Override
    public boolean pay(PaymentDetails details) {
        // process credit card payment
        System.out.println("Calling Credit Card payment");

        return true;
    }
}
