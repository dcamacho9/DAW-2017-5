package com.example.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.example.entity.Resource;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Basic;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
public class User {
	public interface Roles{}
	public interface Carrito{}
	public interface LoginInt{}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonView(Basic.class)
	private Integer id;
	
	@JsonView(Basic.class)
	private String name;
	
	@JsonView(Basic.class)
	private String surname;
	
	@JsonView(Basic.class)
	private String email;
	
	@JsonView(Basic.class)
	private String pais;
	
	@JsonView(Basic.class)
	private String descripcion;
	
	@JsonView(Basic.class)
	private String telephone;
	
	@JsonView(Basic.class)
	private String passwordHash;
	
	@JsonView(Basic.class)
	private int postalCode;
	
	@JsonView({Basic.class,LoginInt.class})
	private int avaiableLoans;
	
	@JsonView(Basic.class)
	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> roles;
	
	
	@JsonView(Resource.class)
	@OneToMany(cascade = CascadeType.ALL)
	private List<Resource> carrito;
	
	@JsonView(Basic.class)
	private int precioCarrito;
	
	
	
	protected User(){}
	
		


	public User(String name, String surname, String email, String pais, String descripcion, String telephone, String password,
			int postalCode, String... roles) {
		
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.pais = pais;
		this.descripcion = descripcion;
		this.telephone = telephone;
		this.passwordHash = new BCryptPasswordEncoder().encode(password);
		this.postalCode = postalCode;
		this.roles = new ArrayList <> (Arrays.asList(roles));
		this.carrito = new ArrayList<Resource>();
		this.precioCarrito = 0;
		
	}

	

	public String getPasswordHash() {
		return passwordHash;
	}




	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}




	public List<String> getRoles() {
		return roles;
	}




	public void setRoles(List<String> roles) {
		this.roles = roles;
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


	public String getSurname() {
		return surname;
	}


	public void setSurname(String username) {
		this.surname = username;
	}


	


	public int getPostalCode() {
		return postalCode;
	}


	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getPais() {
		return pais;
	}




	public void setPais(String pais) {
		this.pais = pais;
	}




	public String getDescripcion() {
		return descripcion;
	}




	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}




	public String getTelephone() {
		return telephone;
	}




	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}




	public List<Resource> getCarrito() {
		return carrito;
	}




	public void setCarrito(List<Resource> carrito) {
		this.carrito = carrito;
	}




	public int getPrecioCarrito() {
		return precioCarrito;
	}




	public void setPrecioCarrito(int precioTotal) {
		this.precioCarrito = precioTotal;
	}




	public int getAvaiableLoans() {
		return avaiableLoans;
	}




	public void setAvaiableCredits(int avaiableLoans) {
		this.avaiableLoans = avaiableLoans;
	}
	


	

}
