package com.revature.cart.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.cart.model.Customer;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer>{

}
