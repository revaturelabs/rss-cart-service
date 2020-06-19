package com.revature.cart.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.cart.model.Cart;

@Repository
public interface CartDao extends JpaRepository<Cart, Integer> {
	
}
