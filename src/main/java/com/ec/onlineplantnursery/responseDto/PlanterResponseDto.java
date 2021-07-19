package com.ec.onlineplantnursery.responseDto;

import com.ec.onlineplantnursery.entity.Plant;
import com.ec.onlineplantnursery.entity.Seed;

public class PlanterResponseDto {

	private int pId;
	private String commonName;
	private float planterheight;
	private int planterCapacity;
	private int drinageHoles;
	private int planterColor;
	private String planterShape;
	private int planterStock;
	private double cost;
	
	

	public String getCommonName() {
		return commonName;
	}

	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public float getPlanterheight() {
		return planterheight;
	}

	public void setPlanterheight(float planterheight) {
		this.planterheight = planterheight;
	}

	public int getPlanterCapacity() {
		return planterCapacity;
	}

	public void setPlanterCapacity(int planterCapacity) {
		this.planterCapacity = planterCapacity;
	}

	public int getDrinageHoles() {
		return drinageHoles;
	}

	public void setDrinageHoles(int drinageHoles) {
		this.drinageHoles = drinageHoles;
	}

	public int getPlanterColor() {
		return planterColor;
	}

	public void setPlanterColor(int planterColor) {
		this.planterColor = planterColor;
	}

	public String getPlanterShape() {
		return planterShape;
	}

	public void setPlanterShape(String planterShape) {
		this.planterShape = planterShape;
	}

	public int getPlanterStock() {
		return planterStock;
	}

	public void setPlanterStock(int planterStock) {
		this.planterStock = planterStock;
	}

	

	
	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "PlanterResponseDto [pId=" + pId + ", commonName=" + commonName + ", planterheight=" + planterheight
				+ ", planterCapacity=" + planterCapacity + ", drinageHoles=" + drinageHoles + ", planterColor="
				+ planterColor + ", planterShape=" + planterShape + ", planterStock=" + planterStock + ", cost="
				+ cost + "]";
	}

	

	

}
