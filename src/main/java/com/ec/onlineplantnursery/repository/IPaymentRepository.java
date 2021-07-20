package com.ec.onlineplantnursery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ec.onlineplantnursery.entity.Payment;



public interface IPaymentRepository extends JpaRepository<Payment, Integer>{
	

}
