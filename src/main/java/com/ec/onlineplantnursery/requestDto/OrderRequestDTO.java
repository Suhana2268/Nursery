package com.ec.onlineplantnursery.requestDto;

import java.time.LocalDate;

import java.util.List;
import java.util.Map;

import javax.persistence.ElementCollection;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

import com.ec.onlineplantnursery.entity.Customer;
import com.ec.onlineplantnursery.entity.Planter;
import com.ec.onlineplantnursery.entity.Product;

import lombok.Data;

@Data
public class OrderRequestDTO {

	private Integer bookingOrderId;

	@FutureOrPresent(message = "Date cannot be in Past")
	private LocalDate orderDate;

	@NotEmpty(message = "transactionMode cannot be left blank or null")
	private String transactionMode;

	private List<Product> products;
	
	

	private double totalCost;

	private Customer customer;

	private Map<Integer, Integer> productQuantityMap;

	public OrderRequestDTO() {
		super();

	}

	public Integer getBookingOrderId() {
		return bookingOrderId;
	}

	public void setBookingOrderId(Integer bookingOrderId) {
		this.bookingOrderId = bookingOrderId;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public String getTransactionMode() {
		return transactionMode;
	}

	public void setTransactionMode(String transactionMode) {
		this.transactionMode = transactionMode;
	}

	

	

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Map<Integer, Integer> getProductQuantityMap() {
		return productQuantityMap;
	}

	public void setProductQuantityMap(Map<Integer, Integer> productQuantityMap) {
		this.productQuantityMap = productQuantityMap;
	}

		

	

	
	
}
