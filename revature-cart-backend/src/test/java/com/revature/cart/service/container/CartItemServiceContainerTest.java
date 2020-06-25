package com.revature.cart.service.container;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.revature.cart.model.Cart;
import com.revature.cart.model.CartItem;

@SpringBootTest
class CartItemServiceContainerTest {

	@Autowired
	CartItemServiceContainer cisc;
	
	@Autowired
	CartServiceContainer csc;

	@Test
	void test_createCartItem() {

		CartItem cartItem = new CartItem();
		List<CartItem> cartItemListEmpty = new ArrayList<>();

		Cart cart = new Cart();
		cart.setCartId(1);
		cart.setUserId(1);
		// cart.setName("need a name ?");
		cart.setCartItems(cartItemListEmpty);


		//cartItem.setCartItemId(1);
		cartItem.setCart(cart);
		cartItem.setProductId(1);
		cartItem.setQuantity(1);

		cisc.createCartItem(cartItem);
		System.out.println("\n\nHelloWorld! " + cart.toString());
		System.out.println("\n\nHelloWorld! " + cart.getCartId());
		
		
		List<CartItem> cartItemListFromDB = new ArrayList<>();
		//CartItem cartItem1 = cisc.getCartItemById(cartItem.getCartItemId());
		
		// fill List with getCartItemById (the Cart's id)
		cartItemListFromDB.add(cisc.getCartItemById(cart.getCartId()));

		assertEquals(1, cartItemListFromDB.size());
	}

//	@Test
//	void test_deleteCartItem() {
//
//		CartItem cartItem = new CartItem();
//		List<CartItem> cartItemListEmpty = new ArrayList<>();
//
//		Cart cart = new Cart();
//		cart.setCartId(1);
//		cart.setUserId(1);
//		// cart.setName("need a name ?");
//		cart.setCartItems(cartItemListEmpty);
//
//		cartItem.setCartItemId(1);
//		cartItem.setCart(cart);
//		cartItem.setProductId(1);
//		cartItem.setQuantity(1);
//
//		cisc.createCartItem(cartItem);
//		List<CartItem> ciFromDB = new ArrayList<>();
//		ciFromDB.add(cisc.getCartItemById(cart.getCartId()));
//		int before = ciFromDB.size();
//		
//		cisc.deleteCartItemById(cartItem.getCartItemId());
//		assertEquals(before, (ciFromDB.size() + 1));
//	}
	
	@Test
	void test_deleteCartItem() {

		CartItem cartItem = new CartItem();
		List<CartItem> cartItemListEmpty = new ArrayList<>();

		Cart cart = new Cart();
		cart.setCartId(1);
		cart.setUserId(1);
		// cart.setName("need a name ?");
		cart.setCartItems(cartItemListEmpty);

		//cartItem.setCartItemId(1);
		csc.createCart(cart);
		
		
		cartItem.setCart(cart);
		cartItem.setProductId(1);
		cartItem.setQuantity(1);

		cisc.createCartItem(cartItem);
		List<CartItem> ciFromDB = new ArrayList<>();
		ciFromDB.add(cisc.getCartItemById(cart.getCartId()));
		int before = ciFromDB.size();
		
		cisc.deleteCartItemById(cartItem.getCartItemId());
		assertEquals(before, (ciFromDB.size() + 1));
	}

}


























