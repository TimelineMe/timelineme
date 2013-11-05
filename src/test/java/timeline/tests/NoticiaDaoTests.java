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
	
	Noticia PerroMuerto = new Noticia(1,"Perro muere atropellado");
	Noticia LadronCapturado = new Noticia(2,"Ladron profugo recapturado");
	
	@Before
	public void setUp() throws PersistenceException {
		//borramos todas las noticias para iniciar con la BDD vacia
		for(Noticia cadaUna:dao.findAll()){//trae la lista completa
			dao.delete(cadaUna); //va borrando a cada noticia
		}
		
		dao.insert(PerroMuerto);
		dao.insert(LadronCapturado);
	}
	
	@After
	public void tearDown() throws PersistenceException{
		//borramos todas las noticias creadas en forma global
		dao.delete(PerroMuerto);
		dao.delete(LadronCapturado);
	}
	
	@Test
	public void BuscarUnaNoticia() throws PersistenceException{
		Noticia noticiaEncontrada = dao.findByID(PerroMuerto.getId());
		
		assertNotNull("La noticia con id 1 debe exisitir",noticiaEncontrada);
		assertEquals("titulo noticia 1: Perro muere atropellado ","Perro muere atropellado",noticiaEncontrada.getTitulo());
	}
	
	@Test
	public void InsertarUnaNoticia() throws PersistenceException{
		Noticia Obni = new Noticia(3,"obni visto en mendoza");
		assertEquals("chequeamos que existen 2 noticias ante de insertar",2,dao.findAll().size());
		
		dao.insert(Obni);
		assertEquals("ahora deberia haber 3 noticias",3,dao.findAll().size());
		assertNotNull("chequeamos que exista la noticia",dao.findByID(Obni.getId()));
	}
	
	@Test
	public void BorrarUnaNoticia() throws PersistenceException{
		Noticia NotiAborrar = dao.findByID(PerroMuerto.getId());
		dao.delete(PerroMuerto);
	
		NotiAborrar = dao.findByID(1);
		assertNull("La noticia de Id = 1 no deberia estar",NotiAborrar);
	}
	
	@Test
	public void ActualizarAgente() throws PersistenceException{
	  Noticia NoticiaEncontrada = dao.findByID(LadronCapturado.getId());
	  
	  assertEquals("la noticia de id = 2 es la del ladron","Ladron profugo recapturado",NoticiaEncontrada.getTitulo());
	  NoticiaEncontrada.setTitulo("Ladron recapturado profugo otra vez");
	  dao.update(NoticiaEncontrada);
	  assertEquals("el titulo ahora camio","Ladron recapturado profugo otra vez",NoticiaEncontrada.getTitulo());
	}
	
	@Test
	public void BuscarTodasLasNoticias() throws PersistenceException{
		List <Noticia> TodasLasNoticias = dao.findAll();
		assertEquals("tiene que haber 2 noticias en la BDD",2,TodasLasNoticias.size());
	}
	
}
