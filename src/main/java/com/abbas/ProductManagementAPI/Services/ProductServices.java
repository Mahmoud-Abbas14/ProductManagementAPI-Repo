package com.abbas.ProductManagementAPI.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.abbas.ProductManagementAPI.Repositories.ProductRepository;
import com.abbas.ProductManagementAPI.models.Product;
import com.telusko.demo_rest_2.Alien;

@Service
public class ProductServices {

	@Autowired
	ProductRepository productRepository;

	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	public void addProduct(Product p) {


		productRepository.save(p);
	}

	public Product getOneProduct(String name) {
		return productRepository.findByProductName(name);
	}

	public ResponseEntity<Product> updateProduct(int id, Product newProduct) {
	      return productRepository.findById(id)
	              .map(product -> {
	                  product.setProductName(newProduct.getProductName());
	                  Product updated = productRepository.save(product);
	                  return ResponseEntity.ok(updated);
	              })
	              .orElseGet(() -> ResponseEntity.notFound().build());
	}

	public ResponseEntity<Void> deleteProduct(int id) {
		if (productRepository.existsById(id)) {
	          productRepository.deleteById(id);
	          return ResponseEntity.noContent().build(); 
	      } else {
	          return ResponseEntity.notFound().build(); 
	      }
	}
	      
	
	
	
}
