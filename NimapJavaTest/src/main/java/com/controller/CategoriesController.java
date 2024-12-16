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

import com.bean.Categories;


import com.services.CategoryServices;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController {
	@Autowired
	private CategoryServices categoryService;
	
	@GetMapping
	public Page<Categories> getAllCategories(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size){
		return categoryService.getAllCategories(page, size);
	}
	
	@PostMapping
	public Categories createCategory(@RequestBody Categories category) {
		return categoryService.createCategory(category);
	}
	
	@GetMapping("/{categoryId}")
	public ResponseEntity<Categories> getCategoryById(@PathVariable("categoryId") int categoryId){
		return categoryService.getCategoryById(categoryId).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping("/{categoryId}")
	public ResponseEntity<Categories> updateCategory(@PathVariable("categoryId") int categoryId, @RequestBody Categories category){
		return ResponseEntity.ok(categoryService.updateCategory( categoryId, category));
	}
	
	@DeleteMapping("/{categoryId}")
	public ResponseEntity<Void> deleteCategory(@PathVariable("categoryId") int categoryId){
		categoryService.deleteCategory(categoryId);
		return ResponseEntity.noContent().build();
	}
}