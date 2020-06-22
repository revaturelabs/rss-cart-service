package com.revature.cart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.cart.model.Cart;
import com.revature.service.container.CartServiceContainer;

@RestController
public class CartController {
	private CartServiceContainer csc;
	@Autowired
	public CartController(CartServiceContainer csc) {
		this.csc = csc;
	}
	
	@GetMapping("/carts")
	public List<Cart> getAllCarts() {
		return csc.getAllCarts();
	}
	
	@PostMapping("/cart")
	public Cart postCart(@RequestBody Cart cart) {
		return csc.createCart(cart);
	}
}
