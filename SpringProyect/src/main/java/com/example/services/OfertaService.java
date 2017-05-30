package com.example.services;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.entity.Oferta;
import com.example.repository.OfertaRepository;

@Service
public class OfertaService {
	
	@Autowired 
	private OfertaRepository ofertaRepository;
	
	
	public Oferta findOne(Integer id){
		return ofertaRepository.findOne(id);
	}
	
	public List<Oferta>findAll(){
		return ofertaRepository.findAll();
		
	}
	public Oferta findByCode(String code){
		return ofertaRepository.findByCode(code);
		
		
	}
	public List<Oferta>findByName(String name){
		return ofertaRepository.findByName(name);
	}
	
	public void save(Oferta oferta){
		ofertaRepository.save(oferta);
	}
	public void delete(Integer id){
		ofertaRepository.delete(id);
		
	}
	public void delete(Oferta oferta){
		ofertaRepository.delete(oferta);
	}

	public Page<Oferta> findAll(PageRequest pageRequest) {
		// TODO Auto-generated method stub
		return ofertaRepository.findAll(pageRequest);
	}

	
	
	
	

}
