package com.revature.cart.controller;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.cart.model.Cart;
import com.revature.cart.service.container.CartServiceContainer;

@RunWith(SpringRunner.class)
@WebMvcTest(CartController.class)
class CartControllerTest2 {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private CartServiceContainer cartService;
	
	private ObjectMapper mapper = new ObjectMapper();

	@Test
	void testCartController() {
		fail("Not yet implemented");
	}

	@Test
	void testCreateCart() {
		fail("Not yet implemented");
	}

	@Test
	void testGetCartsByUserId() {
		fail("Not yet implemented");
	}

	@Test
	void testGetCartById() throws Exception {
		//fail("Not yet implemented");
		// https://youtu.be/fN8VAdYfJB8?t=712
		
		Cart cart = new Cart();
		
		String outputJson = mapper.writeValueAsString(cart);
		
		Mockito.when(cartService.getCartById(1)).thenReturn(cart);
		
//		this.mockMvc.perform(get{"/cart/1"})
//		.andDo(print())
//		.andExpect(status().isOk())
//		.andExpect(content().json(outputJson));
	}

	@Test
	void testUpdateCart() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteCartById() {
		fail("Not yet implemented");
	}

}
