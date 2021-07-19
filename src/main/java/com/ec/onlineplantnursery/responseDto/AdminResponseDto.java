package com.ec.onlineplantnursery.responseDto;

public class AdminResponseDto {

	private int userId;
	private String adminName;
	private String email;
	private String mobile;
	private String userType;
	private String password;
	public AdminResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdminResponseDto(int userId, String adminName, String email, String mobile, String userType,
			String password) {
		super();
		this.userId = userId;
		this.adminName = adminName;
		this.email = email;
		this.mobile = mobile;
		this.userType = userType;
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
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "AdminResponseDto [userId=" + userId + ", adminName=" + adminName + ", email=" + email + ", mobile="
				+ mobile + ", userType=" + userType + ", password=" + password + "]";
	}
	
	
}
