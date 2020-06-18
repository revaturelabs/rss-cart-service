package com.revature.dao.tests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.revature.cart.dao.ProductDao;

@SpringBootTest
public class ProductDaoTests {
	
	private ProductDao pdao;
	
	@Autowired
	public ProductDaoTests(ProductDao pdao) {
		this.pdao = pdao;
	}
	
	@Test
	public void test_ProductCreation() {
		// make product
	}

}
