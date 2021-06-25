package com.ec.onlineplantnursery.entity;


import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.TableGenerator;


@Entity
@TableGenerator(name = "product_generator", initialValue = 0, allocationSize = 50)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(
		 name = "Product_Type",
		 discriminatorType =DiscriminatorType.STRING)
public class Product implements Comparable<Product>,Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "product_generator")
	private Integer pId;
	
	private int units;
	
	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Integer getpId() {
		return pId;
	}



	public void setpId(Integer pId) {
		this.pId = pId;
	}



	public int getUnits() {
		return units;
	}



	public void setUnits(int units) {
		this.units = units;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pId == null) ? 0 : pId.hashCode());
		result = prime * result + units;
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
		if (pId == null) {
			if (other.pId != null)
				return false;
		} else if (!pId.equals(other.pId))
			return false;
		if (units != other.units)
			return false;
		return true;
	}



	public Product(Integer pId, int units) {
		super();
		this.pId = pId;
		this.units = units;
	}



	@Override
	public String toString() {
		return "Product [pId=" + pId + ", units=" + units + "]";
	}



	@Override
	public int compareTo(Product o) {
		// TODO Auto-generated method stub
		return 0;
	}


	
	
	

}




