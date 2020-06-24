package com.revature.cart.service;
import java.util.List;

import com.revature.cart.model.CartItem;
public interface CartItemService {
	
	
	// CREATE
	
	/**
	 * Saves the cart item to the database
	 * @param item The object of the model passed in to save
	 * @return if saved, returns the saved item, if not returns null
	 */
	public CartItem createCartItem(CartItem item);
	
	// READ

	/**
	 * Gets all the cart items
	 * @return List<CartItem> the list of items retrieved by JPA
	 */
	public List<CartItem> getAllCartItems();
	
	/**
	 * Gets a cart item based on a given ID
	 * @param id the id of the cart item
	 * @return the cart item returned by JPA
	 */
	public CartItem getCartItemById(int id);
	
	
	// UPDATE
	
	/**
	 * Updates a specific cart item by id
	 * @param id the id of the item to be updated
	 * @return 
	 */
	public CartItem updateCartItemById(int id);
	
	public CartItem updateCartItem(CartItem item);
	
	// DELETE 
	
	/**
	 * Deletes the cart item
	 * @param id the id of the item to be deleted
	 */
	public void deleteCartItemById(int id);
	
	public void deleteCartItem(CartItem item);

	

	

	



}
