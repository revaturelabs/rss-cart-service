package com.revature.cart.service.container;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.cart.dao.CartDao;
import com.revature.cart.model.Cart;
import com.revature.cart.service.CartService;

@Service
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
	public List<Cart> getCartsByUserId(int id) {
		return cdao.findByUserId(id);
	}

	@Override
	public Cart getCartById(int id) {
		return cdao.findById(id).get();
	}
	
	@Override
	public Cart updateCart(Cart cart) {
		return cdao.save(cart);
	}

	@Override
	public void deleteCartById(int id) {
		cdao.deleteById(id);
	}
}
