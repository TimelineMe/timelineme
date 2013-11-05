package timeline.persistence;

import java.util.List;

import timeline.model.Noticia;

public interface NoticiaDao {
	
	public void insert(Noticia noticia) throws PersistenceException;

	public void delete(Noticia noticia) throws PersistenceException;
	
	public void update(Noticia noticia) throws PersistenceException;
	
	public Noticia findByID(Integer id_noticia) throws PersistenceException;
	
	public List<Noticia> findAll() throws PersistenceException;
}
