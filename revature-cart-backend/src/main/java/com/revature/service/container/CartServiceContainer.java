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
	public Cart createCart(Cart cart) {
		return cdao.save(cart);
	}
	
	@Override
	public List<Cart> getAllCarts() {
		return cdao.findAll();
	}

	@Override
	public Cart getCartById(int id) {
		return cdao.findById(id).get();
	}

	@Override
	public Cart updateCartById(int id) {
		Cart cart = cdao.findById(id).get();
		return cdao.save(cart);
	}
	
	@Override
	public Cart updateCart(Cart cart) {
		return cdao.save(cart);
	}

	@Override
	public void deleteCartById(int id) {
		cdao.deleteById(id);
	}
	
	@Override
	public void deleteCart(Cart cart) {
		cdao.delete(cart);
	}
}
