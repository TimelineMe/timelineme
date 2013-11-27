package timeline.services;

import java.text.SimpleDateFormat;
import java.util.Date;
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
	public List<Noticia> findbyAutor(String emailAutor) throws PersistenceException {
		NoticiaDao autorDao = DaoFactory.getNoticiaDao();
		return autorDao.findbyAutor(emailAutor);
	}
	public Noticia findbyID(Integer id) throws PersistenceException {
		NoticiaDao noticiaDao = DaoFactory.getNoticiaDao();
		return noticiaDao.findByID(id);
	}
	public List<Noticia> findAll() throws PersistenceException {
		NoticiaDao noticiasDao = DaoFactory.getNoticiaDao();
		return noticiasDao.findAll();
	}
	public void insertarNoticia(String titulo, String contenido, String autor) throws PersistenceException {
		NoticiaDao noticiaDao = DaoFactory.getNoticiaDao();
		//genero una instancia del servicio de noticias
		NoticiaService noticiaSvc = new NoticiaService();
		//traigo todas las noticias
		List <Noticia> noticias = noticiaSvc.findAll();
		//calculo el id agregando incrementando de a uno
		Integer id = (noticias.size())+1;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:MM:SS");
		String fecha = sdf.format(new Date());
		
		Noticia noticia = new Noticia(id, titulo, contenido, fecha, autor);
		noticiaDao.insert(noticia);
	}
}

