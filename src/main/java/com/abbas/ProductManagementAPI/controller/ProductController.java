package com.abbas.ProductManagementAPI.controller;


import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abbas.ProductManagementAPI.Repositories.ProductRepository;
import com.abbas.ProductManagementAPI.Services.ProductServices;
import com.abbas.ProductManagementAPI.models.Product;

import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;

@RestController
public class ProductController {

  

  @GetMapping("/")
  @Operation(summary = "Home endpoint", description = "Returns a welcome message")
  public void redirect(HttpServletResponse response) throws IOException {
    response.sendRedirect("/swagger-ui.html");
  }
  
  
  
  @Autowired
  ProductServices services;
  
  
  @GetMapping("/products")
  public List<Product> getAllProducts(){
	  
	  return services.getAllProducts();
  }
  
  @GetMapping("/product/{productName}")
  public Product getOneProduct(@PathVariable String productName){
	  
	  return services.getOneProduct(productName);
  }
  
  @PostMapping("/product")
  public void addProduct(@RequestBody Product p) {
	  services.addProduct(p);
	 
  }
  
  @PutMapping("/product/{id}")
  public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody Product newProduct) {
      return services.updateProduct(id, newProduct);
  }
  
  @DeleteMapping("/product/{id}")
  public ResponseEntity<Void> deleteProduct(@PathVariable int id) {
      return services.deleteProduct(id);
  }

  
  
  
  
}
