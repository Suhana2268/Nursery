package com.ec.onlineplantnursery.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "productType",discriminatorType = DiscriminatorType.STRING)
public class Product implements Comparable<Product>,Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int pId;
	
	@ApiModelProperty(name = "ProductName", value = "Hold the min 3 char seed name", required = true)
	@NotEmpty(message = "Product Name cannot be left blank or null")
	@Size(min = 3, max = 15, message = "Invalid Product Name, Product Name should have minimum 3 and maximum 15 characters")
	private String commonName;

	@Column(name="productType", insertable = false, updatable = false)
	private String productType;
	
	private double cost;

	public Product() {
		super();
		
	}
	public Product(int pId,
			@NotEmpty(message = "Product Name cannot be left blank or null") @Size(min = 3, max = 15, message = "Invalid Product Name, Product Name should have minimum 3 and maximum 15 characters") String commonName,
			double cost, String productType) {
		super();
		this.pId = pId;
		this.commonName = commonName;
		this.cost = cost;
		this.productType = productType;
	}



	public Product(int pId, double cost,String commonName) {
		super();
		this.pId = pId;
		this.cost = cost;
		this.commonName=commonName;
	}

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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((commonName == null) ? 0 : commonName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(cost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + pId;
		result = prime * result + ((productType == null) ? 0 : productType.hashCode());
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
		Product other = (Product) obj;
		if (commonName == null) {
			if (other.commonName != null)
				return false;
		} else if (!commonName.equals(other.commonName))
			return false;
		if (Double.doubleToLongBits(cost) != Double.doubleToLongBits(other.cost))
			return false;
		if (pId != other.pId)
			return false;
		if (productType == null) {
			if (other.productType != null)
				return false;
		} else if (!productType.equals(other.productType))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Product [pId=" + pId + ", commonName=" + commonName + ", productType=" + productType + ", cost=" + cost
				+ "]";
	}
	@Override
	public int compareTo(Product o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}