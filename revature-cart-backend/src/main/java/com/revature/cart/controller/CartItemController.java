package com.revature.cart.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.cart.model.CartItem;
import com.revature.cart.service.container.CartItemServiceContainer;

@CrossOrigin
@RestController
@RequestMapping("/cartitem")
public class CartItemController {
	
	private CartItemServiceContainer cisc;
	
	@Autowired
	public CartItemController(CartItemServiceContainer cisc) {
		this.cisc = cisc;
	}
	
	@PostMapping
	public CartItem createCartItem(@RequestBody CartItem ci) {
		ArrayList<CartItem> list1 = (ArrayList<CartItem>) cisc.getCartItemsByProductId(ci.getProductId());
		for (CartItem cartItem : list1) {
		  if (cartItem.getCart().getCartId() == ci.getCart().getCartId()) {
		    cartItem.setQuantity(ci.getQuantity() + cartItem.getQuantity());
		    return cisc.updateCartItem(cartItem);
		  }
		}
					
		return cisc.createCartItem(ci);
	}
	
	@GetMapping("/{id}")
	public CartItem getCartItemById(@PathVariable("id") int id) {
		return cisc.getCartItemById(id);
	}
	
	@GetMapping("s/{id}")
	public List<CartItem> getAllCartItems(@PathVariable("id") int cartId) {
		return cisc.getCartItemsByCartId(cartId);
	}
	
	@PutMapping
	public CartItem updateCartItem(@RequestBody CartItem ci) {
		return cisc.updateCartItem(ci);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCartItemById(@PathVariable("id") int id) {
		cisc.deleteCartItemById(id);
	}
	
}



















