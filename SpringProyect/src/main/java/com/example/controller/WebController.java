package com.example.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.entity.Comment;
import com.example.entity.Oferta;
import com.example.entity.OfertaDescuento;
import com.example.entity.PurchaseOrder;
import com.example.entity.Resource;
import com.example.entity.User;
import com.example.repository.OfertaDescuentoRepository;
import com.example.repository.OfertaRepository;
import com.example.repository.PurchaseOrderRepository;
import com.example.repository.ResourceRepository;
import com.example.repository.UserRepository;
import com.example.services.OfertaDescuentoService;
import com.example.services.OfertaService;
import com.example.services.PurchaseService;
import com.example.services.ResourceService;
import com.example.services.UserService;

@Controller
public class WebController {

	@Autowired
	private ResourceService repository;

	@Autowired

	private OfertaService ofertaRepository;

	@Autowired
	private OfertaDescuentoService ofertaDescuentoRepository;

	@Autowired
	private UserService userRepository;
	
	@Autowired
	private PurchaseService purchaseOrderRepository;
	
	int numPedidos = 1;

	@RequestMapping("/")
	public String index(Model model, HttpServletRequest request) {

		if (request.isUserInRole("ADMIN") || request.isUserInRole("USER")) {
			User loggedUser = userRepository.findByName(request.getUserPrincipal().getName());
			model.addAttribute("user", loggedUser);
			model.addAttribute("logged", true);
		} else
			model.addAttribute("unlogged", true);
		if (request.isUserInRole("ADMIN"))
			model.addAttribute("admin", true);
        
		Page<Resource> vinilos = repository.findAll(new PageRequest(0,12));
		model.addAttribute("vinilos",vinilos);
		
		return "index"; 
	}
	
	@RequestMapping("/michael")
	public String michael(Model model) {
		
		List<Resource> vinilosMichael = repository.findByInterprete("Michael Jackson");
		
		model.addAttribute("vinilosMichael",vinilosMichael);
		
		return "index"; 
	}
	@RequestMapping("/bob-marley")
	public String bob(Model model) {
		
		List<Resource> bob = repository.findByInterprete("Bob Marley");
		
		model.addAttribute("vinilosBob",bob);
		
		return "index"; 
	}
	@RequestMapping("/pink-floyd")
	public String pinkfloyd(Model model) {
		
		List<Resource> vinilosPink = repository.findByInterprete("Pink Floyd");
		
		model.addAttribute("vinilosFloyd",vinilosPink);
		
		return "index"; 
	}
	@RequestMapping("/the-who")
	public String thewho(Model model) {
		
		List<Resource> vinilosWho = repository.findByInterprete("The Who");
		
		model.addAttribute("vinilosWho",vinilosWho);
		
		return "index"; 
	}
	@RequestMapping("/george-michael")
	public String georgemichael(Model model) {
		
		List<Resource> vinilosGeorge = repository.findByInterprete("George Michael");
		
		model.addAttribute("vinilosGeorge",vinilosGeorge);
		
		return "index"; 
	}
	@RequestMapping("/alan")
	public String alan(Model model) {
		
		List<Resource> vinilosAlan = repository.findByInterprete("The Alan Parsons Project");
		
		model.addAttribute("vinilosAlan",vinilosAlan);
		
		return "index"; 
	}
	@RequestMapping("/fleetwood-mac")
	public String fleetwoodmac(Model model) {
		
		List<Resource> vinilosMac = repository.findByInterprete("Fleetwood Mac");
		
		model.addAttribute("vinilosMac",vinilosMac);
		
		return "index"; 
	}
	@RequestMapping("/prince")
	public String prince(Model model) {
		
		List<Resource> vinilosPrince = repository.findByInterprete("Prince & The Revolution");
		
		model.addAttribute("vinilosPrince",vinilosPrince);
		
		return "index"; 
	}
	@RequestMapping("/david-bowie")
	public String davidbowie(Model model) {
		
		List<Resource> vinilosDavid = repository.findByInterprete("David Bowie");
		
		model.addAttribute("vinilosDavid",vinilosDavid);
		
		return "index"; 
	}
	@RequestMapping("/dire-straits")
	public String direstraits(Model model) {
		
		List<Resource> vinilosDire = repository.findByInterprete("Dire Straits");
		
		model.addAttribute("vinilosDire",vinilosDire);
		
		return "index"; 
	}
	@RequestMapping("/genesis")
	public String genesis(Model model) {
		
		List<Resource> vinilosGenesis = repository.findByInterprete("Genesis");
		
		model.addAttribute("vinilosGenesis",vinilosGenesis);
		
		return "index"; 
	}
	@RequestMapping("/lionel-richie")
	public String lionelrichie(Model model) {
		
		List<Resource> vinilosRichie = repository.findByInterprete("Lionel Richie");
		
		model.addAttribute("vinilosRichie",vinilosRichie);
		
		return "index"; 
	}
	
