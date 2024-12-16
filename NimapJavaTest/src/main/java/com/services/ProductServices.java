package com.services;

import java.util.Optional; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.dao.ProductJPARepository;

import com.bean.Product;


@Service
public class ProductServices {
	@Autowired
	private ProductJPARepository productRepository;
	
	public Page<Product> getAllProducts(int page, int size){
		return productRepository.findAll(PageRequest.of(page, size));
	}
	
	public Product createProduct(Product product){
		return productRepository.save(product);
	}
	
	public Optional<Product> getProductById(int pId){
		return productRepository.findById(pId);
	}
	
	public Product updateProduct(int pId, Product productDetails) {
	     Product product = productRepository.findById(pId).orElseThrow(() -> new RuntimeException("Product not found"));
	     product.setProductName(productDetails.getProductName());
	     product.setCost(productDetails.getCost());
	     product.setCategory(productDetails.getCategory());
	     return productRepository.save(product);
	}
	
	public void deleteProduct(int pId){
		productRepository.deleteById(pId);
	}
}