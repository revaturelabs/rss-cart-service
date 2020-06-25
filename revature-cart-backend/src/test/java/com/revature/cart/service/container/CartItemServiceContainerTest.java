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

		cartItem.setProductId(1);
		cartItem.setQuantity(1);

		cisc.createCartItem(cartItem);
		System.out.println("\n\nHERE IS DATA: ");
		System.out.println("cartItem.getCartItemId(): " + cartItem.getCartItemId());
		System.out.println("cartItem.getQuantity(): " + cartItem.getQuantity());
		

		List<CartItem> cartItemListFromDB = new ArrayList<>();

		// fill List with getCartItemById (the Cart's id)
		cartItemListFromDB.add(cisc.getCartItemById(cartItem.getCartItemId()));

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

		
		List<CartItem> listOfCartItemsFromDB = new ArrayList<>();
		listOfCartItemsFromDB = cisc.getAllCartItems();

		CartItem cartItem = new CartItem();
		// cartItem.setCartItemId(1);
		cartItem.setProductId(1);
		cartItem.setQuantity(1);

		cisc.createCartItem(cartItem);
		System.out.println("\n\nHERE IS DATA: ");
		System.out.println("cartItem.getCartItemId(): " + cartItem.getCartItemId());
		System.out.println("cartItem.getQuantity(): " + cartItem.getQuantity());
		
		// after Creation check size
		int before = listOfCartItemsFromDB.size();
		

		//List<CartItem> cartItemListFromDB = new ArrayList<>();
		// CartItem cartItem1 = cisc.getCartItemById(cartItem.getCartItemId());
		

		// fill List with getCartItemById (the Cart's id)
		//cartItemListFromDB.add(cisc.getCartItemById(cartItem.getCartItemId()));
		

		
		// after deletion check size after adding 1 to it to see if it is equal to Before
		cisc.deleteCartItemById(cartItem.getCartItemId());
		assertEquals(before, (listOfCartItemsFromDB.size() + 1));
	}

}
