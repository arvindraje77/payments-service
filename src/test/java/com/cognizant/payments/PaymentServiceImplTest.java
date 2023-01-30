package com.cognizant.payments;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.cognizant.payments.impl.PaymentServiceImpl;
import com.cognizant.payments.models.Account;
import com.cognizant.payments.models.Customer;
import com.cognizant.payments.models.Membership;
import com.cognizant.payments.publisher.CustomerNotificationServiceDefault;
import com.cognizant.payments.publisher.PaymentNotificationServiceDefault;

public class PaymentServiceImplTest {

	private Account GOLD_ACCOUNT = new Account(1001, "Premier Track", new Customer(101, "First Digital"), 500_000, Membership.GOLD); ;
	private Account SILVER_ACCOUNT = new Account(1003, "Tinsel", new Customer(101, "Jane Luna"), 150_000, Membership.SILVER); ;
	private Account BRONZE_ACCOUNT = new Account(1005, "Russet", new Customer(101, "Cast Cooper"), 40_000, Membership.BRONZE); ;
	private Account GOLD_TO_SILVER_ACCOUNT = new Account(1001, "Premier Track", new Customer(101, "First Digital"), 250_000, Membership.GOLD); ;
	private Account SILVER_TO_BRONZE_ACCOUNT = new Account(1005, "Tinsel", new Customer(101, "Jane Luna"), 52_000, Membership.SILVER); ;
	private static PaymentServiceImpl paymentService;
	
	@Test
	public void how_do_I_do_this() {
		/*System.out.println("Hello. Is it me that you're looking for?");
		System.out.println("\t\t\tLionel Richie, singer-songwriter; 1983, Album: Can't Slow Down");
		System.out.println("\t\t\t\tGenre: R&B / Modern Soul");
		System.out.println("\t\t\t\thttps://www.youtube.com/watch?v=mHONNcZbwDY");

	    var paymentService = new PaymentServiceImpl(new CustomerNotificationServiceDefault(), new PaymentNotificationServiceDefault());
		assertThat(paymentService.getServiceName(), is("PaymentServiceImpl"));
		*/
	}
	
	@BeforeAll
	public static void getObject() {
		paymentService = new PaymentServiceImpl(new CustomerNotificationServiceDefault(), new PaymentNotificationServiceDefault());
	}
	
	@Test
	public void processPaymentTest1() {
	    paymentService.processPayment(GOLD_ACCOUNT, 499.99, 100);
	}
	
	@Test
	public void processPaymentTest2() {
	    paymentService.processPayment(GOLD_ACCOUNT, 499.99, 50);
	}

	@Test
	public void processPaymentTest3() {
	    paymentService.processPayment(GOLD_ACCOUNT, 499.99, 25);
	}
	
	@Test
	public void processPaymentTest4() {
	    paymentService.processPayment(SILVER_ACCOUNT, 299.99, 100);
	}
	
	@Test
	public void processPaymentTest5() {
	    paymentService.processPayment(BRONZE_ACCOUNT, 199.99, 50);
	}
	
	@Test
	public void processPaymentTest6() {
	    paymentService.processPayment(GOLD_TO_SILVER_ACCOUNT, 299.99, 50);
	}
	
	@Test
	public void processPaymentTest7() {
	    paymentService.processPayment(SILVER_TO_BRONZE_ACCOUNT, 199.99, 25);
	}
	
	@AfterAll
	public static void nullifyObject() {
		paymentService = null;
	}
	
}

