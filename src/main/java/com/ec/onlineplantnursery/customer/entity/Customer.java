package com.ec.onlineplantnursery.customer.entity;



import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.validation.Valid;
import com.ec.onlineplantnursery.user.entity.User;


@Entity
@DiscriminatorValue(value = "1")
public class Customer extends User{
	
	@Embedded
	
	private Address address;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(int id, String password, String email, String name, String username) {
		super(id, password, email, name, username);
		// TODO Auto-generated constructor stub
	}

	public Customer(@Valid Address address) {
		super();
		this.address = address;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}