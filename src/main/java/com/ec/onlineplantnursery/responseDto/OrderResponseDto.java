package com.ec.onlineplantnursery.responseDto;

import java.util.List;

import javax.persistence.ElementCollection;

import com.ec.onlineplantnursery.entity.Address;
import com.ec.onlineplantnursery.entity.Planter;
import com.ec.onlineplantnursery.entity.Product;

public class OrderResponseDto {

	private Integer bookingOrderId;
	@ElementCollection
	private List<Integer> quantity;
	private double totalCost;
	private String customerName;
	private Address address;
	private List<Product> productIds;

	public OrderResponseDto() {
		super();

	}

	public Integer getBookingOrderId() {
		return bookingOrderId;
	}

	public void setBookingOrderId(Integer bookingOrderId) {
		this.bookingOrderId = bookingOrderId;
	}

	

	public List<Integer> getQuantity() {
		return quantity;
	}

	public void setQuantity(List<Integer> quantity) {
		this.quantity = quantity;
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

	public List<Product> getProductIds() {
		return productIds;
	}

	public void setProductIds(List<Product> productIds) {
		this.productIds = productIds;
	}

	

}
