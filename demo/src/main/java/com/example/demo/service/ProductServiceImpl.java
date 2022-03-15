package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> getAllProducts() {		
		return this.productRepository.findAll();
	}

	@Override
	public Product getProductbyId(long productId) {
		Optional<Product> prod = this.productRepository.findById(productId);
		
		if(prod.isPresent()) {
			return prod.get();
		}else {
			return null;
		}
	}

	@Override
	public Product createProduct(Product product) {
		return this.productRepository.save(product);
	}
	
	

	@Override
	public Product updateProduct(Product product,long id) {
		Optional<Product> prodDB = productRepository.findById(id);
		
		if(prodDB.isPresent()) {
			Product prodUpdate = prodDB.get();
			//prodUpdate.setId(product.getId());
			prodUpdate.setName(product.getName());
			prodUpdate.setDescription(product.getDescription());
			prodUpdate.setPrice(product.getPrice());
			return productRepository.save(prodUpdate);
		}else {
			return null;
		}
	}

	@Override
	public void deleteProduct(long id) {
		Optional<Product> prod = this.productRepository.findById(id);
		
		if(prod.isPresent()) {
			this.productRepository.delete(prod.get());
		}else {
			
		}
	}

}
