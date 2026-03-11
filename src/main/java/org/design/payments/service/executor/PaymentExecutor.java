package org.design.payments.service.executor;

import org.design.payments.domain.PaymentDetails;
import org.design.payments.domain.Payments;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PaymentExecutor implements Callable<Boolean> {
    private Payments payments;
    private PaymentDetails details;

    public PaymentExecutor(Payments payments, PaymentDetails details) {
        this.payments = payments;
        this.details = details;
    }

    @Override
    public Boolean call() throws Exception {
        return payments.pay(details);
    }
}
