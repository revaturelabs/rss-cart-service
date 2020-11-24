package com.revature.cart.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
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
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.cart.model.Cart;
import com.revature.cart.model.CartItem;
import com.revature.cart.service.container.CartServiceContainer;
import org.springframework.boot.test.context.SpringBootTest;

//@RunWith(SpringRunner.class)
//@WebMvcTest(CartController.class)
@SpringBootTest
public class CartControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CartServiceContainer cartService;

	private ObjectMapper mapper = new ObjectMapper();

	@Test
	public void testCreateCart() throws Exception {

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
	public void testGetCartsByUserId() throws Exception {
		
		Cart cart = new Cart();
		cart.setCartId(1);
		cart.setUserId(1);
		cart.setName("my Test Cart");
		List<CartItem> cartItemListEmpty = new ArrayList<>();
		cart.setCartItems(cartItemListEmpty);
		
		List<Cart> cartsFromDB = new ArrayList<>();
		cartsFromDB.add(cart);


		String outputJson = mapper.writeValueAsString(cartsFromDB);

		Mockito.when(cartService.getCartsByUserId(cart.getCartId())).thenReturn(cartsFromDB);

		this.mockMvc.perform(get("/carts/1")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().json(outputJson));
	}

	@Test
	public void testGetCartById() throws Exception {

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
	public void testUpdateCart() throws Exception {

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
	public void testDeleteCartById() throws Exception {
		
		Cart cart = new Cart();
		cart.setCartId(1);
		//cart.setUserId(1);
		//cart.setName("my Test Cart");
		List<CartItem> cartItemListEmpty = new ArrayList<>();
		cart.setCartItems(cartItemListEmpty);

		String outputJson = mapper.writeValueAsString(cart);
		
		doNothing().when(cartService).deleteCartById(Mockito.anyInt());
		
		
        RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/cart/1");

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		
        MockHttpServletResponse response = result.getResponse();
		
		verify(cartService).deleteCartById(Mockito.anyInt());
		assertEquals(response.getStatus(), 200);
		assertEquals(response.getContentAsString(), "");
	}

}
