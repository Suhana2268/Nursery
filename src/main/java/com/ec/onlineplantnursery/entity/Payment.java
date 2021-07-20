package com.ec.onlineplantnursery.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int paymentId;
	
	private String bankName;
	
	private String cardNumber;
	
	private int cvv;
	
	private Date expireDate;
	
	
	private double totalCost;
	
	private int orderId;

	public Payment() {
		super();
		
	}

	public Payment(int paymentId, String bankName, String cardNumber, int cvv, Date expireDate, double totalCost,
			int orderId) {
		super();
		this.paymentId = paymentId;
		this.bankName = bankName;
		this.cardNumber = cardNumber;
		this.cvv = cvv;
		this.expireDate = expireDate;
		this.totalCost = totalCost;
		this.orderId = orderId;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bankName == null) ? 0 : bankName.hashCode());
		result = prime * result + ((cardNumber == null) ? 0 : cardNumber.hashCode());
		result = prime * result + cvv;
		result = prime * result + ((expireDate == null) ? 0 : expireDate.hashCode());
		result = prime * result + orderId;
		result = prime * result + paymentId;
		long temp;
		temp = Double.doubleToLongBits(totalCost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Payment other = (Payment) obj;
		if (bankName == null) {
			if (other.bankName != null)
				return false;
		} else if (!bankName.equals(other.bankName))
			return false;
		if (cardNumber == null) {
			if (other.cardNumber != null)
				return false;
		} else if (!cardNumber.equals(other.cardNumber))
			return false;
		if (cvv != other.cvv)
			return false;
		if (expireDate == null) {
			if (other.expireDate != null)
				return false;
		} else if (!expireDate.equals(other.expireDate))
			return false;
		if (orderId != other.orderId)
			return false;
		if (paymentId != other.paymentId)
			return false;
		if (Double.doubleToLongBits(totalCost) != Double.doubleToLongBits(other.totalCost))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", bankName=" + bankName + ", cardNumber=" + cardNumber + ", cvv="
				+ cvv + ", expireDate=" + expireDate + ", totalCost=" + totalCost + ", orderId=" + orderId + "]";
	}

	

}
