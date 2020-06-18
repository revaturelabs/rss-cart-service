package com.revature.cart.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "customer")
@Table
public class Customer {

	@Id
	private int customerID;
	@OneToMany(mappedBy = "account.customer")
	private List<Account> accounts = new ArrayList<>();
	@OneToMany(mappedBy = "cart.customer")
	private List<Cart> carts = new ArrayList<>();

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(int customerID, List<Account> accounts, List<Cart> carts) {
		super();
		this.customerID = customerID;
		this.accounts = accounts;
		this.carts = carts;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public List<Cart> getCarts() {
		return carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}

	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", accounts=" + accounts + ", carts=" + carts + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + customerID;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (customerID != other.customerID)
			return false;
		return true;
	}
	
}
