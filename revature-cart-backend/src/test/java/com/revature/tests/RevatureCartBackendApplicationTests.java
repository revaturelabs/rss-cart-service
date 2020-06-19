package com.revature.tests;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.revature.cart.dao.CartDao;
import com.revature.cart.model.Cart;
import com.revature.service.CartService;

@SpringBootTest(classes = Cart.class)
class RevatureCartBackendApplicationTests {
	
	@Mock
	private CartService csc;
	@Mock
	private CartDao cdao;
	
	private Cart testCart;
	
	@BeforeEach
	public void setupTests() {
		if (this.testCart==null) {
			this.testCart = new Cart(0, 0, null);
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
	public void createCartTest() {
		when(cdao.save(testCart)).thenReturn(testCart);
	}
	
	@Test
	public void getCartTest() {
		when(cdao.findById(0)).thenReturn(Optional.of(new Cart(0, 0, null)));
	}
	

}
