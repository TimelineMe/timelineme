package timeline.services;

import java.util.List;

import timeline.model.Agente;
import timeline.persistence.AgenteDao;
import timeline.persistence.DaoFactory;
import timeline.persistence.PersistenceException;

public class AgenteService {
	private static AgenteService instance;
	
	public static AgenteService getInstance(){
		if (instance == null) {
			instance = new AgenteService();
		}
		return instance;
	}
	
	
	public Agente findByEmail(String email) throws PersistenceException {
		AgenteDao miAgenteDao = DaoFactory.getAgenteDao();
		return miAgenteDao.findByEmail(email);
	}
	
	public List<Agente> findByEmpresa(String email) throws PersistenceException {
		AgenteDao miAgenteDao = DaoFactory.getAgenteDao();
		return miAgenteDao.findByEmpresa(email);
	}
	
	public List<Agente> findSeguidoresByEmpresa(String emailEmpresa) throws PersistenceException {
		AgenteDao miAgenteDao = DaoFactory.getAgenteDao();
		return miAgenteDao.findSeguidoresByEmpresa(emailEmpresa);
	}
}

