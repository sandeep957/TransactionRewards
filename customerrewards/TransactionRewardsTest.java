package com.customer.rewards.model;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TransactionRewardsTest {
	
	@Test
	public void testTransactionRewards() {
		TransactionRewards rewards = new TransactionRewards();
		rewards.setCustomerId("123");
		rewards.setCustomerName("xyz");
		rewards.setId(12L);
		rewards.setRewards(2222);
		rewards.setTransactionAmount(123.25);
		
		 assertEquals( "123", rewards.getCustomerId());
		 assertEquals( "xyz", rewards.getCustomerName());
		 assertEquals( 123.25, rewards.getTransactionAmount());
		 assertEquals( 12L, rewards.getId());
		 assertEquals( 2222, rewards.getRewards());
		
	}

}
