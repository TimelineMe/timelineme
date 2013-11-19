package timeline.services;

import java.util.List;

import timeline.model.Noticia;
import timeline.persistence.DaoFactory;
import timeline.persistence.NoticiaDao;
import timeline.persistence.PersistenceException;

public class NoticiaService {
	private static NoticiaService instance;
	
	public static NoticiaService getInstance(){
		if (instance == null) {
			instance = new NoticiaService();
		}
		return instance;
	}
	public List<Noticia> findbyEmpresa(String emailEmpresa) throws PersistenceException {
		NoticiaDao empresasDao = DaoFactory.getNoticiaDao();
		return empresasDao.findbyEmpresa(emailEmpresa);
	}
	
}

