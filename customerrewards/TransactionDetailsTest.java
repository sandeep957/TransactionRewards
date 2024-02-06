package com.customer.rewards.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TransactionDetailsTest {
	
	    @Test
	    public void testTransactionDetails() {
		 TransactionDetails details = new TransactionDetails();
		 details.setCustomerId("123");
		 details.setCustomerName("abc");
		 details.setTransactionAmount(123.25);
		 
		 assertEquals( "123", details.getCustomerId());
		 assertEquals( "abc", details.getCustomerName());
		 assertEquals( 123.25, details.getTransactionAmount());
	 
	 }
	

}
