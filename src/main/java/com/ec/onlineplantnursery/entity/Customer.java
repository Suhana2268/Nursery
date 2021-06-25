package com.ec.onlineplantnursery.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.TableGenerator;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(value = "Customer Bean")
@TableGenerator(name = "customer_generator", initialValue = 0, allocationSize = 50)
@DiscriminatorValue(value = "1")
public class Customer extends User{
	
	/**@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "customer_generator")
	private Integer customerId;**/
    
	@Column
	@ApiModelProperty(name = "CustomerName", value = "Hold the min 3 char Customer name", required = true)
	@NotEmpty(message = "Customer Name cannot be left blank or null")
	@Size(min = 3, max = 50, message = "Invalid Customer Name,Customer Name should have minimum 3 and maximum 50 characters")
	private String customerName;
	
	//remove email and username
	@Column
	@ApiModelProperty(name = "CustomerEmail", value = "holds valid email id", required = true)
	@NotEmpty(message = "Customer Email cannot be left blank or null")
	@Email
	private String customerEmail;
    
	@Column
	@ApiModelProperty(name = "CustomerUserName", value = "Hold the min 3 char Customer username", required = true)
	@NotEmpty(message = "Customer UserName cannot be left blank or null")
	@Size(min = 3, max = 50, message = "Invalid Customer UserName,Customer UserName should have minimum 3 and maximum 50 characters")
	private String username;
	
	/**@Column
	@ApiModelProperty(name = "Customer Password", value = "Hold the min 8 char Customer Password", required = true)
	@Size(min = 8, max = 15, message = "Invalid Customer Password ,Customer password should have minimum 8 and maximum 15 characters")
	@NotEmpty(message = "Please enter the password, password cannot be null")
	private String password;**/
	
	@Embedded
	@Valid
	private Address address;

	
	public Customer() {
		super();
	}

	public Customer(
			@NotEmpty(message = "Customer Name cannot be left blank or null")String customerName,
			@Email String customerEmail,
			@NotEmpty(message = "Customer username cannot be left blank or null") String username, 
			Address address) {
		super();
		
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.username = username;
		this.address = address;
	}

	
	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}
	/**
	 * @param customerName the customerName to set
	 */
    public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
    /**
	 * @return the customerEmail
	 */
	public String getCustomerEmail() {
		return customerEmail;
	}
	/**
	 * @param customerEmail the customerEmail to set
	 */
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	/**
	 * @return the username
	 */
    public String getUsername() {
		return username;
	}
    /**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	/**
	 * @return the Address
	 */
	public Address getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	

	
	public Customer(int userId, String userType, String password) {
		super(userId, userType, password);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		
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
		Customer other = (Customer) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (customerEmail == null) {
			if (other.customerEmail != null)
				return false;
		} else if (!customerEmail.equals(other.customerEmail))
			return false;
		
		if (customerName == null) {
			if (other.customerName != null)
				return false;
		} else if (!customerName.equals(other.customerName))
			return false;
		
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Customer [customerName=" + customerName + ", customerEmail=" + customerEmail + ", username=" + username
				+ ", address=" + address + "]";
	}

	

}
	