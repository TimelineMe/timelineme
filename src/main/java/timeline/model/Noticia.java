package timeline.model;

public class Noticia {
	private Integer id_noticia;
	private String titulo;
	private String contenido;
	private Integer fecha;
	private Integer hora;
	private String autor;

	

	public Noticia(Integer id,String tit) {
	 this.setId(id);
	 this.setTitulo(tit);
	}

	public void setId(Integer id){
		this.id_noticia = id;
	}
	
	public Integer getId(){
		return this.id_noticia;
	}
	
	public void setTitulo(String titulo){
		this.titulo = titulo;
	}
	
	public String getTitulo(){
		return this.titulo;
	}
	
	public void setContenido(String cont){
		this.contenido = cont;
	}
	
	public String getContenido(){
		return this.contenido;
	}
	
	public void setFecha(Integer date){
		this.fecha = date;
	}
	
	public Integer getFecha(){
		return this.fecha;
	}
	
	public void setHora(Integer hora){
		this.hora = hora;
	}
	
	public Integer getHora(){
		return this.hora;
	}
	
	public void setAutor(String autor){
		this.autor = autor;
	}
	
	public String getAutor(){
		return this.autor;
	}
	
}
