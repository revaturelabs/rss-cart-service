package com.revature.service.container;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.cart.dao.CartDao;
import com.revature.cart.model.Cart;
import com.revature.service.CartService;

public class CartServiceContainer implements CartService {
	
	private CartDao cdao;
	
	@Autowired
	public CartServiceContainer(CartDao cdao) {
		super();
		this.cdao = cdao;
	}

	@Override
	public List<Cart> getAllCarts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cart getCartById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cart createCart(Cart cart) {
		// TODO Auto-generated method stub
		return cdao.save(cart);
	}

	@Override
	public void deleteCartById(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateCartById(int id) {
		// TODO Auto-generated method stub

	}

}
