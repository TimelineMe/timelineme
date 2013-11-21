package timeline.services;

import java.util.List;

import timeline.model.AgenteEmpresa;
import timeline.model.Empresa;
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
	public List<AgenteEmpresa> findByAgente(String emailAgente) throws PersistenceException {
		AgenteEmpresaDao AEDao = DaoFactory.getAgenteEmpresaDao();
		return AEDao.findByAgente(emailAgente);
	}
	public List<Empresa> findByAgente2(String emailAgente) throws PersistenceException {
		AgenteEmpresaDao empresaDao = DaoFactory.getAgenteEmpresaDao();
		return empresaDao.findByAgente2(emailAgente);
	}
	
}

