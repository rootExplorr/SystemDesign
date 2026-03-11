package org.design.payments.domain.cor;

import org.design.payments.domain.PaymentDetails;

public interface Payments {
        boolean pay(PaymentDetails detail);
        boolean nextHandler(PaymentDetails detail);
}