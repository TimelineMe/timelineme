package timeline.services;

import java.util.List;

import timeline.model.Empresa;
import timeline.persistence.AgenteEmpresaDao;
import timeline.persistence.DaoFactory;
import timeline.persistence.EmpresaDao;
import timeline.persistence.PersistenceException;

public class EmpresaService {
	private static EmpresaService instance;
	
	public static EmpresaService getInstance(){
		if (instance == null) {
			instance = new EmpresaService();
		}
		return instance;
	}
	public List<Empresa> findAllEmpresas() throws PersistenceException {
		EmpresaDao empresasDao = DaoFactory.getEmpresaDao();
		return empresasDao.findAll();
	}
	
	public Empresa findByEmail(String email) throws PersistenceException {
		EmpresaDao miEmpresaDao = DaoFactory.getEmpresaDao();
		return miEmpresaDao.findByEmail(email);
	}
	public List<Empresa> findEmpresasByPalabra(String razon_Social) throws PersistenceException {
		EmpresaDao empresasDao = DaoFactory.getEmpresaDao();
		return empresasDao.findEmpresaByPalabra(razon_Social);
	}
	
	public List<Empresa> findEmpresasSeguidasByAgente(String emailAgente) throws PersistenceException {
		EmpresaDao empresaDao = DaoFactory.getEmpresaDao();
		return empresaDao.findEmpresasSeguidasByAgente(emailAgente);
	}
}

