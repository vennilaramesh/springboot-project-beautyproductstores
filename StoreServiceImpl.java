package com.example.demo.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Store;
import com.example.demo.error.StoreNotFoundException;
import com.example.demo.repository.StoreRepository;

@Service
public class StoreServiceImpl implements StoreService {
@Autowired
 private StoreRepository storeRepository;

@Override
public List<Store> getStores() throws StoreNotFoundException {
	
	return storeRepository.findAll();
}	
@Override
public Store saveStores(Store store) throws StoreNotFoundException {
	return storeRepository.save(store);
	
}
@Override
public void deleteStoresById(Long storeId) {
	storeRepository.deleteById(storeId);
}
@Override
public Store updateStoresById(Long storeId, Store store) throws StoreNotFoundException {
	Optional<Store> s=storeRepository.findById(storeId);
	Store sDB=storeRepository.findById(storeId).get();
	if(Objects.nonNull(store.getStoreName()) && !"".equalsIgnoreCase(store.getStoreName())) {
	sDB.setStoreName(store.getStoreName());	
	}
	if(Objects.nonNull(store.getAddress()) && !"".equalsIgnoreCase(store.getAddress())) {
		sDB.setAddress(store.getAddress());
	}
	if(s.isPresent()) {
		return storeRepository.save(sDB);
	}
	else 
		throw new StoreNotFoundException("Updation is not Possible,Id not found");

}

@Override
public Store getStoresById(Long storeId) throws StoreNotFoundException {
	Optional<Store> sid=storeRepository.findById(storeId);
	if(!sid.isPresent()) {
		throw new StoreNotFoundException("Store id does not exist");
	}
	else return sid.get();
}

@Override
public Store getStoresByAddress(String address) throws StoreNotFoundException {
	Optional<Store> s=Optional.ofNullable((storeRepository.findByAddress(address)));
	if(!s.isPresent()) {
		throw new StoreNotFoundException("Store Address does not exist");
	}
		else return s.get();
	
}

@Override
public Store getStoresByName(String storeName) throws StoreNotFoundException {
	Optional<Store> s=Optional.ofNullable(storeRepository.findBystoreName(storeName));
	if(!s.isPresent()) {
		throw new StoreNotFoundException("Store name does not exist");
	}
	else return s.get();
}

	

}
