package com.bean;

import java.util.*;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class Categories {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int category;
	private String categoryName;
	@OneToMany(mappedBy="category" ,cascade=CascadeType.ALL,orphanRemoval=true)
	private List<Product> productList=new ArrayList<>();
	
	public Categories() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Categories(String categoryName) {
		super();
		this.categoryName = categoryName;
	}
	public int getCategoryId() {
		return category;
	}
	public void setCategoryId(int categoryId) {
		this.category = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public List<Product> getProductList() {
		return productList;
	}
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	@Override
	public String toString() {
		return "Categories [categoryId=" + category + ", categoryName=" + categoryName + "]";
	}
	
	
	
	

}
