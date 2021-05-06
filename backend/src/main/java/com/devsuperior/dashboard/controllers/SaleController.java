package com.devsuperior.dashboard.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dashboard.dto.SaleConversionRateDTO;
import com.devsuperior.dashboard.dto.SaleDTO;
import com.devsuperior.dashboard.dto.SaleTotalPerSellerDTO;
import com.devsuperior.dashboard.services.SaleService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {
	
	@Autowired
	private SaleService service;
	
	@GetMapping
	public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable) {
		Page<SaleDTO> list = service.findAll(pageable);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/total-per-seller")
	public ResponseEntity<List<SaleTotalPerSellerDTO>> amountGroupedBySeller() {
		List<SaleTotalPerSellerDTO> list = service.amountGroupedBySeller();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/conversion-rate-per-seller")
	public ResponseEntity<List<SaleConversionRateDTO>> conversionRateGroupedBySeller() {
		List<SaleConversionRateDTO> list = service.conversionRateGroupedBySeller();
		return ResponseEntity.ok(list);
	}
}
