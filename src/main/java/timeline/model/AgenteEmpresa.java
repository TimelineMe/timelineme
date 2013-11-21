package timeline.model;

public class AgenteEmpresa {
	private String sigue_Empresa;
	private String agente;
	
	public AgenteEmpresa(String sigue_Empresa, String agente) {
		this.setSigue_Empresa(sigue_Empresa);
		this.setAgente(agente);
		
	}
	public void setSigue_Empresa(String empresa){
		this.sigue_Empresa = empresa;
	}
	
	public String getSigue_Empresa(){
		return this.sigue_Empresa;
	}
	
	public void setAgente(String agente){
		this.agente = agente;
	}
	public String getAgente(){
		return this.agente;
	}

}
