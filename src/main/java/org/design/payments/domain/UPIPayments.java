package org.design.payments.domain;

public class UPIPayments implements Payments {
    @Override
    public boolean pay(PaymentDetails details) {
        // process credit card payment
        System.out.println("Calling UPI payment");

        return true;
    }
}
