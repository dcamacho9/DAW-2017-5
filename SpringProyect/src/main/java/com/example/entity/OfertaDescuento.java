package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Basic;

@Entity
public class OfertaDescuento {
	
	public interface Basic{};
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonView(Basic.class)
	private Integer id;
	
	@JsonView(Basic.class)
	private  String name;
	
	@JsonView(Basic.class)
	private String code;
	
	@JsonView(Basic.class)
	private String description;
	
	@JsonView(Basic.class)
	private int porcentaje;
	
	@JsonView(Basic.class)
	private String img;
	
	
	protected OfertaDescuento(){
		
	}
	


	public OfertaDescuento(String name, String code, String description, int porcentaje, String img) {
		
		this.name = name;
		this.code = code;
		this.description = description;
		this.porcentaje=porcentaje;
		this.setImg(img);
		
	}
	



	



	public int getPorcentaje() {
		return porcentaje;
	}



	public void setPorcentaje(int porcentaje) {
		this.porcentaje = porcentaje;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}



	public String getImg() {
		return img;
	}



	public void setImg(String img) {
		this.img = img;
	}
	
	
	
	
	
	

}

