package com.revature.cart.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.cart.model.Cart;
import com.revature.cart.model.CartItem;
import com.revature.cart.service.container.CartItemServiceContainer;

@RunWith(SpringRunner.class)
@WebMvcTest(CartItemController.class)
public class CartItemControllerUnitTest {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private CartItemServiceContainer cis;
	
	CartItem mockCI = new CartItem(1, new Cart(), 1, 1);
	ObjectMapper om = new ObjectMapper();
	
	@Test
	public void test_canCreateCartItem() throws Exception {

		String ciJson = om.writeValueAsString(mockCI);
		
		Mockito.when(cis.createCartItem(Mockito.any(CartItem.class))).thenReturn(mockCI);
		Mockito.when(cis.updateCartItem(Mockito.any(CartItem.class))).thenReturn(mockCI);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/cartitem")
				.accept(MediaType.APPLICATION_JSON).content(ciJson)
				.contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.CREATED.value(), response.getStatus());
		assertEquals("http://localhost:9999/cartitem", response.getHeader(HttpHeaders.LOCATION));
	}
}
