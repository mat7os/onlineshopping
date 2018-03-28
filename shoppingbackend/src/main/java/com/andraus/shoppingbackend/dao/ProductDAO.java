package com.andraus.shoppingbackend.dao;

import java.util.List;

import com.andraus.shoppingbackend.dto.Product;

public interface ProductDAO {

	List<Product> list();

	Product get(int id);

	boolean add(Product product);

	boolean update(Product product);

	boolean delete(Product product);
	
	// Busines Methods
	
	List<Product> listActiveProducts();
	List<Product> listActiveProductsByCategory(int productId);
	List<Product> getLatestActiveProducts(int count);
}
