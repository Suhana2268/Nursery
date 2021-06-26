package com.ec.onlineplantnursery.entity;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Positive;


import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "orders")
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

	
	/*@ApiModelProperty(name = "Quantity", value = "Holds positive value")
	@ElementCollection
	private List<Integer> quantity;*/
	
	@ApiModelProperty(name = "TotalCost", value = "Holds positive value")
	private double totalCost;
	
	private int orderStatus;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Customer_Info", referencedColumnName = "userId")
	//@JoinTable(name = "Customer_Order_info", joinColumns = @JoinColumn(name = "bookingOrderId"), inverseJoinColumns = @JoinColumn(name = "customerId"))
	private Customer customer;

	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinColumn(name="Order_Product_Info", referencedColumnName="pId")
	private List<Product> products;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "Transaction_status", referencedColumnName = "transactionId")
	private Transaction transaction;
	
	@ElementCollection
	@CollectionTable(name = "order_product",
	joinColumns =  {@JoinColumn(name = "orderId", referencedColumnName = "bookingOrderId")})
	@MapKeyColumn(name = "pId")
	@Column(name = "quantity")
	
	private Map<Integer, Integer> productQuantityMap;
	
	
	
	
	
	
	
	
	
	public Order() {
		super();

	}









	public Order(Integer bookingOrderId, @FutureOrPresent(message = "Order date cannot be past") LocalDate orderDate,
			double totalCost, int orderStatus, Customer customer, List<Product> products, Transaction transaction,
			Map<Integer, Integer> productQuantityMap) {
		super();
		this.bookingOrderId = bookingOrderId;
		this.orderDate = orderDate;
		this.totalCost = totalCost;
		this.orderStatus = orderStatus;
		this.customer = customer;
		this.products = products;
		this.transaction = transaction;
		this.productQuantityMap = productQuantityMap;
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









	public List<Product> getProducts() {
		return products;
	}









	public void setProducts(List<Product> products) {
		this.products = products;
	}









	public Transaction getTransaction() {
		return transaction;
	}









	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}









	public Map<Integer, Integer> getProductQuantityMap() {
		return productQuantityMap;
	}









	public void setProductQuantityMap(Map<Integer, Integer> productQuantityMap) {
		this.productQuantityMap = productQuantityMap;
	}









	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookingOrderId == null) ? 0 : bookingOrderId.hashCode());
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((orderDate == null) ? 0 : orderDate.hashCode());
		result = prime * result + orderStatus;
		result = prime * result + ((productQuantityMap == null) ? 0 : productQuantityMap.hashCode());
		result = prime * result + ((products == null) ? 0 : products.hashCode());
		long temp;
		temp = Double.doubleToLongBits(totalCost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((transaction == null) ? 0 : transaction.hashCode());
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
		if (productQuantityMap == null) {
			if (other.productQuantityMap != null)
				return false;
		} else if (!productQuantityMap.equals(other.productQuantityMap))
			return false;
		if (products == null) {
			if (other.products != null)
				return false;
		} else if (!products.equals(other.products))
			return false;
		if (Double.doubleToLongBits(totalCost) != Double.doubleToLongBits(other.totalCost))
			return false;
		if (transaction == null) {
			if (other.transaction != null)
				return false;
		} else if (!transaction.equals(other.transaction))
			return false;
		return true;
	}









	@Override
	public String toString() {
		return "Order [bookingOrderId=" + bookingOrderId + ", orderDate=" + orderDate + ", totalCost=" + totalCost
				+ ", orderStatus=" + orderStatus + ", customer=" + customer + ", products=" + products
				+ ", transaction=" + transaction + ", productQuantityMap=" + productQuantityMap + "]";
	}


}
