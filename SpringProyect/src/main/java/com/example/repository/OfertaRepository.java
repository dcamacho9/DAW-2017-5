package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Oferta;
import com.example.entity.OfertaDescuento;
import com.example.entity.Resource;

public interface OfertaRepository extends JpaRepository<Oferta,Integer> {
	
	
	List<Oferta> findByName(String name);
	Oferta findByCode(String code);
	
	
	
	
	
	



}
