package com.revature.service;

import java.util.List;

import com.revature.cart.model.Cart;

public interface CartService {
	
	/**
	 * Gets all the cart items
	 * @return List<Cart> the list of items retrieved by JPA
	 */
	public List<Cart> getAllCarts();
	
	/**
	 * Gets a cart item based on a given ID
	 * @param id the id of the cart item
	 * @return the cart item returned by JPA
	 */
	public Cart getCartById(int id);
	
	/**
	 * Saves the cart item to the database
	 * @param item The object of the model passed in to save
	 * @return if saved, returns the saved item, if not returns null
	 */
	public Cart createCart(Cart cart);
	
	/**
	 * Deletes the cart item
	 * @param id the id of the item to be deleted
	 */
	public void deleteCartById(int id);
	
	/**
	 * Updates a specific cart item by id
	 * @param id the id of the item to be updated
	 */
	public void updateCartById(int id);

}