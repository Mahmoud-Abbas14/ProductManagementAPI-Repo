package com.abbas.ProductManagementAPI.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

	
	@Id
    @Column(name = "id")  // match exact column name in DB
	private int id;
	@Column(name = "productName")
	private String productName;

	
	public Product() {
	
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + "]";
	}
	
	
	
	
}
