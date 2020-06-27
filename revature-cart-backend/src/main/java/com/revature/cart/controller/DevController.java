package com.revature.cart.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.cart.model.Cart;
import com.revature.cart.model.CartItem;
import com.revature.cart.service.container.CartServiceContainer;

@RestController
public class DevController {
	private CartServiceContainer csc;
	
	@Autowired
	public DevController(CartServiceContainer csc) {
		this.csc = csc;
	}
	
	// this is a temporary dev tool.
	// it creates mock data for the h2 database since we currently do not have an RDS.
	@GetMapping("/devInit")
	private ArrayList<Cart> h2Init() {
		Cart c1 = new Cart();
		Cart c2 = new Cart();
		Cart c3 = new Cart();
		c1.setCartItems(new ArrayList<CartItem>());
		c2.setCartItems(new ArrayList<CartItem>());
		c3.setCartItems(new ArrayList<CartItem>());
		c1.setUserId(2021);
		c2.setUserId(2021);
		c3.setUserId(2021);
		c1.setName("Birthday");
		c2.setName("Hanukkah");
		c3.setName("Christmas");
		CartItem ci1 = new CartItem();
		CartItem ci2 = new CartItem();
		CartItem ci3 = new CartItem();
		CartItem ci4 = new CartItem();
		CartItem ci5 = new CartItem();
		ci1.setProductId(1103);
		ci2.setProductId(1103);
		ci3.setProductId(1102);
		ci4.setProductId(1101);
		ci5.setProductId(1102);
		ci1.setQuantity(12);
		ci2.setQuantity(1);
		ci3.setQuantity(5);
		ci4.setQuantity(5);
		ci5.setQuantity(50);
		
		c1.addCartItem(ci1);
		c2.addCartItem(ci2);
		c2.addCartItem(ci3);
		c3.addCartItem(ci4);
		c3.addCartItem(ci5);
		
		c1 = csc.createCart(c1);
		c2 = csc.createCart(c2);
		c3 = csc.createCart(c3);
		
		ArrayList<Cart> carts = new ArrayList<>();
		carts.add(c1);
		carts.add(c2);
		carts.add(c3);
		
		return carts;
	}
}
