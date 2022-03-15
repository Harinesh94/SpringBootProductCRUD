package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Product;

public interface ProductService {
	
	List<Product> getAllProducts();
	
	Product getProductbyId(long productId);
	
	Product createProduct(Product product);
	
	Product updateProduct(Product product,long id);
	
	void deleteProduct(long id);

}
