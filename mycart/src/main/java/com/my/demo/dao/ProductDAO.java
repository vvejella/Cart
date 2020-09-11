package com.my.demo.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.my.demo.entity.Product;
import com.my.demo.util.ProductException;

public interface ProductDAO extends JpaRepository<Product, Long> {
	
	
	@Query("from Product where id=?1")
	 Product getProductDetails(long id);

//	private Map<Integer,Product> pMap;
//	private  int id = 1;
//	Logger logger=Logger.getLogger(ProductDAO.class);
//	
//	public ProductDAO() {
//		pMap =new HashMap<>();//mapping for product id
//		pMap.put(id,new Product(id,"top","tops for women",600,2));
//		id++;
//	}
//
//	@Override
//	public boolean enterProduct(Product p) {
//		logger.info(p);
//		pMap.put(p.getId(),p);
//		System.out.println(pMap);
//		return true;
//	}
//
//	@Override
//	public Product getProductDetails(int id1) {
//		logger.info(id1);
//		return pMap.get(id1);//getting details of product
//	}
//
//	@Override
//	public Product makePrice(int id2, int quant1) throws ProductException {
//		Product p=pMap.get(id2);
//		if(p!=null)
//		{
//			int q=p.getQuant()-quant1;
//			if(q<0)
//			throw new ProductException("available quant="+p.getQuant());//Getting price of product by calculating quantity
//			p.setQuant(q);
//		}
//		return p;
//	}
}
