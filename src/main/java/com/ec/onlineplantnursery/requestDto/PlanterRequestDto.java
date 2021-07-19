package com.ec.onlineplantnursery.requestDto;

import javax.validation.constraints.Min;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.ec.onlineplantnursery.entity.Plant;
import com.ec.onlineplantnursery.entity.Seed;

import lombok.Data;

@Data
public class PlanterRequestDto {

	private int pId;

	private String commonName;
	
	@Positive(message = "Should be positive")
	private float planterheight;

	@Min(value = 1, message = "Capacity cannot be less than 1")
	private int planterCapacity;

	@Positive(message = "Should be positive")
	private int drinageHoles;

	@Positive(message = "Should be positive")
	private int planterColor;

	@NotEmpty(message = "Planter shape cannot be left blank or null")
	@Size(min = 3, max = 15, message = "Invalid Planter shape")
	private String planterShape;

	@Min(value = 1, message = "In stock cannot be less than 1")
	private int planterStock;

	private double cost;


	

	public PlanterRequestDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public PlanterRequestDto(int pId, String commonName, @Positive(message = "Should be positive") float planterheight,
			@Min(value = 1, message = "Capacity cannot be less than 1") int planterCapacity,
			@Positive(message = "Should be positive") int drinageHoles,
			@Positive(message = "Should be positive") int planterColor,
			@NotEmpty(message = "Planter shape cannot be left blank or null") @Size(min = 3, max = 15, message = "Invalid Planter shape") String planterShape,
			@Min(value = 1, message = "In stock cannot be less than 1") int planterStock, double cost) {
		super();
		this.pId = pId;
		this.commonName = commonName;
		this.planterheight = planterheight;
		this.planterCapacity = planterCapacity;
		this.drinageHoles = drinageHoles;
		this.planterColor = planterColor;
		this.planterShape = planterShape;
		this.planterStock = planterStock;
		this.cost = cost;
	}



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
		return "PlanterRequestDto [pId=" + pId + ", commonName=" + commonName + ", planterheight=" + planterheight
				+ ", planterCapacity=" + planterCapacity + ", drinageHoles=" + drinageHoles + ", planterColor="
				+ planterColor + ", planterShape=" + planterShape + ", planterStock=" + planterStock + ", cost=" + cost
				+ "]";
	}

	

	

	

	

}
