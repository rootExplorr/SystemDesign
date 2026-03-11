package org.design.payments.domain;

public class DebitCardPayments implements Payments {
    @Override
    public boolean pay(PaymentDetails details) {
        // process credit card payment
            System.out.println("Calling Debit Card payment");

            return true;
    }
}
