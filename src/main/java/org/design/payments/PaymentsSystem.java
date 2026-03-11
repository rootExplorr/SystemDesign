package org.design.payments;

//Create this as a factory class, responsible for instantiating the payment system, and returning the object back.
//Use an enu for the payment types, and based on the type, return the appropriate payment system object.

import org.design.payments.domain.*;

public class PaymentsSystem {
    public static Payments getPaymentSystem(PaymentType type) {
        switch (type) {
            case CREDIT_CARD:
                return new CreditCardPayments();

            case DEBIT_CARD:
                 return new DebitCardPayments();

            case UPI:
                return new UPIPayments();

            default:
                throw new IllegalArgumentException("Invalid payment type");
        }
    }
}