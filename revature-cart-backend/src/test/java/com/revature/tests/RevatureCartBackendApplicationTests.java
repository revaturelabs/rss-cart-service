package com.revature.tests;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import com.revature.cart.dao.CartDao;
import com.revature.cart.model.Cart;
import com.revature.cart.model.CartItem;
import com.revature.service.container.CartServiceContainer;

@WebAppConfiguration
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
		if (this.cart==null) {
			this.cart = new Cart();
			this.cart.setCartID(0);
			this.cart.setCartItems(new ArrayList<CartItem>());
			this.cart.setUserId(0);
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
