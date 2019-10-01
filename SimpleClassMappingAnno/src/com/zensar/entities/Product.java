package com.zensar.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author RAHUL BANGALORE SRIDHAR
 * @creation_date 25th sep 2019 4.43pm
 * @modification_date 25th sep 4.44pm
 * @version 1.0
 * @copyright zensar technologies.All rights reserved
 * @description: it is persistent class
 * 				 it represents database table product
 * 				 it is a POJO class.
 *
 */

@Entity
@Table(name = "Product")	//mapping wid table

public class Product {
@Id
@Column(name = "id")
	private int productId;
	private String name;
	private String brand;
	private float price;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	public Product(int productId, String name, String brand, float price) {
		super();
		this.productId = productId;
		this.name = name;
		this.brand = brand;
		this.price = price;
	}

	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", brand=" + brand + ", price=" + price + "]";
	}
	
	
}
