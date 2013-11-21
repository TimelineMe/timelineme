package timeline.services;

import timeline.model.Agente;
import timeline.persistence.AgenteDao;
import timeline.persistence.AgenteDaoJdbcImpl;
import timeline.persistence.PersistenceException;

public class LoginService {
	private static LoginService instance;
	
	public static LoginService getInstance(){
		if (instance == null) {
			instance = new LoginService();
		}
		return instance;
	}
	
	/*public Boolean validar(String email, String password) throws PersistenceException {
		Agente agenteActual = findByEmail(email);
		return agenteActual.getEmail_Agente().equals(email) && agenteActual.getPassword().equals(password);
	}*/
	
	public Agente findByEmail(String email) throws PersistenceException{
		AgenteService agenteSvc = new AgenteService();
		return agenteSvc.findByEmail(email);
		
	}
	
	public Boolean validar(String email, String password) throws PersistenceException{
		AgenteDao agenteDao = AgenteDaoJdbcImpl.getInstance();
		Agente miAgente = agenteDao.findByEmail(email);
		if (agenteDao.findByEmail(email)==null){
			return false;
		}
		else {
			return password.equals(miAgente.getPassword());
		}
	}
	
}

