package timeline.services;

import timeline.model.Agente;
import timeline.persistence.AgenteDao;
import timeline.persistence.AgenteDaoJdbcImpl;
import timeline.persistence.PersistenceException;

public class AgenteService {
	private static AgenteService instance;
	
	public static AgenteService getInstance(){
		if (instance == null) {
			instance = new AgenteService();
		}
		return instance;
	}
	
	
	public Agente buscarAgente(String email) throws PersistenceException{
		
		Agente agente = null;
		AgenteDao agenteDao = AgenteDaoJdbcImpl.getInstance();
		agenteDao.findByEmail(email);
			
		return agente;
	}
	
}

