package timeline.services;

import timeline.model.Empresa;
import timeline.persistence.EmpresaDao;
import timeline.persistence.EmpresaDaoJdbcImpl;
import timeline.persistence.PersistenceException;

public class EmpresaService {
	private static EmpresaService instance;
	
	public static EmpresaService getInstance(){
		if (instance == null) {
			instance = new EmpresaService();
		}
		return instance;
	}
	
	public Empresa buscarEmpresa(String email) throws PersistenceException{
		Empresa empresa = null;
		EmpresaDao empresaDao = EmpresaDaoJdbcImpl.getInstance();
		empresaDao.findByEmail(email);		
		return empresa;
		
	}
	/*public Empresa altaEmpresa(String email){
		Empresa empresa = null;
		EmpresaDao empresaDao = EmpresaDaoJdbcImpl.getInstance();
		empresaDao.insert(Empresa empresa);	
		return empresa;
		
	}*/
}

