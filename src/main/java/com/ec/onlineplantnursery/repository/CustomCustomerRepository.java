package com.ec.onlineplantnursery.repository;

import java.util.List;

import com.ec.onlineplantnursery.entity.Customer;
import com.ec.onlineplantnursery.entity.Order;
import com.ec.onlineplantnursery.entity.User;

public interface CustomCustomerRepository {

	public List<Customer> findByUserName(String username);
	
}
