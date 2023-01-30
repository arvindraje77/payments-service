package com.cognizant.payments.publisher;

import com.cognizant.payments.models.Customer;
import com.cognizant.payments.models.Membership;

public interface CustomerNotificationService {

    void membershipChange(Customer customer, Membership oldLabel, Membership newLabel);

}
