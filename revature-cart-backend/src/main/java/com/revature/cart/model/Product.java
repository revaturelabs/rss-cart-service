package com.revature.cart.model;

import java.math.BigDecimal;

public class Product {
	
	private Long id;
	private String category;
	private String brand;
	private String name;
	private String description;
	private String model;
	private String image;
	private Integer quantity;
	private BigDecimal unitPrice;
	private String color;
	
	public Product() {
	}

	public Product(Long id, String category, String brand, String name, String description, String model,
			String image, Integer quantity, BigDecimal unitPrice, String color) {
		super();
		this.id = id;
		this.category = category;
		this.brand = brand;
		this.name = name;
		this.description = description;
		this.model = model;
		this.image = image;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.color = color;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", category=" + category + ", brand=" + brand + ", name="
				+ name + ", description=" + description + ", model=" + model + ", image=" + image + ", quantity="
				+ quantity + ", unitPrice=" + unitPrice + ", color=" + color + "]";
	}
}
