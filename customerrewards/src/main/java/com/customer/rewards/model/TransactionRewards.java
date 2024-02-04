package com.customer.rewards.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "rewards")
public class TransactionRewards {



	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "custid")
	private String customerId;
	
	@Column(name = "name")
	private String customerName;

	@Column(name = "amount")
	private Double transactionAmount;
	
	@Column(name = "rewards")
	private Integer rewards;
	
	@Column(name = "transactiondate")
	private LocalDate transactionDate;

}
