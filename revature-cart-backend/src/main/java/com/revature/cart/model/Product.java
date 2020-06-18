package com.revature.cart.model;

import javax.persistence.*;

@Entity(name = "product")
@Table
public class Product {

	@Id
	private int productID;
	private int productValue;
	private int amountInStock;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int productID, int productValue, int amountInStock) {
		super();
		this.productID = productID;
		this.productValue = productValue;
		this.amountInStock = amountInStock;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public int getAmountInStock() {
		return amountInStock;
	}

	public void setAmountInStock(int amountInStock) {
		this.amountInStock = amountInStock;
	}

	public int getProductValue() {
		return productValue;
	}

	public void setProductValue(int productValue) {
		this.productValue = productValue;
	}

	@Override
	public String toString() {
		return "Product [productID=" + productID + ", productValue=" + productValue + ", amountInStock=" + amountInStock
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + productID;
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
		if (productID != other.productID)
			return false;
		return true;
	}
	
}
