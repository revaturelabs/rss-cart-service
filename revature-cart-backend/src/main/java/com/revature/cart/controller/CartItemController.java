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
	
	@PostMapping("/cartItem")
	public CartItem createCartItem(@RequestBody CartItem ci) {
		return cisc.createCartItem(ci);
	}
	
	@GetMapping("cartItem/{id}")
	public CartItem getCartItemById(@PathVariable("id") int id) {
		return cisc.getCartItemById(id);
	}
	
	@GetMapping("cartItems")
	public List<CartItem> getAllCartItems() {
		return cisc.getAllCartItems();
	}
	
	@PutMapping("cartItem")
	public CartItem updateCartItem(@RequestBody CartItem ci) {
		return cisc.updateCartItem(ci);
	}
	
	@DeleteMapping("cartItem/{id}")
	public void deleteCartItemById(@PathVariable("id") int id) {
		cisc.deleteCartItemById(id);
	}
	
}



















