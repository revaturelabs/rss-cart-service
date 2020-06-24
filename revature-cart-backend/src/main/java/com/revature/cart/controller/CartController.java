package com.revature.cart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.cart.model.Cart;
import com.revature.cart.service.container.CartServiceContainer;

@RestController
public class CartController {
	private CartServiceContainer csc;
	@Autowired
	public CartController(CartServiceContainer csc) {
		this.csc = csc;
	}
	
	@PostMapping("/cart")
	public Cart createCart(@RequestBody Cart cart) {
		return csc.createCart(cart);
	}
	
	@GetMapping("/carts/user/{id}")
	public List<Cart> getCartsByUserId(@PathVariable("id") int id) {
		return csc.getCartsByUserId(id);
	}
	
	@GetMapping("/cart/id/{id}")
	public Cart getCartById(@PathVariable("id") int id) {
		return csc.getCartById(id);
	}
	
	@PutMapping("/cart")
	public Cart updateCart(@RequestBody Cart cart) {
		return csc.updateCart(cart);
	}
	
	@DeleteMapping("/cart/id/{id}")
	public void deleteCartById(@PathVariable("id") int id) {
		csc.deleteCartById(id);
	}
	

//	public void purchaseCartById(@PathVariable("id") int id) { 
//		// We have two ways to do this: with or without redundant checks
//		// Without Redundant Checks:
//		// Front end takes care of all the math, so we just work like a delete mapping.
//			// delete all the cartItems and the cart.
//		
//		// With Redundant Checks:
//		// get the cart
//		// loop through all the cartItems associated with it
//		// make calls to Max's MicroService to ensure that we have enough stock for everything
//		// ensure that we have enough points in the accounts that we're subtracting from
//		// subtract the points in the other MS
//		// subtract the stock from Max's MS
//		// Delete all the CartItems
//		// Delete the Cart
//		// Return a success message if everything goes OK, error if not.
//	}
}
