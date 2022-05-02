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
import com.example.demo.entity.Store;
import com.example.demo.error.StoreNotFoundException;
import com.example.demo.service.StoreService;

@RestController
public class StoreController {
	@Autowired
	private StoreService storeService;
	
	//Selecting data from the database
	@GetMapping("/stores/")
	public List<Store> getStores() throws StoreNotFoundException{
		return storeService.getStores();
		
	}
	
	//Adding data into the database
	@PostMapping("/stores/")
	public Store saveStores(@Valid @RequestBody Store store) throws StoreNotFoundException {
		return storeService.saveStores(store);
		
	}
	
	//Deleting data from the database by using id
	@DeleteMapping("/stores/{id}")
	public String deleteStoresById(@PathVariable("id") Long storeId) {
		storeService.deleteStoresById(storeId);
		return "Store Has Been Deleted Successfully";
		}
	
	//Updating data in the database
	@PutMapping("/stores/{id}")
	public Store updateStoresById(@Valid @PathVariable("id") Long storeId,@RequestBody Store store) throws StoreNotFoundException {
		return storeService.updateStoresById(storeId,store);
		
	}
	
	//Selecting data from the database by using id
	@GetMapping("/customer/stores/{id}")
	public Store getStoresById(@PathVariable("id") Long storeId) throws StoreNotFoundException {
		return storeService.getStoresById(storeId);
		
	}
	
	//Selecting data from the database by using address
	@GetMapping("/customer/stores/address/{address}")
	public Store getStoresByAddress(@PathVariable("address") String address) throws StoreNotFoundException {
		return storeService.getStoresByAddress(address);
		
	}
	
	//Selecting data from the database by using name
	@GetMapping("/customer/stores/name/{name}")
	public Store getStoresByName(@PathVariable("name") String storeName) throws StoreNotFoundException {
		return storeService.getStoresByName(storeName);
		
	}
}