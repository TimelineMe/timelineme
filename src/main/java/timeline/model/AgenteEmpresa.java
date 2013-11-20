package timeline.model;

public class AgenteEmpresa {
	private String empresa;
	private String agente;
	
	public AgenteEmpresa(String empresa, String agente) {
		this.setEmpresa(empresa);
		this.setAgente(agente);
		
	}
	public void setEmpresa(String empresa){
		this.empresa = empresa;
	}
	
	public String getEmpresa(){
		return this.empresa;
	}
	
	public void setAgente(String agente){
		this.agente = agente;
	}
	public String getAgente(){
		return this.agente;
	}

}
