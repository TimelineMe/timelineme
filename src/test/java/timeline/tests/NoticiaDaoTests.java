package timeline.tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import timeline.model.Noticia;
import timeline.persistence.DaoFactory;
import timeline.persistence.NoticiaDao;
import timeline.persistence.PersistenceException;

public class NoticiaDaoTests {
	
	NoticiaDao dao = DaoFactory.getNoticiaDao();
	
	
	Noticia tengosue�o = new Noticia(11,"tengosue�o","se me caen los ojos","2015-12-01 05:03:10","juanjoc@nuevaesponja.com.ar");
	
	@Before
	public void insersion() throws PersistenceException{
		dao.insert(tengosue�o);
	}
	@Test
	public void BuscarEstaNoticia() throws PersistenceException{
		Noticia noticia = dao.findByID(11);
		
		assertNotNull("La noticia con id 11 debe exisitir",noticia);
		assertEquals("titulo noticia 11: tengosue�o","tengosue�o",noticia.getTitulo());
	}
	@Test
	public void actualizar() throws PersistenceException{
		Noticia noticiaActual = dao.findByID(11);
		assertEquals("comprobemos que el titulo es tengosue�o","tengosue�o",noticiaActual.getTitulo());
		noticiaActual.setTitulo("ya descance");
		dao.update(noticiaActual);
		assertEquals("comprobamos que el titulo ahora es ya descance","ya descance",noticiaActual.getTitulo());
	}
	@After
	public void borrarEsaNoticia() throws PersistenceException{
	dao.delete(tengosue�o);	
	}
	
	
	@Test
	public void BuscarUnaNoticia() throws PersistenceException{
		Noticia noticia = dao.findByID(1);
		
		assertNotNull("La noticia con id 1 debe exisitir",noticia);
		assertEquals("titulo noticia 1: noticia 1","Noticia1",noticia.getTitulo());
	}
	
	
	
	@Test
	public void BuscarTodasLasNoticias() throws PersistenceException{
		List <Noticia> TodasLasNoticias = dao.findAll();
		assertEquals("tiene que haber 11 noticias en la BDD",11,TodasLasNoticias.size());
	}
	
	@Test
	public void BuscarLasNoticasdeUnAutor() throws PersistenceException{
		List <Noticia> TodasLasNoticias = dao.findbyAutor("leandroandres1@gmail.com");
		assertEquals("tiene que haber 5 noticias en la BDD",5,TodasLasNoticias.size());
	}
	
	@Test
	public void BuscarLasNoticasdeUnaEmpresa() throws PersistenceException{
		List <Noticia> TodasLasNoticias = dao.findbyEmpresa("prueba@prueba.com.ar");
		assertEquals("tiene que haber 3 noticias en la BDD",3,TodasLasNoticias.size());
	}
}
