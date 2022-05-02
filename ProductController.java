package com.example.demo.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Product;
import com.example.demo.error.ProductNotFoundException;
import com.example.demo.error.StoreNotFoundException;
import com.example.demo.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	private ProductService productService;
	
	//Selecting data from the database
		@GetMapping("/admin/products/")
		public List<Product> getProducts(){
			return productService.getProducts();
			
		}
		
	//Adding data into the database
		@PostMapping("/admin/products/{storeId}")
		public Product saveProducts(@Valid @RequestBody Product product,@PathVariable Long storeId) throws StoreNotFoundException {
			return productService.saveProducts(product,storeId);
			
		}
		
		//Deleting data from the database by using id
		@DeleteMapping("/admin/products/{id}")
		public String deleteProductsById(@PathVariable("id") Long productId) {
			productService.deleteProductsById(productId);
			return "Product Has Been Deleted Successfully";
			}
		
		//Updating data in the database
		@PutMapping("/admin/stores/{storeId}/products/{id}")
		public Product updateProductById(@PathVariable Long storeId,  @RequestBody Product product,@PathVariable("id") Long  productId) throws StoreNotFoundException, ProductNotFoundException {
			return productService.updateProductsById(storeId,product,productId);
			
		}
		
		//Selecting data from the database by using id
		@GetMapping("/customer/products/{id}")
		public Product getProductsById(@PathVariable("id") Long productId) throws ProductNotFoundException {
			return productService.getProductsById(productId);
			
		}
		
		//Selecting data from the database by using address
		@GetMapping("/customer/products/price/{price}")
		public Product getProductsByPrice(@PathVariable("price") double productPrice) throws ProductNotFoundException {
			return productService.getProductByPrice(productPrice);
			
		}
		
		//Selecting data from the database by using name
		@GetMapping("/customer/products/name/{name}")
		public Product getProductByName(@PathVariable("name") String productName) throws ProductNotFoundException {
			return productService.getProductByName(productName);
			
		}
}
