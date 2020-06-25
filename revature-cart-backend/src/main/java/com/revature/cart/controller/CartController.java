package com.revature.cart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.cart.model.Cart;
import com.revature.cart.service.container.CartServiceContainer;

@RestController
@RequestMapping("/cart")
public class CartController {
	
	/**
	 * Link to the service container service layer
	 */
	private CartServiceContainer csc;
	
	/**
	 * Constructor for this controller 
	 * @param csc the service container passed in
	 */
	@Autowired
	public CartController(CartServiceContainer csc) {
		this.csc = csc;
	}
	
	/**
	 * Saves the cart object to the database
	 * @param cart the cart object to be saved
	 * @return the cart that was just saved, if save was unsuccessful it will return null
	 */
	@PostMapping
	public Cart createCart(@RequestBody Cart cart) {
		return csc.createCart(cart);
	}
	
	/**
	 * Retrieves an individual cart by id
	 * @param userId the identification of user 
	 * @return a List<Cart> all the carts associated with given user id
	 * 
	 */
	@GetMapping("s/{id}")
	public List<Cart> getCartsByUserId(@PathVariable("id") int userId) {
		return csc.getCartsByUserId(userId);
	}
	
	/**
	 * Retrieves unique cart based on cart id
	 * @param id the id of the cart
	 * @return the individual cart by id
	 */
	@GetMapping("/{id}")
	public Cart getCartById(@PathVariable("id") int id) {
		return csc.getCartById(id);
	}
	
	/**
	 * Updates an already existing cart
	 * @param cart the cart to update
	 * @return the updated cart
	 */
	@PutMapping
	public Cart updateCart(@RequestBody Cart cart) {
		return csc.updateCart(cart);
	}
	
	/**
	 * Deletes a cart from the database
	 * @param id the id of the cart to delete
	 */
	@DeleteMapping("/{id}")
	public void deleteCartById(@PathVariable("id") int id) {
		csc.deleteCartById(id);
	}
}
