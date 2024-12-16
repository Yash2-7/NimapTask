package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Product;
import com.services.ProductServices;



@RestController
@RequestMapping("/api/products")
public class ProductController {
	@Autowired
	private ProductServices productsServices;
	
	@GetMapping
	public Page<Product> getAllProducts(@RequestParam(defaultValue ="0")int page,@RequestParam(defaultValue = "10") int size){
		return productsServices.getAllProducts(page,size);
	}
	
	@PostMapping
	public Product createProduct(@RequestBody Product product) {
		return productsServices.createProduct(product);
	}
	
	@GetMapping("/{productId}")
	public ResponseEntity<Product> getProductById(@PathVariable("productId") int productId){
		return productsServices.getProductById(productId).map(product -> {
			product.getCategory();
			return ResponseEntity.ok(product);
		}).orElse(ResponseEntity.notFound().build());
	}
	
    @PutMapping("/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable("productId") int productId, @RequestBody Product product){
    	return ResponseEntity.ok(productsServices.updateProduct(productId, product));
    }
    
    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("productId") int productId){
    	productsServices.deleteProduct(productId);
    	return ResponseEntity.noContent().build();
    }
}