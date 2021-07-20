package com.ec.onlineplantnursery.entity;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TransactionsInfo")
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int transactionId;
	
	private String transactionMode;
	
	private String paymentStatus;
	
	@OneToOne
	@JoinColumn(name = "OrderInfo", referencedColumnName = "bookingOrderId")
	private Order order;
	
	@OneToOne
	@JoinColumn(name = "PaymentInfo", referencedColumnName = "paymentId")
	private Payment payment;

	public Transaction() {
		super();
		
	}

	public Transaction(int transactionId, String transactionMode, String paymentStatus, Order order, Payment payment) {
		super();
		this.transactionId = transactionId;
		this.transactionMode = transactionMode;
		this.paymentStatus = paymentStatus;
		this.order = order;
		this.payment = payment;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public String getTransactionMode() {
		return transactionMode;
	}

	public void setTransactionMode(String transactionMode) {
		this.transactionMode = transactionMode;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result + ((payment == null) ? 0 : payment.hashCode());
		result = prime * result + ((paymentStatus == null) ? 0 : paymentStatus.hashCode());
		result = prime * result + transactionId;
		result = prime * result + ((transactionMode == null) ? 0 : transactionMode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		if (payment == null) {
			if (other.payment != null)
				return false;
		} else if (!payment.equals(other.payment))
			return false;
		if (paymentStatus == null) {
			if (other.paymentStatus != null)
				return false;
		} else if (!paymentStatus.equals(other.paymentStatus))
			return false;
		if (transactionId != other.transactionId)
			return false;
		if (transactionMode == null) {
			if (other.transactionMode != null)
				return false;
		} else if (!transactionMode.equals(other.transactionMode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", transactionMode=" + transactionMode
				+ ", paymentStatus=" + paymentStatus + ", order=" + order + ", payment=" + payment + "]";
	}

	
	
}
