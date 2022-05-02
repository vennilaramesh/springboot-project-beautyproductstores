package com.example.demo.service;

import java.util.List;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.example.demo.entity.Product;
import com.example.demo.entity.Store;
import com.example.demo.error.ProductNotFoundException;
import com.example.demo.error.StoreNotFoundException;

public interface ProductService {

	List<Product> getProducts();

	Product saveProducts(Product product, Long storeId) throws StoreNotFoundException;

	void deleteProductsById(Long productId);

	Product updateProductsById (Long storeId ,Product product,Long productId) throws  ProductNotFoundException;

	Product getProductsById(Long productId) throws ProductNotFoundException;

	Product getProductByName(String productName) throws ProductNotFoundException;

	Product getProductByPrice(double productPrice) throws ProductNotFoundException;

	

}
