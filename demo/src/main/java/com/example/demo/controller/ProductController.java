package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	public ProductService productService;

	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProduct() {
		return ResponseEntity.ok().body(productService.getAllProducts());
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getProductbyId(@PathVariable long id){
		return ResponseEntity.ok().body(productService.getProductbyId(id));
		
	}
	
	@PostMapping("/product/create")
	public ResponseEntity<Product> createProduct(@RequestBody Product product){
		return ResponseEntity.ok().body(productService.createProduct(product));
	}
	
	@PutMapping("/product/update/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable long id,@RequestBody Product product){
		return ResponseEntity.ok().body(productService.updateProduct(product,id));
	}
	
	@DeleteMapping("/product/delete/{id}")
	public HttpStatus deleteProduct(@PathVariable long id){
		this.productService.deleteProduct(id);
		return HttpStatus.OK;
	}
	
}
