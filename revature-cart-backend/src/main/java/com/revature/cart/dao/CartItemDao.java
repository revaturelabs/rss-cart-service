package com.revature.cart.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.cart.model.CartItem;

@Repository
public interface CartItemDao extends JpaRepository<CartItem, Integer> {
	public List<CartItem> findByCartCartId(int cartId);
}
