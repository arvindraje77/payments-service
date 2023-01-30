package com.cognizant.payments.publisher;

import com.cognizant.payments.models.Account;

public interface PaymentNotificationService {
    void pay(Account account, double payment);
}
