package com.revature.cart.service.container;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.revature.cart.model.CartItem;

@SpringBootTest
class CartItemServiceContainerTest {

	@Autowired
	CartItemServiceContainer cisc;

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

	@Test
	void test_deleteCartItem() {

		List<CartItem> listOfCartItemsFromDB = new ArrayList<>();

		CartItem cartItem = new CartItem();
		// cartItem.setCartItemId(1);
		cartItem.setProductId(1);
		cartItem.setQuantity(1);

		cisc.createCartItem(cartItem);
		listOfCartItemsFromDB = cisc.getAllCartItems();
		System.out.println("\n\nHERE IS DATA: ");
		System.out.println("cartItem.getCartItemId(): " + cartItem.getCartItemId());
		System.out.println("cartItem.getQuantity(): " + cartItem.getQuantity());

		// after Creation check size
		int before = listOfCartItemsFromDB.size();
		before--; // BECAUSE WE NEED A VALUE TO assertEquals WITH

		// after deletion check size after adding 1 to it to see if it is equal to
		// Before
		cisc.deleteCartItemById(cartItem.getCartItemId());
		listOfCartItemsFromDB = cisc.getAllCartItems();
		int after = listOfCartItemsFromDB.size();
		System.out.println("here is before " + before);
		System.out.println("here is after " + after);

		assertEquals(before, after);
	}

}
