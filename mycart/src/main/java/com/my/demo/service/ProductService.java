package com.my.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.my.demo.entity.Product;
import com.my.demo.util.ProductException;

public interface ProductService {
	//boolean enterProduct(Product p);

	//Product getProductDetails(int id1);//details of prod in cart

	//Product price(int id2, int quant1) throws ProductException;//id and quant of prod

	Product addProduct(Product product);

	Product getProductDetails(long id) throws ProductException;

	double calculatePrice(long id, int quantity);

	List<Product> viewAllProducts();

}
