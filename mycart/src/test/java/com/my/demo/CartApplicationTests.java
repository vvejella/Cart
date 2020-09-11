package com.my.demo;

/*package com.my.demo;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.my.demo.dao.ProductDAO;
import com.my.demo.entity.Product;
import com.my.demo.util.ProductException;



@SpringBootTest
class CartApplicationTests {

	static ProductDAO pdo;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		pdo=new ProductDAO();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testEnterProduct() {
		assertTrue(pdo.enterProduct(new Product(1,"Tops","Short top for women",900,2)));//entered details of product
	}

	@Test
	public void testGetProductDetails() {
		Product pe=pdo.getProductDetails(1);
		assertNotNull(pe);
	}

	@Test
	public void testMakePrice() throws ProductException {
		Product or = pdo.makePrice(1, 1);//test case for product by mapping Id 
		assertNotNull(or);
	}
}
*/





import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.my.demo.dao.ProductDAO;
import com.my.demo.entity.Product;
import com.my.demo.service.ProductService;
import com.my.demo.util.ProductException;


@SpringBootTest(classes=CartApplication.class)
@RunWith(SpringRunner.class)
public class CartApplicationTests {
    @Autowired
	ProductService productService;
    
    @MockBean
     ProductDAO productDao;
    
   
   
    @Test
    public void addProductTest()
    {
    	Product product = new Product(20010L,"JavaNew","Technical",3000.0,5);
    	when(productDao.save(product)).thenReturn(product);
    	assertEquals(product,productService.addProduct(product));
    }
    
    
      @Test
      public void viewAllProductsTest()
      {
     	when(productDao.findAll()).thenReturn(Stream.of(new Product(20020L,"Apple","Fruit",50.0,4),new Product(20021L,"Orange","Fruit",12.0,4)).collect(Collectors.toList()));
        assertEquals(2,productService.viewAllProducts().size());
    }
      
      @Test
      public void getProductDetailsTest() throws ProductException
      {
    	  Product product = new Product(20011L,"JavaNew","Technical",3000.0,5);
        long id =20011L;
        productDao.save(product);
    	  when(productDao.getProductDetails(id)).thenReturn(product);
    	 //when(productDao.getProductDetails(20011L)).thenReturn(product);
    	// Product p1 =productService.getProductDetails(20011L);
    	// System.out.println(p1);
    	 assertEquals(product ,productService.getProductDetails(id));
    	
      }
   
}









