package com.revature.cart.model;

import javax.persistence.*;

@Entity(name = "cart")
@Table
public class Cart {

	@Id
	@GeneratedValue
	private int cartID;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	private Customer customer;
	
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cart(int cartID, Customer customer) {
		super();
		this.cartID = cartID;
		this.customer = customer;
	}

	public int getCartID() {
		return cartID;
	}

	public void setCartID(int cartID) {
		this.cartID = cartID;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Cart [cartID=" + cartID + ", customer=" + customer + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cartID;
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
		Cart other = (Cart) obj;
		if (cartID != other.cartID)
			return false;
		return true;
	}
	
}
