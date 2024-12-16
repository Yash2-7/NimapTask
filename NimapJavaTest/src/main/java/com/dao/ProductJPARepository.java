package com.dao;

import org.springframework.data.jpa.repository.JpaRepository; 

import com.bean.Product;

public interface ProductJPARepository  extends JpaRepository<Product,Integer> {

}
