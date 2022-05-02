package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;



@Entity
public class Store {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long storeId;
	@NotEmpty(message="Name should never be empty")
	private String storeName;
	private String address;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="storeId")
	private List<Product> productlist=new ArrayList<Product>();

	
	public Store() {
		super();
	}
	public Store(Long storeId, String storeName, String address, List<Product> productlist) {
		super();
		this.storeId = storeId;
		this.storeName = storeName;
		this.address = address;
		this.productlist = productlist;
	}
	public Long getStoreId() {
		return storeId;
	}
	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<Product> getProductlist() {
		return productlist;
	}
	public void setProductlist(List<Product> productlist) {
		this.productlist = productlist;
	}
	@Override
	public String toString() {
		return "Store [storeId=" + storeId + ", storeName=" + storeName + ", address=" + address + ", productlist="
				+ productlist + "]";
	}

}
