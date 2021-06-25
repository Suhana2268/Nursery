package com.ec.onlineplantnursery.entity;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Positive;


import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "orders")
@TableGenerator(name = "order_generator", initialValue = 0, allocationSize = 50)
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "order_generator")
	private Integer bookingOrderId;
	


	@ApiModelProperty(name = "OrderDate", value = "Holds date of order and cannot be past")
	@FutureOrPresent(message ="Order date cannot be past")
	private LocalDate orderDate;

	
	/**@ApiModelProperty(name = "TransactionMode", value = "Cannot be empty")
	@NotEmpty(message = "transactionMode cannot be left blank or null")
	private String transactionMode;**/

	
	@ApiModelProperty(name = "Quantity", value = "Holds positive value")
	@ElementCollection
	private List<Integer> quantity;
	
	@ApiModelProperty(name = "TotalCost", value = "Holds positive value")
	private double totalCost;
	
	private int orderStatus;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "Customer_Info", referencedColumnName = "userId")
	//@JoinTable(name = "Customer_Order_info", joinColumns = @JoinColumn(name = "bookingOrderId"), inverseJoinColumns = @JoinColumn(name = "customerId"))
	private Customer customer;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "Order_Product_Info", referencedColumnName = "pId")
	@MapKey(name = "units")
	private Map<Product, Integer> products;
	
	/**@ManyToMany
	@JoinTable(name = "order_product_info",
	joinColumns = {@JoinColumn(name = "order_id", referencedColumnName = "bookingOrderId")},
	inverseJoinColumns = {@JoinColumn(name = "product_id", referencedColumnName = "pId")})
	@MapKey(name = "units")
	private Map<Integer, Product> productMap;**/
	
	
	
	

	public Order() {
		super();

	}

	public Order(Integer bookingOrderId, @FutureOrPresent(message = "Order date cannot be past") LocalDate orderDate,
			List<Integer> quantity, double totalCost, int orderStatus, Customer customer,
			Map<Product, Integer> products) {
		super();
		this.bookingOrderId = bookingOrderId;
		this.orderDate = orderDate;
		this.quantity = quantity;
		this.totalCost = totalCost;
		this.orderStatus = orderStatus;
		this.customer = customer;
		this.products = products;
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

	public int getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Map<Product, Integer> getProducts() {
		return products;
	}

	public void setProducts(Map<Product, Integer> products) {
		this.products = products;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookingOrderId == null) ? 0 : bookingOrderId.hashCode());
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((orderDate == null) ? 0 : orderDate.hashCode());
		result = prime * result + orderStatus;
		result = prime * result + ((products == null) ? 0 : products.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
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
		Order other = (Order) obj;
		if (bookingOrderId == null) {
			if (other.bookingOrderId != null)
				return false;
		} else if (!bookingOrderId.equals(other.bookingOrderId))
			return false;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (orderDate == null) {
			if (other.orderDate != null)
				return false;
		} else if (!orderDate.equals(other.orderDate))
			return false;
		if (orderStatus != other.orderStatus)
			return false;
		if (products == null) {
			if (other.products != null)
				return false;
		} else if (!products.equals(other.products))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		if (Double.doubleToLongBits(totalCost) != Double.doubleToLongBits(other.totalCost))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order [bookingOrderId=" + bookingOrderId + ", orderDate=" + orderDate + ", quantity=" + quantity
				+ ", totalCost=" + totalCost + ", orderStatus=" + orderStatus + ", customer=" + customer + ", products="
				+ products + "]";
	}



	
	

}
