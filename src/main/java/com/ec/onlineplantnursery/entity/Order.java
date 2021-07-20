package com.ec.onlineplantnursery.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;


import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "order_generator")
	private Integer bookingOrderId;
	

	private int orderId;
	
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

	/*
	 * @ManyToOne(cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name = "Customer_Info", referencedColumnName = "userId")
	 * //@JoinTable(name = "Customer_Order_info", joinColumns = @JoinColumn(name =
	 * "bookingOrderId"), inverseJoinColumns = @JoinColumn(name = "customerId"))
	 * private Customer customer;
	 */
	
	
	private int pId;
	
	private int quantity;
	
	private int userId;
	
	
	
	
	
	/*
	 * @ElementCollection(fetch = FetchType.LAZY)
	 * 
	 * @CollectionTable(name = "order_product", joinColumns = {@JoinColumn(name =
	 * "orderId", referencedColumnName = "bookingOrderId")})
	 * 
	 * @MapKeyColumn(name = "pId")
	 * 
	 * @Column(name = "quantity")
	 */
	
	
	

	
	
	public Order() {
		super();

	}





	public Order(Integer bookingOrderId, int orderId,
			@FutureOrPresent(message = "Order date cannot be past") LocalDate orderDate, double totalCost,
			int orderStatus, int pId, int quantity, int userId) {
		super();
		this.bookingOrderId = bookingOrderId;
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.totalCost = totalCost;
		this.orderStatus = orderStatus;
		this.pId = pId;
		this.quantity = quantity;
		this.userId = userId;
	}





	/**
	 * @return the bookingOrderId
	 */
	public Integer getBookingOrderId() {
		return bookingOrderId;
	}





	/**
	 * @param bookingOrderId the bookingOrderId to set
	 */
	public void setBookingOrderId(Integer bookingOrderId) {
		this.bookingOrderId = bookingOrderId;
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
	 * @return the totalCost
	 */
	public double getTotalCost() {
		return totalCost;
	}





	/**
	 * @param totalCost the totalCost to set
	 */
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
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





	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}





	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}





	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookingOrderId == null) ? 0 : bookingOrderId.hashCode());
		result = prime * result + ((orderDate == null) ? 0 : orderDate.hashCode());
		result = prime * result + orderId;
		result = prime * result + orderStatus;
		result = prime * result + pId;
		result = prime * result + quantity;
		long temp;
		temp = Double.doubleToLongBits(totalCost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + userId;
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
		if (orderDate == null) {
			if (other.orderDate != null)
				return false;
		} else if (!orderDate.equals(other.orderDate))
			return false;
		if (orderId != other.orderId)
			return false;
		if (orderStatus != other.orderStatus)
			return false;
		if (pId != other.pId)
			return false;
		if (quantity != other.quantity)
			return false;
		if (Double.doubleToLongBits(totalCost) != Double.doubleToLongBits(other.totalCost))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}





	@Override
	public String toString() {
		return "Order [bookingOrderId=" + bookingOrderId + ", orderId=" + orderId + ", orderDate=" + orderDate
				+ ", totalCost=" + totalCost + ", orderStatus=" + orderStatus + ", pId=" + pId + ", quantity="
				+ quantity + ", userId=" + userId + "]";
	}





	
	
}
