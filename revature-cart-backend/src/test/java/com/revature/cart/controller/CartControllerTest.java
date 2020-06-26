package com.revature.cart.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.cart.model.Cart;
import com.revature.cart.model.CartItem;
import com.revature.cart.service.container.CartServiceContainer;

@RunWith(SpringRunner.class)
@WebMvcTest(CartController.class)
class CartControllerTest {

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
	void testCreateCart() throws Exception {

		// CREATE BODY REQUEST
		Cart cart = new Cart();
		// cart.setCartId(1);
		cart.setUserId(1);
		cart.setName("my Test Cart");
		List<CartItem> cartItemListEmpty = new ArrayList<>();
		cart.setCartItems(cartItemListEmpty);

		String inputJson = mapper.writeValueAsString(cart);

		// CREATE RESPONSE
		Cart cart2 = new Cart();
		cart2.setCartId(1234);
		cart2.setUserId(1);
		cart2.setName("my Test Cart");
		List<CartItem> cartItemListEmpty2 = new ArrayList<>();
		cart2.setCartItems(cartItemListEmpty2);

		String outputJson = mapper.writeValueAsString(cart2);

		Mockito.when(cartService.createCart(cart)).thenReturn(cart2);

		this.mockMvc.perform(post("/cart")
		.contentType(MediaType.APPLICATION_JSON)
		.content(inputJson)).andDo(print())
		.andExpect(content()
		.contentType(MediaType.APPLICATION_JSON))
		.andExpect(content().json(outputJson));

	}

	@Test
	void testGetCartsByUserId() {
		fail("Not yet implemented");
	}

	@Test
	void testGetCartById() throws Exception {

		Cart cart = new Cart();
		cart.setCartId(1);
		cart.setUserId(1);
		cart.setName("my Test Cart");
		List<CartItem> cartItemListEmpty = new ArrayList<>();
		cart.setCartItems(cartItemListEmpty);

		String outputJson = mapper.writeValueAsString(cart);

		Mockito.when(cartService.getCartById(cart.getCartId())).thenReturn(cart);

		this.mockMvc.perform(get("/cart/1")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().json(outputJson));
	}

	@Test
	void testUpdateCart() throws Exception {

		// UPDATE
		Cart cart2 = new Cart();
		cart2.setCartId(1234);
		cart2.setUserId(1);
		cart2.setName("my Test Cart");
		List<CartItem> cartItemListEmpty2 = new ArrayList<>();
		cart2.setCartItems(cartItemListEmpty2);

		String json = mapper.writeValueAsString(cart2);

		Mockito.when(cartService.updateCart(cart2)).thenReturn(cart2);

		this.mockMvc.perform(put("/cart")
		.contentType(MediaType.APPLICATION_JSON)
		.content(json)).andDo(print())
		.andExpect(content()
		.contentType(MediaType.APPLICATION_JSON))
		.andExpect(content().json(json));

	}

	@Test
	void testDeleteCartById() {
		fail("Not yet implemented");
	}

}
