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

import com.revature.cart.model.CartItem;
import com.revature.cart.service.container.CartItemServiceContainer;

@CrossOrigin
@RestController
public class CartItemController {
	
	private CartItemServiceContainer cisc;
	
	@Autowired
	public CartItemController(CartItemServiceContainer cisc) {
		this.cisc = cisc;
	}
	
	@PostMapping("/cartitem")
	public CartItem createCartItem(@RequestBody CartItem ci) {
		CartItem other = cisc.getCartItemsByCartIdAndProductId(ci.getCart().getCartId(), ci.getProductId());
		if (other != null) {
			other.setQuantity(ci.getQuantity() + other.getQuantity());
		    return cisc.updateCartItem(other);
		}
		return cisc.createCartItem(ci);
	}
	
	@GetMapping("/cartitem/{id}")
	public CartItem getCartItemById(@PathVariable("id") int id) {
		return cisc.getCartItemById(id);
	}
	
	@GetMapping("/cartitems/{id}")
	public List<CartItem> getAllCartItems(@PathVariable("id") int cartId) {
		return cisc.getCartItemsByCartId(cartId);
	}
	
	@PutMapping("/cartitem")
	public CartItem updateCartItem(@RequestBody CartItem ci) {
		return cisc.updateCartItem(ci);
	}
	
	@DeleteMapping("/cartitem/{id}")
	public void deleteCartItemById(@PathVariable("id") int id) {
		cisc.deleteCartItemById(id);
	}
	
}
