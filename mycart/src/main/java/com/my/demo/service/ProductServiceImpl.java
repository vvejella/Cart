package com.my.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.demo.dao.ProductDAO;
import com.my.demo.entity.Product;
import com.my.demo.util.ProductException;

@Service("productService")
public class ProductServiceImpl implements ProductService{



//	@Override
//	public boolean enterProduct(Product p) {
//		// TODO Auto-generated method stub
//		return pDao.enterProduct(p);
//	}
//
//	@Override
//	public Product getProductDetails(int id1) {
//	
//		return pDao.getProductDetails(id1);//get details of product
//	}
//
//	@Override
//	public Product price(int id2, int quant1) throws ProductException {
//		
//		return pDao.makePrice(id2,quant1);//getting price by calculating quant of product
//	}
	
	@Autowired
	ProductDAO productDao;
	@Override
	public Product addProduct(Product product) {
		return productDao.save(product);
	}
	
	public Product getProductDetails(long id) throws ProductException {
		
		//return productDao.getProductDetails(id);
		Product pro =null;
		if(productDao.existsById(id))
		{
			 pro = productDao.getProductDetails(id);
		}
		else
		{
			throw new ProductException("Product not found");
		}
		return pro;
		   // return productDao.findById(id).orElseThrow(()->new ProductException("Product not found"));
	}

	@Override
	public double calculatePrice(long id, int quantity) {
		
		 Product pro = productDao.getProductDetails(id);
		 int quantity1 = pro.getQuant();
		 double totalprice = 0;
		 if(quantity<=quantity1)
		 {
			 double price= pro.getPrice();
			 totalprice =(double)price*quantity;
		 }
		 else
		 {
			 System.out.println(quantity +"not abvailable");
		 }
		 return totalprice;
		 
	}

	@Override
	public List<Product> viewAllProducts() {
		 return  productDao.findAll();
	}

}
