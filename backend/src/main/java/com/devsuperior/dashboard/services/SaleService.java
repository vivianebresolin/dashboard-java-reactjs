package com.devsuperior.dashboard.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dashboard.dto.SaleConversionRateDTO;
import com.devsuperior.dashboard.dto.SaleDTO;
import com.devsuperior.dashboard.dto.SaleTotalPerSellerDTO;
import com.devsuperior.dashboard.entities.Sale;
import com.devsuperior.dashboard.repositories.SaleRepository;
import com.devsuperior.dashboard.repositories.SellerRepository;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository repository;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable) {
		sellerRepository.findAll();
		Page<Sale> result = repository.findAll(pageable);
		return result.map(x -> new SaleDTO(x));

	}
	
	@Transactional(readOnly = true)
	public List<SaleTotalPerSellerDTO> amountGroupedBySeller(){
		return repository.amountGroupedBySeller();
	}
	
	@Transactional(readOnly = true)
	public List<SaleConversionRateDTO> conversionRateGroupedBySeller(){
		return repository.conversionRateGroupedBySeller();
	}
	
}
