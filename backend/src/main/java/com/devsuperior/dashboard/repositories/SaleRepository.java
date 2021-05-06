package com.devsuperior.dashboard.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dashboard.dto.SaleConversionRateDTO;
import com.devsuperior.dashboard.dto.SaleTotalPerSellerDTO;
import com.devsuperior.dashboard.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {
	
	@Query("SELECT new com.devsuperior.dashboard.dto.SaleTotalPerSellerDTO(obj.seller, SUM(obj.amount)) "
			+ "FROM Sale AS obj GROUP BY obj.seller")
	List<SaleTotalPerSellerDTO> amountGroupedBySeller();
	
	@Query("SELECT new com.devsuperior.dashboard.dto.SaleConversionRateDTO(obj.seller, SUM(obj.visited), SUM(obj.deals)) "
			+ "FROM Sale AS obj GROUP BY obj.seller")
	List<SaleConversionRateDTO> conversionRateGroupedBySeller();
}
