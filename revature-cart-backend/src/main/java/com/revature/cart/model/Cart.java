package com.revature.cart.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity(name = "cart")
@Table
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cartId;
	@Column(name = "user_id")
	private int userId;
	@Column(name = "name")
	private String name;
	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<CartItem> cartItems;

	public Cart() {
		super();
	}

	public Cart(int cartId, int userId, List<CartItem> cartItems) {
		super();
		this.cartId = cartId;
		this.userId = userId;
		this.cartItems = cartItems;
	}

	public int getCartID() {
		return cartId;
	}

	public void setCartID(int cartID) {
		this.cartId = cartID;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public List<CartItem> getCartItems() {
		return cartItems;
	}
	
	public void addCartItem(CartItem cartItem) {
		addCartItem(cartItem, true);
	}
	
	public void addCartItem(CartItem cartItem, boolean reciprocate) {
		if (cartItem != null) {
			if (this.cartItems.contains(cartItem)) {
				this.cartItems.set(this.cartItems.indexOf(cartItem), cartItem);
			} else {
				this.cartItems.add(cartItem);
			}
			if (reciprocate) {
				cartItem.setCart(this, false);
			}
		}
	}
	
	public void removeCartItem(CartItem cartItem) {
		this.cartItems.remove(cartItem);
		cartItem.setCart(null);
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cartId;
		return result;
	}

	// only checks cartId
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cart other = (Cart) obj;
		if (cartId != other.cartId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cart [cartID=" + cartId + ", userId=" + userId + ", cartItems=" + cartItems + "]";
	}
}
