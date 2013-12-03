package timeline.services;

import java.util.List;

import timeline.model.Empresa;
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
	public List<Empresa> findEmpresasQueSigoByPalabra(String emailAgente, String palabra) throws PersistenceException {
		EmpresaDao empresasDao = DaoFactory.getEmpresaDao();
		return empresasDao.findEmpresasSeguidasByPalabra(emailAgente, palabra);
	}
	public List<Empresa> findEmpresasQueNoSigoByPalabra(String emailAgente, String palabra) throws PersistenceException {
		EmpresaDao empresasDao = DaoFactory.getEmpresaDao();
		return empresasDao.findEmpresasNoSeguidasByPalabra(emailAgente, palabra);
	}
	
	public List<Empresa> findEmpresasSeguidasByAgente(String emailAgente) throws PersistenceException {
		EmpresaDao empresaDao = DaoFactory.getEmpresaDao();
		return empresaDao.findEmpresasSeguidasByAgente(emailAgente);
	}
	public List<Empresa> findEmpresasQueNoSigo (String emailAgente) throws PersistenceException {
		EmpresaDao empresaDao = DaoFactory.getEmpresaDao();
		return empresaDao.findEmpresasNoSeguidas(emailAgente);
	}
}

