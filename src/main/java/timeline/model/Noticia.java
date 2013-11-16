package timeline.model;


public class Noticia {
	private Integer id_noticia;
	private String titulo;
	private String contenido;
	private String fecha_Hora;
	private String autor;

	

	public Noticia(Integer id_noticia,String titulo,String contenido,String fecha_Hora, String autor) {
	 this.setId(id_noticia); 
	 this.setTitulo(titulo);
	 this.setContenido(contenido);
	 this.setFecha(fecha_Hora);
	 this.setAutor(autor);
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
	
	public void setFecha(String fecha_Hora){
		this.fecha_Hora = fecha_Hora;
	}
	
	public String getFecha(){
		return this.fecha_Hora;
	}
	
	public void setAutor(String autor){
		this.autor = autor;
	}
	
	public String getAutor(){
		return this.autor;
	}
	
}
