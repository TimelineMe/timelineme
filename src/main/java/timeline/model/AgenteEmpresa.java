package timeline.model;

public class AgenteEmpresa {
	private String empresa;
	private String agente;
	
	public AgenteEmpresa(String agente, String empresa) {
		this.setDirAgente(agente);
		this.setDirEmpresa(empresa);
		
	}
	public void setDirEmpresa(String empresa){
		this.empresa = empresa;
	}
	
	public String getDirEmpresa(){
		return this.empresa;
	}
	
	public void setDirAgente(String agente){
		this.agente = agente;
	}
	public String getDirAgente(){
		return this.agente;
	}

}
