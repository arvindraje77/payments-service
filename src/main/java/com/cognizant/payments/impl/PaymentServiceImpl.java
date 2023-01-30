package com.cognizant.payments.impl;

import com.cognizant.payments.models.Account;
import com.cognizant.payments.models.Membership;
import com.cognizant.payments.publisher.CustomerNotificationService;
import com.cognizant.payments.publisher.PaymentNotificationService;


public class PaymentServiceImpl {

	private CustomerNotificationService customerNotificationService;
	private PaymentNotificationService paymentNotificationService;

	public PaymentServiceImpl(CustomerNotificationService customerNotificationService, PaymentNotificationService paymentNotificationService) {
		this.customerNotificationService = customerNotificationService;
		this.paymentNotificationService = paymentNotificationService;
	}

	public String getServiceName() {
		return  this.getClass().getSimpleName();
	}

	public void processPayment( Account account, double amount, int salesUnits ) {

		double payment = amount * salesUnits * (1.0 - promotionDischarge(amount, salesUnits));

		account.setBalance( account.getBalance() - payment );

		paymentNotificationService.pay(account, payment);

		Membership oldMembership = account.getMembership();
		Membership newMembership = checkMembership(account);
		if ( newMembership != oldMembership) {
			customerNotificationService.membershipChange(account.getCustomer(), oldMembership, newMembership);
		}

	}

	private double promotionDischarge( double amount, int salesUnits ) {
		double discount = 0.0;
		if ( amount >= 100.0 ) {
			if(salesUnits >= 50 && salesUnits < 100) {
				discount = 4.95/100;
			}else if(salesUnits >= 100) {
				discount = 9.95/100;
			}
		}
		return discount;
	}

	private Membership checkMembership( Account account )
	{
		Membership membership;
		if ( account.getBalance() > 50_000 && account.getBalance() < 250_000) {
			membership = Membership.SILVER;
		}else if ( account.getBalance() > 250_000){
			membership= Membership.GOLD;
		}else 
			membership = Membership.BRONZE;
		
		return membership;
	}

}

