package com.ec.onlineplantnursery.web;



import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ec.onlineplantnursery.entity.Payment;
import com.ec.onlineplantnursery.entity.Transaction;
import com.ec.onlineplantnursery.service.PaymentServiceImpl;
import com.ec.onlineplantnursery.service.TransactionServiceImpl;

import io.swagger.annotations.Api;

@RestController
@Validated
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/onlinenursery/transaction")


@Api(value = "Online Nursery Application")

public class TransactionRestController {
	
	@Autowired
	TransactionServiceImpl transactionService;
	
	@Autowired
	PaymentServiceImpl paymentService;
	
	
	@PostMapping("/add")
	public Transaction makeTransaction(@RequestBody Transaction t, @PathVariable int userId) {
		return transactionService.makeTransaction(t, userId);
	}

	@PostMapping("/payment/add")
	public Payment makePayment(@RequestBody Payment payment, @PathVariable int userId) {
		return paymentService.makePayment(payment, userId);
	}
	
	
}
