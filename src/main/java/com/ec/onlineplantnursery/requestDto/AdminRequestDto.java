package com.ec.onlineplantnursery.requestDto;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

public class AdminRequestDto {
	
	private int userId;
	@ApiModelProperty(name = "user name", required = true)
	@Column
	@NotEmpty(message = "cannot be left empty")
	private String adminName;
	@ApiModelProperty(name = "Email", value = "Email cannot be empty")
	@Column
	@NotEmpty(message = "Email cannot be left blank or null")
	@Email(message = "Enter valid email Id")
	private String email;
	@ApiModelProperty(name = "Mobile", value = "Mobile number cannot be null, holds max and min 10 digits")
	@Column
	@NotEmpty(message = "Mobile number cannot be left blank or null")
	@Pattern(regexp = "(^$|[0-9]{10})", message = "Enter 10 digit mobile number")
	private String mobile;
	@ApiModelProperty(name = "user password", required = true)
	@Column
	@NotEmpty(message = "cannot be left empty")
	@Size(min = 8, max = 25)
	private String password;
	
	public AdminRequestDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public AdminRequestDto(int userId, @NotEmpty(message = "cannot be left empty") String adminName,
			@NotEmpty(message = "Email cannot be left blank or null") @Email(message = "Enter valid email Id") String email,
			@NotEmpty(message = "Mobile number cannot be left blank or null") @Pattern(regexp = "(^$|[0-9]{10})", message = "Enter 10 digit mobile number") String mobile,
			@NotEmpty(message = "cannot be left empty") @Size(min = 8, max = 25) String password) {
		super();
		this.userId = userId;
		this.adminName = adminName;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
	}



	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "AdminRequestDto [userId=" + userId + ", adminName=" + adminName + ", email=" + email + ", mobile="
				+ mobile + ", password=" + password + "]";
	}
	
	

}
