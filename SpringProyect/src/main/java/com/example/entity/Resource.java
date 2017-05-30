package com.example.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Basic;





@Entity
public class Resource implements Comparable<Resource> {
	public interface Basic{}
	public interface comentarios{}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonView(Basic.class)
	private Integer id;
	
	@JsonView(Basic.class)
	private  String title;
	
	@JsonView(Basic.class)
	private  String subtitle;
	@JsonView(Basic.class)
	private String interprete;
	
	@JsonView(Basic.class)
	private String fecha;
	
	@JsonView(Basic.class)
	private String estado;
	
	@JsonView(Basic.class)
	private String album;
	
	@JsonView(Basic.class)
	private int precio;
	
	@JsonView(Basic.class)
	private int codigo;
	
	@JsonView(Basic.class)
	private String tracklist;
	
	@JsonView(Basic.class)
	private String img;
	
	@JsonView(Basic.class)
	private boolean visto;
	
	@JsonView(Basic.class)
	private int veces;
	
	
	@JsonView(Comment.class)
	@OneToMany(cascade=CascadeType.ALL)
	private List<Comment> comentarios;
	
	
	protected Resource(){
	}



	public Resource(String title, String subtitle, String interprete, String fecha, String estado, String album, int precio, int codigo, String tracklist, String img) {
		
		this.title = title;
		this.subtitle=subtitle;
		this.interprete = interprete;
		this.fecha = fecha;
		this.estado=estado;
		this.album = album;
		this.precio = precio;
		this.codigo = codigo;
		this.tracklist=tracklist;
		this.img = img;
		this.comentarios=new ArrayList<Comment>();
		this.visto = false;
		this.veces = 0;
		
	}
	
	@Override
    public int compareTo(Resource o) {
        if (precio < o.precio) {
            return 1;
        }
        if (precio > o.precio) {
            return -1;
        }
        return 0;
    }



	public String getSubtitle() {
		return subtitle;
	}



	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}



	public String getEstado() {
		return estado;
	}



	public void setEstado(String estado) {
		this.estado = estado;
	}



	public String getTracklist() {
		return tracklist;
	}



	public void setTracklist(String tracklist) {
		this.tracklist = tracklist;
	}

	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getInterprete() {
		return interprete;
	}



	public void setInterprete(String interprete) {
		this.interprete = interprete;
	}



	public String getFecha() {
		return fecha;
	}



	public void setFecha(String fecha) {
		this.fecha = fecha;
	}



	public String getAlbum() {
		return album;
	}



	public void setAlbum(String album) {
		this.album = album;
	}



	public int getPrecio() {
		return precio;
	}



	public void setPrecio(int precio) {
		this.precio = precio;
	}



	public int getCodigo() {
		return codigo;
	}



	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	


	public String getImg() {
		return img;
	}



	public void setImg(String img) {
		this.img = img;
	}



	public List<Comment> getComentarios() {
		return comentarios;
	}



	public void setComentarios(List<Comment> comentarios) {
		this.comentarios = comentarios;
	}



	public boolean getVisto() {
		return visto;
	}



	public void setVisto(boolean visto) {
		this.visto = visto;
	}



	public int getVeces() {
		return veces;
	}



	public void setVeces(int veces) {
		this.veces = veces;
	}
}
