package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.entity.PurchaseOrder;
import com.example.entity.Resource;
import com.example.repository.PurchaseOrderRepository;

@Controller
public class PurchaseOrderController {
	@Autowired 
	private PurchaseOrderRepository purchaseOrderRepository;
	
	@PostConstruct
	public void init(){
		// Pedido de prueba
		Resource re1 = new Resource ("Tango in the Night", "Lo mejor del mejor","Fleetwood Mac","2008","Nuevo", "King of Pop",23,0006, "vfd", "img23.jpg");
		Resource re2 = new Resource ("Making love out of nothing at all", "Lo mejor del mejor","Air Suply","2008","Nuevo", "King of Pop",23,0006, "vfd", "img30.jpg");
		
		List<Resource> carrito = new ArrayList<>();
		carrito.add(re1);
		carrito.add(re2);
		
		PurchaseOrder po1 = new PurchaseOrder("1", 45.67, "Let it be y Tango in the Night", carrito);
		purchaseOrderRepository.save(po1);
	}
	
	//metodo para borrar un pedido
	@RequestMapping("/borrarPedido")
	public String borrarPedido(Model model, PurchaseOrder order) {

		purchaseOrderRepository.delete(order);
		return "/administrador.html";
		
		}

}
