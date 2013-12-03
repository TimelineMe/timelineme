package timeline.services;

import timeline.model.AgenteEmpresa;
import timeline.persistence.AgenteEmpresaDao;
import timeline.persistence.DaoFactory;
import timeline.persistence.PersistenceException;

public class AgenteEmpresaService {
	private static AgenteEmpresaService instance;
	
	public static AgenteEmpresaService getInstance(){
		if (instance == null) {
			instance = new AgenteEmpresaService();
		}
		return instance;
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