	@RequestMapping("/nuevos")
	public String nuevos(Model model) {
		
		List<Resource> nuevos = repository.findByEstado("Nuevo");
		
		model.addAttribute("nuevos",nuevos);
		
		return "index"; 
	}
	@RequestMapping("/segunda-mano")
	public String segundaMano(Model model) {
		
		List<Resource> segundamano = repository.findByEstado("Segunda mano");
		
		model.addAttribute("segunda-mano",segundamano);
		
		return "index"; 
	}
	@RequestMapping("/Ofertas")
	public String ofertas(Model model,HttpServletRequest request){
		Page<OfertaDescuento> ofertaDescuento = ofertaDescuentoRepository.findAll(new PageRequest(0,8));
		Page<Oferta>ofertas = ofertaRepository.findAll(new PageRequest(0,8));
		model.addAttribute("ofertas",ofertas);
		model.addAttribute("ofertaDescuento",ofertaDescuento);
		return"ofertas";
		
		
	}
	@RequestMapping("/moreOfertasDescuento")
	public String moreOfertasDescuento(Model model ,@RequestParam int page){
		Page<OfertaDescuento> allOfertasDescuento = ofertaDescuentoRepository.findAll(new PageRequest(page,8));
		model.addAttribute("items", allOfertasDescuento);
		return"listItemsPage";
	}
	@RequestMapping("/moreOfertas")
	public String moreOfertas (Model model,@RequestParam int page){
		Page<Oferta> allOfertas = ofertaRepository.findAll(new PageRequest(page,8));
		model.addAttribute("items", allOfertas);
		return"listItemsPage";
	}
	
	// Metodo para añadir nuevos vinilos con el atributo index
	@RequestMapping(value="/moreVinilos")//--> devolver /
	public String moreVinilos(Model model ,@RequestParam int page){
		Page<Resource> allVinilos = repository.findAll(new PageRequest(page,12));
		model.addAttribute("items",allVinilos);
		
		return"listItemsPage";//listItemsPage
		
	}

	@RequestMapping("/{id}")
	public String verArticulo(Model model, HttpServletRequest request, @PathVariable int id) {

		if (request.isUserInRole("ADMIN") || request.isUserInRole("USER")) {
			User loggedUser = userRepository.findByName(request.getUserPrincipal().getName());
			model.addAttribute("user", loggedUser);
			model.addAttribute("logged", true);
		} else
			model.addAttribute("unlogged", true);
		if (request.isUserInRole("ADMIN"))
			model.addAttribute("admin", true);

		Resource vinilo = repository.findOne(id);
		List <Comment> listaComentarios = vinilo.getComentarios();
		
		vinilo.setVisto(true);
		int veces = vinilo.getVeces();
		vinilo.setVeces(++veces);
		
		repository.save(vinilo);
		
		model.addAttribute("vinilo", vinilo);
		model.addAttribute("comentarios",listaComentarios);

		return "articulo";
	}

	@RequestMapping("/{id}/addCarrito")
	public String addCarrito(HttpServletRequest request, @PathVariable int id, RedirectAttributes redirectAttrs) {
		
		if (request.isUserInRole("ADMIN") || request.isUserInRole("USER")) {
			
			

			User loggedUser = userRepository.findByName(request.getUserPrincipal().getName());
			Resource vinilo = repository.findOne(id);
			
			if (loggedUser.getCarrito().contains(vinilo)){
				 redirectAttrs.addFlashAttribute("error", "Este vinilo ya está añadido a tu carrito de compra");
					
				 return "redirect:/{id}";
				
			} else {
				
				List<Resource> carro = loggedUser.getCarrito();

				carro.add(vinilo);
				
				loggedUser.setCarrito(carro);
				
				
				int precioTotal = loggedUser.getPrecioCarrito();
				
				
				precioTotal = precioTotal + vinilo.getPrecio();
				
				
				loggedUser.setPrecioCarrito(precioTotal);

				userRepository.save(loggedUser);

				return "redirect:/carrito";
				
			}
			
	} else return "redirect:/login";
	}

