package com.andraus.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.andraus.shoppingbackend.dao.ProductDAO;
import com.andraus.shoppingbackend.dto.Category;
import com.andraus.shoppingbackend.dto.Product;



public class ProductTestCase {
	
private static AnnotationConfigApplicationContext context;
	
	
	private static ProductDAO productDAO;
	
	
	private Product product;
	
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.andraus.shoppingbackend");
		context.refresh();
		productDAO = (ProductDAO)context.getBean("ProductDAO");
	}
	
	public void testAddCategory() {
		
		product = new Product("Plus 6", "Iphone", "Iphone desc", 700.90, 55, 1, true, 1, 20, 100);
		
		
		assertEquals("Successfully added a product inside the table!",true,productDAO.add(product));
		
		
	}
	
	

}
