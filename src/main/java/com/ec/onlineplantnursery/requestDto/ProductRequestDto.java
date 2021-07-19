package com.ec.onlineplantnursery.requestDto;


import lombok.Data;

@Data
public class ProductRequestDto {
	
	private int pId;
	
	private String commonName;
	
	private double cost;

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getCommonName() {
		return commonName;
	}

	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}
	
	
	

}