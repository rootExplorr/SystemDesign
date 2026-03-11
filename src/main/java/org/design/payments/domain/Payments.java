package org.design.payments.domain;

import org.design.payments.domain.PaymentDetails;

public interface Payments {
        public boolean pay(PaymentDetails details);
}