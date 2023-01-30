package com.cognizant.payments.publisher;

import com.cognizant.payments.models.Account;

public class PaymentNotificationServiceDefault implements PaymentNotificationService{
    @Override
    public void pay(Account account, double payment) {
        System.out.printf("Account ["+account.getName()+"] customer ["+ account.getCustomer().getName()+
        		"] payment=["+payment+"]  Balance: "+account.getBalance() );
        System.out.println("");
    }
}
