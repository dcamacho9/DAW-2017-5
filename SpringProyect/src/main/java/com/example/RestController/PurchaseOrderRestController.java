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

import com.example.entity.PurchaseOrder;

import com.example.entity.Resource;
import com.example.repository.ResourceRepository;
import com.example.services.PurchaseService;
import com.example.services.ResourceService;

@RestController
@RequestMapping("/api/purchaseOrder")
public class PurchaseOrderRestController {
	
	public interface purchaseOrderDetail extends PurchaseOrder.Basic,Resource.Basic{}
	
	@Autowired 
	
    private PurchaseService purchaseService;
	
	@RequestMapping(value="/",method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public PurchaseOrder postResource(@RequestBody PurchaseOrder purchase){
		
		purchaseService.save(purchase);
		return purchase;
		
		
	}
	
	
	@RequestMapping(value="/{code}",method= RequestMethod.GET)
	public ResponseEntity<PurchaseOrder> getResource (@PathVariable String code){
		PurchaseOrder p = purchaseService.findByCode(code);
		if(p!= null){
			return new ResponseEntity<>(p,HttpStatus.OK);
			
		}else{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	

	

	
	
	@RequestMapping(value="/purchase/{code}",method = RequestMethod.DELETE)
	public ResponseEntity<PurchaseOrder>deleteResource(@PathVariable String code){
		PurchaseOrder resource = purchaseService.findByCode(code);
		if(resource!= null){
			purchaseService.delete(resource);
			return new ResponseEntity<>(resource,HttpStatus.OK);
		}else{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@RequestMapping(value="/{code}", method = RequestMethod.PUT)
	public ResponseEntity<PurchaseOrder> putResource(@PathVariable String code,@RequestBody PurchaseOrder resourceModificado){
		PurchaseOrder resource = purchaseService.findByCode(code);
		if((resource!= null)&&(resource.getCode()== resourceModificado.getCode())){
			purchaseService.save(resource);
			return new ResponseEntity<>(resourceModificado,HttpStatus.OK);
		}else{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	
	

}
