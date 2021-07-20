package com.ec.onlineplantnursery.responseDto;


import java.time.LocalDate;
import java.util.Map;

import com.ec.onlineplantnursery.entity.Address;
public class OrderResponseDto {

	private Integer bookingOrderId;
	
	private LocalDate orderDate;
	
	private double totalCost;
	
	private int orderStatus;
	
	private int  orderId;
	
	private int pId;
	
	private int quantity;
	
	private String email;
	
	/*
	 * private String customerName; private Address address;
	 */

	public OrderResponseDto() {
		super();

	}

	
	
	/**
	 * @return the orderDate
	 */
	public LocalDate getOrderDate() {
		return orderDate;
	}



	/**
	 * @param orderDate the orderDate to set
	 */
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}



	/**
	 * @return the orderStatus
	 */
	public int getOrderStatus() {
		return orderStatus;
	}



	/**
	 * @param orderStatus the orderStatus to set
	 */
	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}



	public Integer getBookingOrderId() {
		return bookingOrderId;
	}

	public void setBookingOrderId(Integer bookingOrderId) {
		this.bookingOrderId = bookingOrderId;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	
	/*
	 * public String getCustomerName() { return customerName; }
	 * 
	 * public void setCustomerName(String customerName) { this.customerName =
	 * customerName; }
	 * 
	 * public Address getAddress() { return address; }
	 * 
	 * public void setAddress(Address address) { this.address = address; }
	 */
	 
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	

	/**
	 * @return the orderId
	 */
	public int getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	/**
	 * @return the pId
	 */
	public int getpId() {
		return pId;
	}

	/**
	 * @param pId the pId to set
	 */
	public void setpId(int pId) {
		this.pId = pId;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
	
	
	
}
