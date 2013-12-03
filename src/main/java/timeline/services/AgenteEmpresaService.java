package timeline.services;

import java.util.LinkedList;
import java.util.List;

import timeline.model.Agente;
import timeline.model.AgenteEmpresa;
import timeline.model.Empresa;
import timeline.model.Noticia;
import timeline.persistence.AgenteEmpresaDao;
import timeline.persistence.DaoFactory;
import timeline.persistence.EmpresaDao;
import timeline.persistence.PersistenceException;

public class AgenteEmpresaService {
	private static AgenteEmpresaService instance;
	
	public static AgenteEmpresaService getInstance(){
		if (instance == null) {
			instance = new AgenteEmpresaService();
		}
		return instance;
	}
	
	
	public List<Noticia> findNoticiasByAgente(String emailAgente) throws PersistenceException {
		
		EmpresaDao empresaDao = DaoFactory.getEmpresaDao();
		
		//traigo la lista de empresas que sigue el agente
		List <Empresa> empresasSeguidas = new LinkedList<Empresa>();
		empresasSeguidas = empresaDao.findEmpresasSeguidasByAgente(emailAgente);
		
		//traigo la lista de agentes de todas las empresas seguidas
		AgenteService agenteSvc = new AgenteService();
		List <Agente> agentes = new LinkedList<Agente>();
		for(Empresa unaEmpresa: empresasSeguidas){
			//recorro la lista para cada agente
			for (Agente unAgente: agenteSvc.findByEmpresa(unaEmpresa.getEmail())){
			agentes.add(unAgente);
			}
		}
		//traigo todas las noticias publicadas por los agentes de las empresas seguidas
		NoticiaService noticiaSvc = new NoticiaService();
		List <Noticia> noticias = new LinkedList<Noticia>();
		for(Agente unAgente: agentes){
			for (Noticia unaNoticia: noticiaSvc.findbyAutor(unAgente.getEmail_Agente())){
			noticias.add(unaNoticia);
			}
		}
		return noticias;
	}
	public void seguirEmpresa(String emailEmpresa, String emailAgente) throws PersistenceException {
		AgenteEmpresa seguirEmpresa = new AgenteEmpresa(emailEmpresa, emailAgente);
		AgenteEmpresaDao agenteEmpresaDao = DaoFactory.getAgenteEmpresaDao();
		agenteEmpresaDao.insert(seguirEmpresa);
	}
	
	public void dejarSeguirEmpresa(String emailEmpresa, String emailAgente) throws PersistenceException {
		AgenteEmpresa dejarEmpresa = new AgenteEmpresa(emailEmpresa, emailAgente);
		AgenteEmpresaDao agenteEmpresaDao = DaoFactory.getAgenteEmpresaDao();
		agenteEmpresaDao.delete(dejarEmpresa);
	}
}