	@RequestMapping("/addOrder")
	public String addOrder(HttpServletRequest request, RedirectAttributes redirectAttrs) {
		
		User loggedUser = userRepository.findByName(request.getUserPrincipal().getName());
		
		if (loggedUser.getCarrito().size()>0) {

		
			List<Resource> carrito = new ArrayList<>();
			
			carrito = loggedUser.getCarrito();
			
			List<String> array = new ArrayList<String>();

			for(Resource resource : carrito){
				String e = resource.getTitle().toString();
				array.add(e);
			}
			
			String orderDescription = String.join(" - ", array);
			
			++numPedidos;
			String numPed = Integer.toString(numPedidos);
			
			PurchaseOrder p = new PurchaseOrder(numPed,loggedUser.getPrecioCarrito(), orderDescription, carrito);
			purchaseOrderRepository.save(p);

			userRepository.save(loggedUser);

			return "redirect:/metodo-pago";

	} else {
		
		 redirectAttrs.addFlashAttribute("error", "No has añadido ningun producto al carrito de compra.");
			
		 return "redirect:/carrito";
	}
	}
	
	@RequestMapping("/login")
	public String inicioSesion(Model model, HttpServletRequest request) {

		if (request.isUserInRole("ADMIN") || request.isUserInRole("USER")) {
			User loggedUser = userRepository.findByName(request.getUserPrincipal().getName());
			model.addAttribute("user", loggedUser);
			model.addAttribute("logged", true);
		} else
			model.addAttribute("unlogged", true);
		if (request.isUserInRole("ADMIN"))
			model.addAttribute("admin", true);

		return "login";
	}

	@RequestMapping("/articulo")
	public String articulo(Model model, HttpServletRequest request) {

		if (request.isUserInRole("ADMIN") || request.isUserInRole("USER")) {
			User loggedUser = userRepository.findByName(request.getUserPrincipal().getName());
			model.addAttribute("user", loggedUser);
			model.addAttribute("logged", true);
		} else
			model.addAttribute("unlogged", true);
		if (request.isUserInRole("ADMIN"))
			model.addAttribute("admin", true);

		return ("articulo");
	}

	@RequestMapping("/carrito")
	public String carrito(Model model, HttpServletRequest request) {

		if (request.isUserInRole("ADMIN") || request.isUserInRole("USER")) {
			User loggedUser = userRepository.findByName(request.getUserPrincipal().getName());
			model.addAttribute("user", loggedUser);
			model.addAttribute("logged", true);
		} else
			model.addAttribute("unlogged", true);
		if (request.isUserInRole("ADMIN"))
			model.addAttribute("admin", true);

		User loggedUser = userRepository.findByName(request.getUserPrincipal().getName());
		
		List<Resource> productos = loggedUser.getCarrito();
		
		model.addAttribute("productos", productos);
		model.addAttribute("precioTotal", loggedUser.getPrecioCarrito());
		
		return ("carrito");
	}


	@RequestMapping("/metodo-pago")
	public String MetodoPago(Model model, HttpServletRequest request) {

		if (request.isUserInRole("ADMIN") || request.isUserInRole("USER")) {
			User loggedUser = userRepository.findByName(request.getUserPrincipal().getName());
			model.addAttribute("user", loggedUser);
			model.addAttribute("logged", true);
		} else
			model.addAttribute("unlogged", true);
		if (request.isUserInRole("ADMIN"))
			model.addAttribute("admin", true);

		return ("metodo-pago");
	}

