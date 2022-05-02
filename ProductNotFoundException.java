package com.example.demo.error;

public class ProductNotFoundException extends Exception {
	public   ProductNotFoundException(String msg) {
		super(msg);
	}
}
