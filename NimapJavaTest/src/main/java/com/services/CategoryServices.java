package com.services;





import java.util.Optional; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

 
import com.bean.Categories;
import com.dao.CategoryJPARepository;

@Service
public class CategoryServices {
	@Autowired
	private CategoryJPARepository categoryRepository;
	
	public Page<Categories> getAllCategories(int page, int size){
		return categoryRepository.findAll(PageRequest.of(page, size));
	}
	
	public Categories createCategory(Categories category){
		return categoryRepository.save(category);
	}
	
	public Optional<Categories> getCategoryById(int cId){
		return categoryRepository.findById(cId);
	}
	
	public Categories updateCategory(int cId,Categories categoryDetails){
		Categories category = categoryRepository.findById(cId).orElseThrow(() -> new RuntimeException("Category not found"));
		category.setCategoryName(categoryDetails.getCategoryName());
		return categoryRepository.save(category);
	}
	
	public void deleteCategory(int cId){
		categoryRepository.deleteById(cId);
	}
}