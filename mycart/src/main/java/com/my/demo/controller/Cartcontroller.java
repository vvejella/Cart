package com.my.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.my.demo.entity.Product;
import com.my.demo.service.ProductService;
import com.my.demo.util.ProductException;

@RestController
@RequestMapping("/cart")
public class Cartcontroller {

	@Autowired
     ProductService productService;
	
//	@RequestMapping(method=RequestMethod.GET)
//	public String index(ModelMap modelMap)
//	{
//	modelMap.put("id1", productservice.getProductDetails(0));//getting details by Id of product
//	return "id1/index";
//	}
	
	@PostMapping("/product")
	public Product addProduct(@RequestBody Product product)
	{
		return productService.addProduct(product);
		//return  ResponseEntity.ok().body(productService.addProduct(product));
	}
	@GetMapping("/getDetails/{id}")
	public ResponseEntity<Product> getProductDetails(@PathVariable long id) throws ProductException
	{
		Product p= productService.getProductDetails(id);
		HttpHeaders responseHeaders = new HttpHeaders();
		  // responseHeaders.setLocation(location);
		   responseHeaders.set("MyResponseHeader", "MyValue");
		   return new ResponseEntity<Product>(p, responseHeaders, HttpStatus.ACCEPTED);
		 }
		 
		
	
	
	@GetMapping("/makePrice/{id}/{quantity}")
	public double calculatePrice(@PathVariable long id , @PathVariable int quantity)
	{
		return productService.calculatePrice(id, quantity);
	}
	
	@GetMapping("/viewAllProducts")
	public List<Product> viewAllProducts()
	{
		return productService.viewAllProducts();
	}
	
	
	
}
