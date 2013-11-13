package timeline.services;

import timeline.model.Empresa;
import timeline.persistence.EmpresaDao;
import timeline.persistence.EmpresaDaoJdbcImpl;
import timeline.persistence.PersistenceException;

public class LoginService {
	private static LoginService instance;
	
	public static LoginService getInstance(){
		if (instance == null) {
			instance = new LoginService();
		}
		return instance;
	}
	
	public Boolean validar(String email, String password){
		return email.equals(password);
		/*EmpresaDao empresaDao = EmpresaDaoJdbcImpl.getInstance();
		Empresa miEmpresa = empresaDao.findByEmail(email);
		return password.equals(miEmpresa.getPassword());*/
	}
}

