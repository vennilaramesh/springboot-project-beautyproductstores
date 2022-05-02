package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.Store;
import com.example.demo.error.StoreNotFoundException;

public interface StoreService {

	public List<Store> getStores() throws StoreNotFoundException;

	public Store saveStores(Store store) throws StoreNotFoundException;

	public void deleteStoresById(Long storeId);

	public Store updateStoresById(Long storeId, Store store) throws StoreNotFoundException;

	public Store getStoresById(Long storeId) throws StoreNotFoundException;

	public Store getStoresByAddress(String address) throws StoreNotFoundException;

	public Store getStoresByName(String storeName) throws StoreNotFoundException;

}