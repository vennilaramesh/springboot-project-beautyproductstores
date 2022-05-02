package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;
	@NotBlank(message="productname should never be empty")
	@Length(min=2,max=20,message="size should be in range")
	private String productName;
	@NotNull(message="productPrice should never be empty")
	private double productPrice;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "storeId")
	private Store store;
	private String password;
    @Column(unique = true)
	private String userName;
    private String role;
	public Product() {
		super();
	}
	public Product(Long productId, String productName, double productPrice, Store store, String password,
			String userName, String role) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.store = store;
		this.password = password;
		this.userName = userName;
		this.role = role;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public Store getStore() {
		return store;
	}
	public void setStore(Store store) {
		this.store = store;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", store=" + store + ", password=" + password + ", userName=" + userName + ", role=" + role + "]";
	}
}

