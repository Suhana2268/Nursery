package com.ec.onlineplantnursery.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ec.onlineplantnursery.entity.Order;
import com.ec.onlineplantnursery.entity.Payment;
import com.ec.onlineplantnursery.entity.Transaction;
import com.ec.onlineplantnursery.repository.IOrderRepository;
import com.ec.onlineplantnursery.repository.ITransactionRepository;


@Service
public class TransactionServiceImpl implements ITransactionService{
	
	@Autowired
	ITransactionRepository transactionRepository;
	
	@Autowired
	IOrderRepository orderRepository;

	@Transactional
	@Override
	public Transaction makeTransaction(Transaction t, int userId) {
		
		Optional<Transaction> transaction = transactionRepository.findById(t.getTransactionId());
		if(transaction.isEmpty()) {
			Optional<Payment> payment = Optional.of(transaction.get().getPayment());
			if(payment.isPresent()) {
				transaction.get().setPaymentStatus("done");
			
			transactionRepository.save(t);
			UUID uuid = UUID.randomUUID();
			List<Order> orders = orderRepository.findCartById(userId);
			for(Order o: orders) {
				o.setOrderStatus(1);
				o.setOrderId(Integer.parseInt(uuid.toString()));
				orderRepository.save(o);
			}
			
			
			}
			
			
		}
		
		return t;
	}

	

}
