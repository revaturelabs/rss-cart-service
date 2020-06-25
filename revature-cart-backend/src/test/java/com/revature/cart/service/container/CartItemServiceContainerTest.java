package com.revature.cart.service.container;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.revature.cart.model.Cart;
import com.revature.cart.model.CartItem;

@SpringBootTest
class CartItemServiceContainerTest {
	
	@Autowired
	CartItemServiceContainer cisc;
	
	@BeforeEach
	public void setUp() throws Exception {
		// clear the table before we start each test
		List<CartItem> cartItemList = cisc.getAllCartItems();
		
		for(CartItem c : cartItemList) {
			cisc.deleteCartItemById(c.getCartItemId());
		}
	}
	
	
	/**
	 * 	THIS IS A CART ITEM    use @JsonBackReference
	 * 	private int cartItemId;
		private Cart cart;
		private int productId;
		private int quantity;
		
		THIS IS CART  use @JsonManageReference
		private int cartId;
		private int userId;
		private String name;
		private List<CartItem> cartItems;
	 */

	@Test
	void test_createCartItem() {
		
		CartItem cartItem = new CartItem();
		//CartItem cartItem1 = new CartItem();
		List<CartItem> ci_L = new ArrayList<>();
		
		Cart cart = new Cart();
		cart.setCartID(1);
		cart.setUserId(1);
		//cart.setName("need a name ?");
		cart.setCartItems(ci_L);
		
		
		cartItem.setCartItemId(1);
		cartItem.setCart(cart);
		cartItem.setProductId(1);
		cartItem.setQuantity(1);
		
		cisc.createCartItem(cartItem);
		List<CartItem> ciFromDB = cisc.getAllCartItems();
		assertEquals(1, ciFromDB.size());
	}
	
	
	@Test
	void test_deleteCartItem() {
		
		CartItem cartItem = new CartItem();
		//CartItem cartItem1 = new CartItem();
		List<CartItem> ci_L = new ArrayList<>();
		
		Cart cart = new Cart();
		cart.setCartID(1);
		cart.setUserId(1);
		//cart.setName("need a name ?");
		cart.setCartItems(ci_L);
		
		
		cartItem.setCartItemId(1);
		cartItem.setCart(cart);
		cartItem.setProductId(1);
		cartItem.setQuantity(1);
		
		cisc.createCartItem(cartItem);
		List<CartItem> ciFromDB = cisc.getAllCartItems();
		cisc.deleteCartItemById(cartItem.getCartItemId());
		assertThat(cartItem).isNull();
	}

}

















