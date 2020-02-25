package com.olearningc.model;

import java.sql.Date;

public class Product {
	
	private int id;
	private String name;
	private double stock;
	private double price;
	private Date date_create;
	private Date date_update;
	
	
	public Product() {
		
	}


	public Product(int id, String name, double stock, double price, Date date_create, Date date_update) {
		this.id = id;
		this.name = name;
		this.stock = stock;
		this.price = price;
		this.date_create = date_create;
		this.date_update = date_update;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getStock() {
		return stock;
	}


	public void setStock(double stock) {
		this.stock = stock;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public Date getDate_create() {
		return date_create;
	}


	public void setDate_create(Date date_create) {
		this.date_create = date_create;
	}


	public Date getDate_update() {
		return date_update;
	}


	public void setDate_update(Date date_update) {
		this.date_update = date_update;
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", stock=" + stock + ", price=" + price + ", date_create="
				+ date_create + ", date_update=" + date_update + "]";
	}
	
	
	

}
