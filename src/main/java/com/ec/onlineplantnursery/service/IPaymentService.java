package com.ec.onlineplantnursery.service;

import com.ec.onlineplantnursery.entity.Payment;

public interface IPaymentService {
	
	public Payment makePayment(Payment payment, int userId);
	

}
