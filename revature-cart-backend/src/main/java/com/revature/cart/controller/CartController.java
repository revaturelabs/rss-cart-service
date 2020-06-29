package com.revature.cart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.cart.model.Cart;
import com.revature.cart.service.container.CartServiceContainer;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@CrossOrigin
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
	@PostMapping("/cart")
	@ApiOperation(value = "Create Cart", notes = "Saves the Cart object to the database", response = Cart.class)
	public Cart createCart(@ApiParam(value = "Cart object", required = true) @RequestBody Cart cart) {
		return csc.createCart(cart);
	}
	
	/**
	 * Retrieves a list of carts with the matching User id
	 * @param userId the identification of user 
	 * @return a List<Cart> all the carts associated with given user id
	 */
	@GetMapping("/carts/{id}")
	@ApiOperation(value = "Get Carts by User Id", notes = "Retrieves a list of Carts with the matching User ID", response = Cart.class)
	public List<Cart> getCartsByUserId(@ApiParam(value = "User ID", required = true) @PathVariable("id") int userId) {
		return csc.getCartsByUserId(userId);
	}
	
	/**
	 * Retrieves unique cart based on cart id
	 * @param id the id of the cart
	 * @return the individual cart by id
	 */
	@GetMapping("/cart/{id}")
	@ApiOperation(value = "Get Cart by Cart Id", notes = "Retrieves an individual Cart by Cart ID", response = Cart.class)
	public Cart getCartById(@ApiParam(value = "Cart ID", required = true) @PathVariable("id") int id) {
		return csc.getCartById(id);
	}
	
	/**
	 * Updates an already existing cart
	 * @param cart the cart to update
	 * @return the updated cart
	 */
	@PutMapping("/cart")
	@ApiOperation(value = "Update Cart", notes = "Updates an already existing Cart based on Cart ID", response = Cart.class)
	public Cart updateCart(@ApiParam(value = "Cart object", required = true) @RequestBody Cart cart) {
		return csc.updateCart(cart);
	}
	
	/**
	 * Deletes a cart from the database
	 * @param id the id of the cart to delete
	 */
	@DeleteMapping("/cart/{id}")
	@ApiOperation(value = "Delete Cart", notes = "Deletes a Cart from the database based on Cart ID")
	public void deleteCartById(@ApiParam(value = "Cart ID", required = true) @PathVariable("id") int id) {
		csc.deleteCartById(id);
	}
}
