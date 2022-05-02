package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {

	Store findBystoreName(String storeName);

	Store findByAddress(String address);
}
