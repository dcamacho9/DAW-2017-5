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

import com.example.entity.Oferta;
import com.example.repository.OfertaRepository;
import com.example.services.OfertaService;

@RestController
@RequestMapping("api/ofertas")
public class OfertaRestController {
	@Autowired
	private OfertaService ofertaRepository;
	
	@RequestMapping(value="/",method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public Oferta postOferta(@RequestBody Oferta oferta){
		ofertaRepository.save(oferta);
		return oferta;
		
	}
	
	
	@RequestMapping(value="/all",method = RequestMethod.GET)
	public ResponseEntity<List<Oferta>> getOfertas(){
		List<Oferta>ofertas = ofertaRepository.findAll();
		if(ofertas!= null){
			return new ResponseEntity<>(ofertas,HttpStatus.OK);
		}else{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Oferta> getOferta(@PathVariable Integer id){
		Oferta oferta = ofertaRepository.findOne(id);
		if(oferta!=null){
			return new ResponseEntity<>(oferta,HttpStatus.OK);
		}else{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@RequestMapping(value="/ofertas/{code}", method=RequestMethod.GET)
	public ResponseEntity<Oferta> getOfertaCodigo(@PathVariable String code){
		Oferta oferta = ofertaRepository.findByCode(code);
		if(oferta!= null){
			return new ResponseEntity<>(oferta,HttpStatus.OK);
		}else{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
	}
		
	}
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Oferta>deleteOferta(@PathVariable Integer id){
		Oferta ofertaSeleccionada = ofertaRepository.findOne(id);
		if(ofertaSeleccionada!=null){
			ofertaRepository.delete(ofertaSeleccionada);
			return new ResponseEntity<>(ofertaSeleccionada,HttpStatus.OK);
		}else{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@RequestMapping(value="ofertas/{code}",method=RequestMethod.DELETE)
	public ResponseEntity<Oferta>deleteOfertaCodigo(@PathVariable String code){
		Oferta ofertaSeleccionada = ofertaRepository.findByCode(code);
		if(ofertaSeleccionada!= null){
			ofertaRepository.delete(ofertaSeleccionada);
			return new ResponseEntity<>(ofertaSeleccionada,HttpStatus.OK);
			
		}else{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@RequestMapping(value="/ofertas/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Oferta>PutOferta (@PathVariable Integer id,@RequestBody Oferta ofertaModificada){
		Oferta oferta =  ofertaRepository.findOne(id);
		if((oferta!=null)&&(oferta.getId()==ofertaModificada.getId())){
			ofertaRepository.save(ofertaModificada);
			return new ResponseEntity<>(ofertaModificada,HttpStatus.OK);
		}else{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
	}
	@RequestMapping(value="/{code}",method= RequestMethod.PUT)
	public ResponseEntity<Oferta>PutOfertaCodigo(@PathVariable String code,@RequestBody Oferta ofertaModificada){
		Oferta oferta = ofertaRepository.findByCode(code);
		if((oferta!=null)&&(oferta.getId()==ofertaModificada.getId())){
			ofertaRepository.save(ofertaModificada);
			return new ResponseEntity<>(ofertaModificada,HttpStatus.OK);
		}else{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	

}
