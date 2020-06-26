package com.revature.cart.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.revature.cart.model.Cart;
import com.revature.cart.model.CartItem;
import com.revature.cart.service.container.CartItemServiceContainer;

@ExtendWith(SpringExtension.class)
@AutoConfigureJsonTesters
@WebMvcTest(CartItemController.class)
public class CartItemControllerUnitTest {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private CartItemServiceContainer cis;
	
	@Autowired
	private JacksonTester<CartItem> jsonCartItem;
	
	@Test
	public void test_canCreateCartItem() throws Exception {
		// when
		MockHttpServletResponse response = mvc.perform(
			post("/cartitem").contentType(MediaType.APPLICATION_JSON).content(
					jsonCartItem.write(new CartItem(1, new Cart(), 1, 1)).getJson()
			)).andReturn().getResponse();
			
		// then
		assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
	}
}
