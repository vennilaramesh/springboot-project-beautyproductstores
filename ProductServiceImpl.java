package com.example.demo.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Product;
import com.example.demo.entity.Store;
import com.example.demo.error.ProductNotFoundException;
import com.example.demo.error.StoreNotFoundException;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.StoreRepository;

@Service
public class ProductServiceImpl implements ProductService,UserDetailsService{
@Autowired
private ProductRepository productRepository;
@Autowired
private StoreRepository storeRepository;

@Override
public List<Product> getProducts() {
		
		return productRepository.findAll() ;
	}

	@Override
	public Product saveProducts(Product product,Long storeId) throws StoreNotFoundException {
			if(!storeRepository.existsById(storeId)) {
			throw new StoreNotFoundException("store not found");
		}
		else {
			Store s =storeRepository.findById(storeId).get();
			product.setStore(s);
			s.getProductlist().add(product);
			return productRepository.save(product);
			
		}
}

	@Override
	public void deleteProductsById(Long productId) {
		productRepository.deleteById(productId);
		
	}

	@Override
	public Product updateProductsById(Long storeId,Product product,Long productId) throws ProductNotFoundException {
		Optional<Product> p=productRepository.findById(productId);
		if(p.isPresent()) {
			Store s=storeRepository.findById(storeId).get();
			product.setStore(s);
			Product pDB=productRepository.findById(productId).get();
		if(Objects.nonNull(product.getProductName()) && !"".equalsIgnoreCase(product.getProductName())) {
		pDB.setProductName(product.getProductName());	
		}
		if(Objects.nonNull(product.getProductPrice()) ) {
			pDB.setProductPrice(product.getProductPrice());
		}
		if(Objects.nonNull(product.getStore()) ) {
			pDB.setStore(product.getStore());
		}
		if(Objects.nonNull(product.getUserName()) && !"".equalsIgnoreCase(product.getUserName())) {
			pDB.setUserName(product.getUserName());	
			}
		if(Objects.nonNull(product.getPassword()) && !"".equalsIgnoreCase(product.getPassword())) {
			pDB.setPassword(product.getPassword());	
			}
		if(Objects.nonNull(product.getRole()) && !"".equalsIgnoreCase(product.getRole())) {
			pDB.setRole(product.getRole());	
			}
		return productRepository.save(pDB);
		}
		else throw new ProductNotFoundException("Product Id Does Not Exist");
			}

	@Override
	public Product getProductsById(Long productId) throws ProductNotFoundException {
		Optional<Product> pid=(productRepository.findById(productId));
		if(!pid.isPresent()) {
			throw new ProductNotFoundException("Product Id does not exist");
		}
		else return pid.get();
		
	}
	@Override
	public Product getProductByName(String productName) throws ProductNotFoundException {
	Optional<Product> pname=productRepository.findByproductName(productName);
	if(pname.isPresent()) {
		return productRepository.findByproductName(productName).get();
	}
	else throw new ProductNotFoundException("Product name does not exist");
	}

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Product p = productRepository.findByuserName(userName);
		if(p==null)
			throw new UsernameNotFoundException("User not found");
			return new CustomUserDetails(p);
		}

	@Override
	public Product getProductByPrice(double productPrice) throws ProductNotFoundException {
		Optional<Product> p=productRepository.findByproductPrice(productPrice);
		if(p.isPresent()) {
		return productRepository.findByproductPrice(productPrice).get();
	}
		else throw new ProductNotFoundException("No such price");
	}
}
