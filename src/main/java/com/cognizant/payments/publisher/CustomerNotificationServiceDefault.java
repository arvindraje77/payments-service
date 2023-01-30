package com.cognizant.payments.publisher;

import com.cognizant.payments.models.Customer;
import com.cognizant.payments.models.Membership;

public class CustomerNotificationServiceDefault implements CustomerNotificationService
{
    @Override
    public void membershipChange(Customer customer, Membership oldLabel, Membership newLabel) {
        System.out.printf("notify customer ["+customer.getName()+"] membership moving from ["+oldLabel+"] to ["+newLabel+"]");
        System.out.println();
    }
}
