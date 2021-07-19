package com.ec.onlineplantnursery.responseDto;

import com.ec.onlineplantnursery.entity.Address;

public class CustomerResponseDto {

	private Integer userId;
	private String customerName;
	private String customerEmail;
	private String username;
	private String password;
	private String userType;
	private Address address;

	public Integer getUserId() {
		return userId;
	}

	public void setCustomerId(Integer userId) {
		this.userId = userId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	@Override
	public String toString() {
		return "CustomerResponseDto [userId=" + userId + ", customerName=" + customerName + ", customerEmail="
				+ customerEmail + ", username=" + username + ", password=" + password + ", userType=" + userType
				+ ", address=" + address + "]";
	}

	

	
	
	

}
