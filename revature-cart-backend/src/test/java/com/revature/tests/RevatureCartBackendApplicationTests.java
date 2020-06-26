package com.revature.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.revature.cart.dao.CartDao;
import com.revature.cart.model.Cart;
import com.revature.cart.model.CartItem;
import com.revature.cart.service.container.CartServiceContainer;

@SpringBootTest
@ContextConfiguration(classes = {CartDao.class})
class RevatureCartBackendApplicationTests {
	@Mock
	private CartDao cdao;
	@Mock
	private CartServiceContainer csc;
	
	private Cart cart;
	
	@BeforeEach
	public void setupTests() {
		if (this.cart == null) {
			this.cart = new Cart();
			this.cart.setCartId(0);
			this.cart.setCartItems(new ArrayList<CartItem>());
			this.cart.setUserId(0);
			this.cart.setName("Zero");
		}
	}
	
	/**
	 * we can use contextLoads for checking if anything is null
	 * before we run a test
	 */
	@Test
	void contextLoads() {
	}
	
	@Test
	public void pojoTests() {
		Cart c1 = new Cart(1, 1, new ArrayList<CartItem>(), "One");
		Cart c2 = new Cart(2, 2, new ArrayList<CartItem>(), "Two");
		CartItem ci1 = new CartItem(1, c1, 1, 1);
		CartItem ci2 = new CartItem();
		ci2.setCart(c2);
		ci2.setCartItemId(2);
		ci2.setProductId(2);
		ci2.setQuantity(2);
		c1.addCartItem(ci1);
		assertEquals(c1.getCartId(), 1);
		assertEquals(c2.getCartId(), 2);
		assertEquals(c1.getName(), "One");
		assertEquals(c2.getName(), "Two");
		assertEquals(c1.getUserId(), 1);
		assertEquals(c2.getUserId(), 2);
		assertEquals(c1.getCartItems().get(0), ci1);
		assertEquals(c2.getCartItems().get(0), ci2);
		assertEquals(ci1.getCart(), c1);
		assertEquals(ci2.getCart(), c2);
		assertEquals(ci1.getCartItemId(), 1);
		assertEquals(ci2.getCartItemId(), 2);
		assertEquals(ci1.getProductId(), 1);
		assertEquals(ci2.getProductId(), 2);
		assertEquals(ci1.getQuantity(), 1);
		assertEquals(ci2.getQuantity(), 2);
		
		c1.removeCartItem(ci1);
		assertEquals(ci1.getCart(), null);
		assertEquals(c1.getCartItems().size(), 0);
		c1.addCartItem(ci1);
		c1.addCartItem(ci1);
		assertEquals(c1.getCartItems().get(0), ci1);
		
		CartItem ci3 = new CartItem(1, null, 3, 1);
		c1.addCartItem(ci3);
		
		assertEquals(ci1.equals(ci2), false);
		assertEquals(ci1.equals(ci3), false);
		assertEquals(ci1.equals(new Object()), false);
		assertEquals(ci1.equals(null), false);
		assertEquals(ci1.equals(ci1), true);
		assertEquals(ci1.toString(), "CartItem [cartItemId=1, cart=1, productId=1, quantity=1]");
		assertEquals(ci1.hashCode(), 1954);
		
		assertEquals(c1.equals(c2), false);
		assertEquals(c1.equals(new Object()), false);
		assertEquals(c1.equals(null), false);
		assertEquals(c1.equals(c1), true);
		assertEquals(c1.toString(), "Cart [cartId=1, userId=1, name=One, "
				+ "cartItems=[CartItem [cartItemId=1, cart=1, productId=1, "
				+ "quantity=1], CartItem [cartItemId=1, cart=1, productId=3, "
				+ "quantity=1]]]");
		c1.removeCartItem(ci1);
		assertEquals(ci1.equals(ci3), false);
	}
	
	@Test
	public void createCartDaoTest() {
		when(cdao.save(cart)).thenReturn(cart);
		when(csc.createCart(cart)).thenReturn(cart);
	}
	
	@Test
	public void getCartDaoTest() {
		when(cdao.findById(0)).thenReturn(Optional.of(new Cart()));
	}
	
	@Test
	public void getAllCartsDaoTest() {
		assertNotNull(cdao.findAll());
	}
	
	@Test
	public void createCartServiceTest() {
		when(csc.createCart(cart)).thenReturn(cart);
	}
	
	@Test
	public void getCartServiceTest() {
		when(csc.getCartById(0)).thenReturn(cart);
	}
	
	@Test
	public void getAllCartsServiceTest() {
		assertNotNull(csc.getAllCarts());
	}
	
	@Test
	public void createCartControllerTest() {
		
	}
	
	@Test
	public void getCartControllerTest() {
		
	}
	
	@Test
	public void getAllCartsControllerTest() {
		
	}
	

}
