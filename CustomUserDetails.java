package com.example.demo.service;

import java.util.Collection;
import java.util.Collections;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.example.demo.entity.Product;


public class CustomUserDetails implements UserDetails {
private Product product;
public CustomUserDetails(Product product) {
	super();
	this.product=product;
}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.singleton(new SimpleGrantedAuthority(product.getRole()));
	}

	@Override
	public String getPassword() {
		
		return product.getPassword();	
		}

	@Override
	public String getUsername() {
		
		return product.getUserName();
	
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}

	

}
