package timeline.model;

public class Empresa {

	private String email;
	private String password;
	private String logo;
	private String razon_Social;
	private String sitio_Web;
	private String direccion;
	private Integer telefono;
	
	public Empresa(String email,String password, String razon_Social, String sitio_Web,String direccion,Integer telefono) {
		this.setEmail(email);
		this.setPassword(password);
		this.setRazon_Social(razon_Social);
		this.setSitio_Web(sitio_Web);
		this.setDireccion(direccion);
		this.setTelefono(telefono);
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getRazon_Social() {
		return razon_Social;
	}

	public void setRazon_Social(String razon_Social) {
		this.razon_Social = razon_Social;
	}

	public String getSitio_Web() {
		return sitio_Web;
	}

	public void setSitio_Web(String sitio_Web) {
		this.sitio_Web = sitio_Web;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
}
