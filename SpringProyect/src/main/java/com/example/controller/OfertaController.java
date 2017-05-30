package com.example.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

import com.example.entity.Oferta;
import com.example.entity.OfertaDescuento;
import com.example.entity.Resource;
import com.example.repository.OfertaDescuentoRepository;
import com.example.repository.OfertaRepository;





@Controller
public class OfertaController {
	
	@Autowired
	private OfertaRepository ofertaRepository;

	private static final String FILES_FOLDER = ".\\src\\main\\resources\\static\\imagenes";

	private List<String> imageTitles = new ArrayList<>();

	
	
	@PostConstruct
	public void init(){
		Oferta oferta1 = new Oferta (1,"2x1","1234","LLevate 2 y paga 1",2,1,"2x1.jpg");
		ofertaRepository.save(oferta1);
		Oferta oferta2 = new Oferta (2,"3x2","1233","LLevate 3 y paga 2",3,2,"3x2.jpg");
	
	}
	
	/*@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public String oferta (Model model ,@PathVariable Integer id){
	
	        Oferta oferta=  ofertaRepository.findOne(id);
	        model.addAttribute("oferta",oferta);
	        
	        return "ofertas";
	}*/
	/*
	//metodo para crear una oferta desde el form
	@RequestMapping("/nuevaOferta")
	public String nuevaOferta(Model model, Oferta oferta) {

		ofertaRepository.save(oferta);
		return "ofertas";
		
		}*/
	
	@RequestMapping(value="/nuevaOferta",  method = RequestMethod.POST)
	public String nuevoVinilo(Model model, Oferta oferta, @RequestParam("imageTitle") String imageTitle,
			@RequestParam("file") MultipartFile file) {
		String fileName = imageTitles.size() + ".jpg";
		if (!file.isEmpty()) {
			try {

				File filesFolder = new File(FILES_FOLDER);
				if (!filesFolder.exists()) {
					filesFolder.mkdirs();
				}

				File uploadedFile = new File(filesFolder.getAbsolutePath(), fileName);
				file.transferTo(uploadedFile);

				imageTitles.add(imageTitle);
				
				model.addAttribute("imageTitles", imageTitles);

				oferta.setImg(fileName);
				
				ofertaRepository.save(oferta);
				
				return "ofertas.html";

			} catch (Exception e) {
				
				model.addAttribute("fileName",fileName);
				model.addAttribute("error",
						e.getClass().getName() + ":" + e.getMessage());
				
				return "/";
			}
		} else {
			
			model.addAttribute("error",	"The file is empty");
			
			return "/";
			}
		}
	
	//metodo para borrar una oferta desde el form
	@RequestMapping("/borrarPromocion")
	public String borrarPromocion(Model model, Oferta oferta) {
		
		
		
		Oferta promocion = ofertaRepository.findByCode(oferta.getCode());
		ofertaRepository.delete(promocion);
		
		return "/ofertas.html";
		
		}
	
	
	
	
	/*@RequestMapping("/ofertas")
	public String verOfertas(Model model, @PathVariable long id) {
		
		Oferta oferta = ofertaRepository.findOne((int) id);

		model.addAttribute("oferta", oferta);

		return "ofertas";
	}*/
	
	
	
	

	

}
