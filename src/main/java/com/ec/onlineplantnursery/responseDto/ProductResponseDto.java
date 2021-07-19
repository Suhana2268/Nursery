package com.ec.onlineplantnursery.responseDto;
public class ProductResponseDto {
	
	private int pId;
	private String commonName;
	private double cost;
	private String productType;
	
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
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	@Override
	public String toString() {
		return "ProductResponseDto [pId=" + pId + ", commonName=" + commonName + ", cost=" + cost + ", productType="
				+ productType + "]";
	}
	
	
	

}