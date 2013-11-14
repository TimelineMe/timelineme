package timeline.services;

/*import timeline.model.Empresa;
import timeline.persistence.EmpresaDao;
import timeline.persistence.EmpresaDaoJdbcImpl;
import timeline.persistence.PersistenceException;*/

public class EmpresaService {
	private static EmpresaService instance;
	
	public static EmpresaService getInstance(){
		if (instance == null) {
			instance = new EmpresaService();
		}
		return instance;
	}
	
/*	public Empresa insertarEmpresa(String email) throws PersistenceException{
		EmpresaDao empresaDao = EmpresaDaoJdbcImpl.getInstance();
		Empresa empresa = empresaDao.insert(empresa)
		return empresa;
		
	}*/
}

