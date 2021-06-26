package com.ec.onlineplantnursery.responseDto;

import java.util.List;
import java.util.Map;

import javax.persistence.ElementCollection;

import com.ec.onlineplantnursery.entity.Address;
public class OrderResponseDto {

	private Integer bookingOrderId;
	
	private double totalCost;
	private String customerName;
	private Address address;
	private Map<Integer, Integer> productIds;

	public OrderResponseDto() {
		super();

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

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Map<Integer, Integer> getProductIds() {
		return productIds;
	}

	public void setProductIds(Map<Integer, Integer> productIds) {
		this.productIds = productIds;
	}
}
