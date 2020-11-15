package com.revature.cart.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.cart.model.Cart;
import com.revature.cart.model.CartItem;
import com.revature.cart.service.container.CartItemServiceContainer;
import org.springframework.boot.test.context.SpringBootTest;

//@RunWith(SpringJUnit4ClassRunner.class)
// @WebMvcTest(CartItemController.class)
@SpringBootTest
public class CartItemControllerUnitTest {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private CartItemServiceContainer cis;
	
	private Cart mockCart;
	private CartItem mockCI;
	private String ciJson;
	private ObjectMapper om;
	
	@BeforeEach
	void setUp() throws JsonProcessingException {
		om = new ObjectMapper();
		mockCart = new Cart();
		mockCI = new CartItem(1, mockCart, 1, 1);
		mockCart.setCartItems(new ArrayList<CartItem>(Arrays.asList(mockCI)));
		mockCart.setCartId(1);
		mockCart.setName("mock");
		mockCart.setUserId(1);
		mockCI.setCart(mockCart);
		ciJson = "{\"cartItemId\":1,\"cart\":{\"cartId\":1,\"userId\":1,\"cartItems\":[]},\"productId\":1,\"quantity\":1}";
	}
 	
	@Test
	public void test_canCreateCartItem() throws Exception {
		Mockito.when(cis.createCartItem(Mockito.any(CartItem.class))).thenReturn(mockCI);
		Mockito.when(cis.getCartItemsByCartIdAndProductId(Mockito.anyInt(), Mockito.anyInt())).thenReturn(null);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/cartitem")
				.accept(MediaType.APPLICATION_JSON).content(ciJson)
				.contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		String expected = "{cartItemId:1,productId:1,quantity:1}";
		verify(cis).createCartItem(Mockito.any(CartItem.class));
		assertEquals(response.getStatus(), 200);
		JSONAssert.assertEquals(expected, response.getContentAsString(), false);
	}
	
	@Test
	public void test_createCartItem_willUpdateCartItemWhenCartItemIsNotNull() throws Exception {
		Mockito.when(cis.updateCartItem(Mockito.any(CartItem.class))).thenReturn(mockCI);
		Mockito.when(cis.getCartItemsByCartIdAndProductId(Mockito.anyInt(), Mockito.anyInt())).thenReturn(mockCI);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/cartitem")
				.accept(MediaType.APPLICATION_JSON).content(ciJson)
				.contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		String expected = "{cartItemId:1,productId:1,quantity:2}";
		
		verify(cis).updateCartItem(Mockito.any(CartItem.class));
		assertEquals(response.getStatus(), 200);
		JSONAssert.assertEquals(expected, response.getContentAsString(), false);
	}
	
	@Test
	public void test_getCartItemById_returnsCartItem() throws Exception {
		Mockito.when(cis.getCartItemById(Mockito.anyInt())).thenReturn(mockCI);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/cartitem/1")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		String expected = "{cartItemId:1,productId:1,quantity:1}";
		
		verify(cis).getCartItemById(Mockito.anyInt());
		assertEquals(response.getStatus(), 200);
		JSONAssert.assertEquals(expected, response.getContentAsString(), false);
	}
	
	@Test
	public void test_GetAllCartItems_ReturnsAllCartItemsByCartId() throws Exception {
		Mockito.when(cis.getCartItemsByCartId(Mockito.anyInt())).thenReturn(new ArrayList<CartItem>(Arrays.asList(mockCI)));
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/cartitems/1")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		String expected = "[{cartItemId:1,productId:1,quantity:1}]";
		
		verify(cis).getCartItemsByCartId(Mockito.anyInt());
		assertEquals(response.getStatus(), 200);
		JSONAssert.assertEquals(expected, response.getContentAsString(), false);
	}
	
	@Test
	public void test_UpdateCartItem_UpdatesCartItemPassedToIt() throws Exception {
		Mockito.when(cis.updateCartItem(Mockito.any(CartItem.class))).thenReturn(mockCI);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.put("/cartitem")
				.accept(MediaType.APPLICATION_JSON).content(ciJson)
				.contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		String expected = "{cartItemId:1,productId:1,quantity:1}";
		
		verify(cis).updateCartItem(Mockito.any(CartItem.class));
		assertEquals(response.getStatus(), 200);
		JSONAssert.assertEquals(expected, response.getContentAsString(), false);
	}
	
	@Test
	public void test_DeleteCartItemById() throws Exception {
		doNothing().when(cis).deleteCartItemById(Mockito.anyInt());
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/cartitem/1");
		
		MvcResult result = mvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		
		verify(cis).deleteCartItemById(Mockito.anyInt());
		assertEquals(response.getStatus(), 200);
		assertEquals(response.getContentAsString(), "");
	}
}
