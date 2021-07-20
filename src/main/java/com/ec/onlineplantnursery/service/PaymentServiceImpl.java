package com.ec.onlineplantnursery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ec.onlineplantnursery.entity.Order;
import com.ec.onlineplantnursery.entity.Payment;
import com.ec.onlineplantnursery.repository.IOrderRepository;
import com.ec.onlineplantnursery.repository.IPaymentRepository;

@Service
public class PaymentServiceImpl implements IPaymentService{
	
	@Autowired
	IPaymentRepository paymentRepository;
	
	@Autowired
	IOrderRepository orderRepository;
	

	@Override
	public Payment makePayment(Payment payment, int userId) {
		
		Order order = orderRepository.findById(userId).get();
		
		payment.setTotalCost(order.getTotalCost());
		
		paymentRepository.save(payment);
		
		
		
		return payment;
	}
	

}