	@RequestMapping("/miperfil")
	public String MiPerfil(Model model, HttpServletRequest request) {

		if (request.isUserInRole("ADMIN") || request.isUserInRole("USER")) {
			User loggedUser = userRepository.findByName(request.getUserPrincipal().getName());
			model.addAttribute("user", loggedUser);
			model.addAttribute("logged", true);
		} else
			model.addAttribute("unlogged", true);
		if (request.isUserInRole("ADMIN"))
			model.addAttribute("admin", true);

		return ("miperfil");
	}

	@RequestMapping("/ofertas")
	public String Ofertas(Model model, HttpServletRequest request) {

		if (request.isUserInRole("ADMIN") || request.isUserInRole("USER")) {
			User loggedUser = userRepository.findByName(request.getUserPrincipal().getName());
			model.addAttribute("user", loggedUser);
			model.addAttribute("logged", true);
		} else
			model.addAttribute("unlogged", true);
		if (request.isUserInRole("ADMIN"))
			model.addAttribute("admin", true);

		model.addAttribute("ofertas", ofertaRepository.findAll());
		model.addAttribute("ofertasDescuento", ofertaDescuentoRepository.findAll());
		return ("ofertas");
	}

	@RequestMapping("/administrador")
	public String Administrador(Model model, HttpServletRequest request) {

		if (request.isUserInRole("ADMIN") || request.isUserInRole("USER")) {
			User loggedUser = userRepository.findByName(request.getUserPrincipal().getName());
			model.addAttribute("user", loggedUser);
			model.addAttribute("logged", true);
		} else
			model.addAttribute("unlogged", true);
		if (request.isUserInRole("ADMIN"))
			model.addAttribute("admin", true);
		
		model.addAttribute("vinilos", repository.findAll());
		model.addAttribute("vinilosMas", repository.findByVisto(true));
		model.addAttribute("ofertas", ofertaRepository.findAll());
		model.addAttribute("ofertasDescuento", ofertaDescuentoRepository.findAll());
		model.addAttribute("users", userRepository.findAll());
		model.addAttribute("orders", purchaseOrderRepository.findAll());

		return ("administrador");
	}

	@RequestMapping("/registro")
	public String registro(Model model, HttpServletRequest request) {

		if (request.isUserInRole("ADMIN") || request.isUserInRole("USER")) {
			User loggedUser = userRepository.findByName(request.getUserPrincipal().getName());
			model.addAttribute("user", loggedUser);
			model.addAttribute("logged", true);
		} else
			model.addAttribute("unlogged", true);
		if (request.isUserInRole("ADMIN"))
			model.addAttribute("admin", true);

		return ("registro");

	}

	@RequestMapping("/somos")
	public String somos(Model model, HttpServletRequest request) {

		if (request.isUserInRole("ADMIN") || request.isUserInRole("USER")) {
			User loggedUser = userRepository.findByName(request.getUserPrincipal().getName());
			model.addAttribute("user", loggedUser);
			model.addAttribute("logged", true);
		} else
			model.addAttribute("unlogged", true);
		if (request.isUserInRole("ADMIN"))
			model.addAttribute("admin", true);

		return "somos";
	}

	@RequestMapping("/validaciondepedidos")
	public String validacion(Model model, HttpServletRequest request) {

		if (request.isUserInRole("ADMIN") || request.isUserInRole("USER")) {
			User loggedUser = userRepository.findByName(request.getUserPrincipal().getName());
			model.addAttribute("user", loggedUser);
			model.addAttribute("logged", true);
		} else
			model.addAttribute("unlogged", true);
		if (request.isUserInRole("ADMIN"))
			model.addAttribute("admin", true);
		
		model.addAttribute("orders", purchaseOrderRepository.findAll());
		
		return "validacion-pedidos";
	}
	
	@RequestMapping("/metododepago")
	public String metodoPago(Model model, HttpServletRequest request) {

		if (request.isUserInRole("ADMIN") || request.isUserInRole("USER")) {
			User loggedUser = userRepository.findByName(request.getUserPrincipal().getName());
			model.addAttribute("user", loggedUser);
			model.addAttribute("logged", true);
		} else
			model.addAttribute("unlogged", true);
		if (request.isUserInRole("ADMIN"))
			model.addAttribute("admin", true);

		return "metodo-pago";
	}

	@RequestMapping("/deleteUser")
	public String BorrarUser(HttpServletRequest request) {

		User loggedUser = userRepository.findByName(request.getUserPrincipal().getName());
		userRepository.delete(loggedUser.getId());

		return "login";

	}
	
