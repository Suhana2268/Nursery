package com.ec.onlineplantnursery.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import io.swagger.annotations.ApiModelProperty;

@Entity
@DiscriminatorValue(value = "2")
public class Admin extends User{
	
	@ApiModelProperty(name = "user name", required = true)
	@Column
	@NotEmpty(message = "cannot be left empty")
	private String adminName;
	//role, remove email
	
	@ApiModelProperty(name = "Mobile", value = "Mobile number cannot be null, holds max and min 10 digits")
	@Column
	@NotEmpty(message = "Mobile number cannot be left blank or null")
	@Pattern(regexp = "(^$|[0-9]{10})", message = "Enter 10 digit mobile number")
	private String mobile;
	
	
	public Admin() {
		super();
		
	}


	public Admin(String adminName, String mobile) {
		super();
		this.adminName = adminName;
		this.mobile = mobile;
	}


	public String getAdminName() {
		return adminName;
	}


	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((adminName == null) ? 0 : adminName.hashCode());
		result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Admin other = (Admin) obj;
		if (adminName == null) {
			if (other.adminName != null)
				return false;
		} else if (!adminName.equals(other.adminName))
			return false;
		if (mobile == null) {
			if (other.mobile != null)
				return false;
		} else if (!mobile.equals(other.mobile))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Admin [adminName=" + adminName + ", mobile=" + mobile + "]";
	}
	

	

}