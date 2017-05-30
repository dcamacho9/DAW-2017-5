package com.example.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.OfertaDescuento;
import com.example.repository.OfertaDescuentoRepository;
import com.fasterxml.jackson.annotation.JsonView;
@RestController
@RequestMapping("api/ofertasDescuento")
public class ofertaDescuentoRestController {
	public interface OfertaDescuentoDetail extends OfertaDescuento.Basic{};
	
	@Autowired
	private OfertaDescuentoRepository ofertaDescuentoRepository;
	
	@RequestMapping(value="/", method =RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public OfertaDescuento postOfertaDescuento(@RequestBody OfertaDescuento ofertaDescuento){
		ofertaDescuentoRepository.save(ofertaDescuento);
		
		return ofertaDescuento;
		
	}
	
	@JsonView(OfertaDescuentoDetail.class)
	@RequestMapping(value="/all", method = RequestMethod.GET)
	public ResponseEntity<List<OfertaDescuento>> getOfertasDescuento(){
		
		List<OfertaDescuento> ofertas = ofertaDescuentoRepository.findAll();
		if(ofertas != null){
			   return new ResponseEntity<>(ofertas,HttpStatus.OK);
			
		}else{
			   return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@JsonView(OfertaDescuentoDetail.class)
	@RequestMapping(value="/{code}", method= RequestMethod.GET)
	public ResponseEntity<OfertaDescuento>getOfertasDescuentoCodigo(@PathVariable String code){
		OfertaDescuento ofertaDescuento= ofertaDescuentoRepository.findByCode(code);
		if(ofertaDescuento!= null){
			   return  new ResponseEntity<>(ofertaDescuento,HttpStatus.OK);
		}else{
			   return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
		
	
	@RequestMapping(value="/oferta/{code}",method = RequestMethod.DELETE)
    public ResponseEntity<OfertaDescuento> deleteOfertaDescuento(@PathVariable String code){
    	OfertaDescuento ofertaDescuento = ofertaDescuentoRepository.findByCode(code);
    	if(ofertaDescuento!= null){
    		ofertaDescuentoRepository.delete(ofertaDescuento);
    		return new ResponseEntity<>(ofertaDescuento,HttpStatus.OK);
    	}else{
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	}
    }
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public ResponseEntity<OfertaDescuento> putOfertaDescuento(@PathVariable Integer id,@RequestBody OfertaDescuento ofertaUpdated){
		OfertaDescuento ofertaDescuento = ofertaDescuentoRepository.findOne(id);
		if((ofertaDescuento!= null) && (ofertaDescuento.getId()== ofertaUpdated.getId())){
			ofertaDescuentoRepository.save(ofertaUpdated);
			return new ResponseEntity<>(ofertaUpdated,HttpStatus.OK);
		}else{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	

}
