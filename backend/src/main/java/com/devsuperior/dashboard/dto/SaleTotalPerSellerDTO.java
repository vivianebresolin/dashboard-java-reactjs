package com.devsuperior.dashboard.dto;

import java.io.Serializable;

import com.devsuperior.dashboard.entities.Seller;

public class SaleTotalPerSellerDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String sellerName;
	private Double total;
	
	public SaleTotalPerSellerDTO() {		
	}
	
	public SaleTotalPerSellerDTO(Seller seller, Double total) {
		this.sellerName = seller.getName();
		this.total = total;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}
	
	
}
