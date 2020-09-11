package com.my.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="product_cart")
public class Product {
   
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cart_product_seq_gen")
	@SequenceGenerator(name = "cart_product_seq_gen", initialValue=20000, sequenceName = "cart_product_seq")
	private long id;
	
	@Column(length = 20)
	private String name;
	
	@Column(length = 20)
	private String categry;
	
	private double price;
	private int quant;
	public Product(long id, String name, String categry, double price, int quant) {
		super();
		this.id = id;
		this.name = name;
		this.categry = categry;
		this.price = price;
		this.quant = quant;
	}
	
	public Product() {
		super();
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategry() {
		return categry;
	}
	public void setCategry(String categry) {
		this.categry = categry;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuant() {
		return quant;
	}
	public void setQuant(int quant) {
		this.quant = quant;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", categry=" + categry + ", price=" + price + ", quant=" + quant
				+ "]";
	}
	
	
	
	
}
