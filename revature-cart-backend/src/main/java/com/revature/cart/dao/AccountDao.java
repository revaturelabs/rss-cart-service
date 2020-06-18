package com.revature.cart.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.cart.model.Account;

@Repository
public interface AccountDao extends JpaRepository<Account, Integer> {

}
