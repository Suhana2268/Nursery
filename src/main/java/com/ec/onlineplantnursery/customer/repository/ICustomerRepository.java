package com.ec.onlineplantnursery.customer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ec.onlineplantnursery.customer.entity.Customer;

public interface ICustomerRepository extends JpaRepository<Customer, Integer>{
	@Query("select c from Customer c where c.email =:email")
	List<Customer> findByUserName(@Param("email") String email);
	
}
