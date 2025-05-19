package com.abbas.ProductManagementAPI.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abbas.ProductManagementAPI.models.Product;
import com.telusko.demo_rest_2.Alien;

@Repository
public interface ProductRepository extends  JpaRepository<Product, Integer> {

	Product findByProductName(String name);

	void deleteById(int id);

}