	@RequestMapping( value = "/{id}/addComment", method = RequestMethod.POST)
	public String addComment(HttpServletRequest request, @PathVariable int id, @RequestParam String message, @RequestParam String asunto) {

		if (request.isUserInRole("ADMIN") || request.isUserInRole("USER")) {

			
			Resource vinilo = repository.findOne(id);
			
			Comment com = new Comment(message, asunto);

			vinilo.getComentarios().add(com);


			repository.save(vinilo);

			return "redirect:/{id}";

		} else
			return "redirect:/login";
	}
	
	@RequestMapping("/aplicarCodigo")
	public String AplicarCodigo(Model model, HttpServletRequest request, @RequestParam String code,
			RedirectAttributes redirectAttrs) {
		
		
		User loggedUser = userRepository.findByName(request.getUserPrincipal().getName());
		
		if (loggedUser.getCarrito().size()==0){
			
			redirectAttrs.addFlashAttribute("error", "El carrito está vacio. No pueden aplicarse códigos promocionales.");
			
			return "redirect:/carrito";
			
		} else { //si el carrito no está vacío:
			
			
			if (code == null) {
				//si no has introducido ningun codigo:
				redirectAttrs.addFlashAttribute("error", "No has introducido ningún código promocional");
				
				return "redirect:/carrito";
				
			} else { //si si has introducido algun código
				
				Oferta oferta = ofertaRepository.findByCode(code);
				OfertaDescuento ofertaDescuento = ofertaDescuentoRepository.findByCode(code);
				
				if ((oferta == null) && (ofertaDescuento == null)) {
					
					redirectAttrs.addFlashAttribute("error", "El código introducido no existe.");
					
					return "redirect:/carrito";
					
				} else { //si el cdigo es de oferta descuento:
					
					if (oferta == null) {
						
						 int precioinicial = loggedUser.getPrecioCarrito();
						 
						 precioinicial = precioinicial - ofertaDescuento.getPorcentaje();
							 
						 loggedUser.setPrecioCarrito(precioinicial);
							 
						 userRepository.save(loggedUser);
							
						 redirectAttrs.addFlashAttribute("messages", "Descuento aplicado");
							
						 return "redirect:/carrito";
						
					} else { //si el codigo es de oferta:
						
						List <Resource> carro = loggedUser.getCarrito();
						
						//ordenar el array
						
						 Collections.sort(carro);   
						 
						 int pago = oferta.getPagas();
						 int llevo = oferta.getLlevas();
						 
						 if (llevo == loggedUser.getCarrito().size()) {
							 //aplicar
							 
							 int dinero = 0;
							 
						
							 int cont = 0;
							 
							 while (cont<pago){
								 
								 dinero=dinero+carro.get(cont).getPrecio();
								 cont=cont+1;
							 }
							 
							 
							 
							 loggedUser.setPrecioCarrito(dinero);
							 
							 userRepository.save(loggedUser);
							 
							 redirectAttrs.addFlashAttribute("messages", "Código descuento aplicado.");
								
							 return "redirect:/carrito";
							 
							 
						 }
						 
						 else { //no aplicable
							 
							 redirectAttrs.addFlashAttribute("error", "El código solo es aplicable para un número de productos en carrito.");
								
							 return "redirect:/carrito";
							 
							 
						 }
						
						
						
						
						
						
						
					}
				}
				
			}
		}
		
	}
	
	@RequestMapping("/borrarCarrito")
	public String BorrarCarrito(Model model, HttpServletRequest request, @RequestParam String title,
			RedirectAttributes redirectAttrs) {
		
		User loggedUser = userRepository.findByName(request.getUserPrincipal().getName());
		
		Resource vinilo = repository.findByTitle(title);
		
		loggedUser.getCarrito().remove(vinilo);
		
		userRepository.save(loggedUser);

		
		 redirectAttrs.addFlashAttribute("messages", "Articulo eliminado del carrito de compra.");
			
		 return "redirect:/carrito";
		
		
		
	}
	
	@RequestMapping("/loginError")
	public String loginError(Model model){
		model.addAttribute("loginError",true);
		
		return"login";
	}
	
	
	

}