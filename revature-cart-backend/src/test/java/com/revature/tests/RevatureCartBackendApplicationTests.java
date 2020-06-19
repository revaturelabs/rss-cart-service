package com.revature.tests;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.revature.cart.model.Cart;
import com.revature.service.container.CartServiceContainer;

@SpringBootTest
class RevatureCartBackendApplicationTests {
	
	private CartServiceContainer csc;
	
	@Autowired
	public RevatureCartBackendApplicationTests(CartServiceContainer csc) {
		this.csc = csc;
	}
	
	/**
	 * @BeforeEach
    public void setUp() throws Exception {
        // clear user table
        List<User> uList = userService.getAllUsers();
        for(User u : uList) {
            userService.deleteByID(u.getId());
        }
    }
	 */
	
	@BeforeEach
	void setUp() throws Exception {
		// clear cart list
		List<Cart> cartList = csc.getAllCarts();
//		for (Cart cart : cartList) {
//			csc.deleteCartById(cart.getCartID());
//		}
	}
	
//	@AfterEach
//	void tearDown() throws Exception {
//		
//	}
	
	
	/**
	 * we can use contextLoads for checking if anything is null
	 * before we run a test
	 */
	@Test
	void contextLoads() {
	}
	
	@Test
	void createCartTest() {
		
	}
	
	

}
