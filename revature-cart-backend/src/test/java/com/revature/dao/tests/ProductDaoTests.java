package com.revature.dao.tests;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.revature.cart.dao.ProductDao;
import com.revature.cart.model.Product;

@SpringBootTest
public class ProductDaoTests {
	
	private ProductDao pdao;
	private Product testProd;
	
	@Autowired
	public ProductDaoTests(ProductDao pdao) {
		this.pdao = pdao;
		this.testProd = new Product(0, 1, 1);
	}
	
	@Test
	public void test_ProductCreation() {
		Product savedProd = pdao.save(testProd);
		assertEquals(savedProd, testProd);
		assertArrayEquals(
				new int[] {testProd.getProductValue(), testProd.getAmountInStock()},
				new int[] {savedProd.getProductValue(), savedProd.getAmountInStock()}
		);
	}

}
