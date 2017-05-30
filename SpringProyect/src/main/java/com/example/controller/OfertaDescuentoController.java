package com.example.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.entity.Oferta;
import com.example.entity.OfertaDescuento;
import com.example.repository.OfertaDescuentoRepository;

@Controller
public class OfertaDescuentoController {
	
	@Autowired
	private OfertaDescuentoRepository ofertaDescuentoRepository;

	private static final String FILES_FOLDER = ".\\src\\main\\resources\\static\\imagenes";

	private List<String> imageTitles = new ArrayList<>();
	
	@PostConstruct
	public void init(){
		OfertaDescuento ofertadescuento1 = new OfertaDescuento ("Descuento 10 euros","1111","Ahorrate 10 euros en tu carrito de compra",10,"10.png");
		ofertaDescuentoRepository.save(ofertadescuento1);
		
	}
	
	/*
	 * Sin comentar da error, hay que revisarlo cuando se necesite
	 * 
	 * @RequestMapping(value="/{id}",method = RequestMethod.GET)
	public String ofertaDescuento (Model model ,@PathVariable Integer id){
	
	        OfertaDescuento ofertaDescuento=  ofertaDescuentoRepository.findOne(id);
	        model.addAttribute("ofertaDescuento",ofertaDescuento);
	        
	        return "ofertaDescuento";
	}*/
	
		@RequestMapping(value="/nuevaOfertaDescuento",  method = RequestMethod.POST)
		public String nuevoVinilo(Model model, OfertaDescuento oferta, @RequestParam("imageTitle") String imageTitle,
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
					
					ofertaDescuentoRepository.save(oferta);
					
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
		
		//metodo para borrar una oferta descuento desde el form
		@RequestMapping("/borrarPromocionDescuento")
		public String borrarPromocion(Model model, OfertaDescuento oferta) {
			
			OfertaDescuento promociondescuento = ofertaDescuentoRepository.findByCode(oferta.getCode());
			ofertaDescuentoRepository.delete(promociondescuento);
			
			return "/ofertas.html";
			
			}
}
