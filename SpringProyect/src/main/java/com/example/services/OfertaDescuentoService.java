package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.entity.OfertaDescuento;
import com.example.repository.OfertaDescuentoRepository;

@Service
public class OfertaDescuentoService {
	
	@Autowired
	
	OfertaDescuentoRepository ofertaDescuentoRepository;
	
	
	public OfertaDescuento findOne (Integer id){
		return ofertaDescuentoRepository.findOne(id);
		
	}
	
	public List<OfertaDescuento> findAll(){
		return ofertaDescuentoRepository.findAll();
		
    }
	
	public  OfertaDescuento findByCode(String code){
		return ofertaDescuentoRepository.findByCode(code);
	}
	
	public List <OfertaDescuento> findByNmae(String name){
		return ofertaDescuentoRepository.findByName(name);
	}
	public void save(OfertaDescuento ofertaDescuento){
		ofertaDescuentoRepository.save(ofertaDescuento);
	}
	public void delete(Integer id){
		ofertaDescuentoRepository.delete(id);
	}

	public Page<OfertaDescuento> findAll(PageRequest pageRequest) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
