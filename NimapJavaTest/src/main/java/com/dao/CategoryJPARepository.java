package com.dao;

import org.springframework.data.jpa.repository.JpaRepository; 

import com.bean.Categories;

public interface CategoryJPARepository  extends JpaRepository<Categories,Integer>{

}
