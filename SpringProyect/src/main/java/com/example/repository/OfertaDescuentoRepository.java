package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.OfertaDescuento;

public interface OfertaDescuentoRepository extends JpaRepository<OfertaDescuento,Integer> {
	
	
	List<OfertaDescuento> findByName(String name);
	
	OfertaDescuento findByCode(String code);
	
	
	
	
	
	



}