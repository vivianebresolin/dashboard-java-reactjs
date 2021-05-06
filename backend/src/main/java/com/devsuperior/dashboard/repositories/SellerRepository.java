package com.devsuperior.dashboard.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dashboard.entities.Seller;

public interface SellerRepository extends JpaRepository<Seller, Long> {

}
