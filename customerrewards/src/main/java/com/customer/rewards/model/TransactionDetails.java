package com.customer.rewards.model;

import lombok.Data;

@Data
public class TransactionDetails {


	private String customerId;
	
	private String customerName;

	private Double transactionAmount;

	
}
