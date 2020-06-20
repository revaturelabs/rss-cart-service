package com.revature.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.revature.cart.dao.CartDao;
import com.revature.cart.model.Cart;
import com.revature.cart.model.CartItem;
import com.revature.service.CartService;

@SpringBootTest(classes = Cart.class)
class RevatureCartBackendApplicationTests {
	
//	@Mock
	@Autowired
	private CartService csc;
//	@Mock
	@Autowired
	private CartDao cdao;
	
	private Cart testCart;
	
	@BeforeEach
	public void setupTests() {
		if (this.testCart==null) {
			this.testCart = new Cart();
			this.testCart.setCartID(0);
			this.testCart.setCartItems(new ArrayList<CartItem>());
			this.testCart.setUserId(0);
		}
	}
	
	/**
	 * we can use contextLoads for checking if anything is null
	 * before we run a test
	 */
	@Test
	void contextLoads() {
	}
	
//	@Test
//	public void createCartTest() {
//		when(cdao.save(testCart)).thenReturn(testCart);
//	}
	
//	@Test
//	public void getCartTest() {
//		when(cdao.findById(0)).thenReturn(Optional.of(new Cart(0, 0, null)));
//		when(cdao.findById(1)).thenReturn(Optional.of(new Cart(0, 0, null)));
//	}
	
	@Test
	public void getCartTest() {
		cdao.save(testCart);
		assertEquals(cdao.findById(0).get(), testCart);
	}
	
	@Test
	public void deleteCartTest() {
		cdao.save(testCart);
		cdao.delete(testCart);
		assertEquals(cdao.findById(0).get(), null);
	}
	
	
	@AfterEach
	public void deleteTestValues() {
		cdao.delete(testCart);
	}
	

}
