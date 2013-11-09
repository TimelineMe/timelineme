package timeline.services;

import timeline.model.Agente;
import timeline.persistence.AgenteDao;

public class LoginService {
	private static LoginService instance;
	
	public static LoginService getInstance(){
		if (instance == null) {
			instance = new LoginService();
		}
		return instance;
	}
	/*public Boolean authenticate(String username, String password) {
		AgenteDao agenteDao = DAOLocator.getInstance().getAgenteDao();
		
		Agente miAgente = agenteDao.findById(username);
		return password.equals(miAgente.getPassword());
	}*/
}

