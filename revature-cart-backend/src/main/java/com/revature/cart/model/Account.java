package com.revature.cart.model;

import javax.persistence.*;

@Entity(name = "account")
@Table
public class Account {

	@Id
	private int accountNumber;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	private Customer customer;
	private int availablePoints;
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountID) {
		this.accountNumber = accountID;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getAvailablePoints() {
		return availablePoints;
	}

	public void setAvailablePoints(int availablePoints) {
		this.availablePoints = availablePoints;
	}
	
	
	
}
