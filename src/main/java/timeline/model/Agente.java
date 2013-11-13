package timeline.model;

public class Agente {

	
	private String nombre_Agente;
	private String password;
	private String email_Agente;
	private String cargo;
	private String descripcion;
	private String foto;
	private String empresa;
	
	
	public Agente(String email_Agente, String nombre_Agente) {
		this.email_Agente = email_Agente;
		this.nombre_Agente = nombre_Agente;
	}
	
	public String getNombre() {
		return nombre_Agente;
	}
	public void setNombre(String nombre_Agente) {
		this.nombre_Agente = nombre_Agente;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public String getEmail_Agente() {
		return email_Agente;
	}
	public void setEmail_Agente(String email_Agente) {
		this.email_Agente = email_Agente;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
