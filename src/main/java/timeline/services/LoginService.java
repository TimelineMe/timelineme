package timeline.services;

import timeline.model.Agente;
import timeline.persistence.AgenteDao;
import timeline.persistence.AgenteDaoJdbcImpl;
import timeline.persistence.PersistenceException;

public class LoginService {
	private static LoginService instance;

	public static LoginService getInstance() {
		if (instance == null) {
			instance = new LoginService();
		}
		return instance;
	}

	public Agente findByEmail(String email) throws PersistenceException {
		AgenteService agenteSvc = new AgenteService();
		return agenteSvc.findByEmail(email);

	}

	public Boolean validar(String email, String password)
			throws PersistenceException {
		AgenteDao agenteDao = AgenteDaoJdbcImpl.getInstance();
		Agente miAgente = agenteDao.findByEmail(email);// trae un agente que
														// coincide con el email
														// pasado por parametro
		if (agenteDao.findByEmail(email) == null) {
			return false;
		} else {
			return password.equals(miAgente.getPassword());
		}
	}

}
