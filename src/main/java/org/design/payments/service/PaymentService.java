package org.design.payments.service;

import org.design.payments.domain.PaymentDetails;
import org.design.payments.domain.Payments;
import org.design.payments.service.executor.PaymentExecutor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PaymentService {
    private Payments payments;

    //Declare an executor service to manage asynchronous payment processing
    private ExecutorService executorService = Executors.newFixedThreadPool(10);



    public PaymentService(Payments payments) {
        this.payments = payments;
    }

    public boolean processPayment(PaymentDetails details) {
        // Create a callable task for processing the payment
        Callable<Boolean> paymentTask = new PaymentExecutor(payments, details);

        try {
            // Submit the payment task to the executor service and wait for the result
            return executorService.submit(paymentTask).get();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


}
