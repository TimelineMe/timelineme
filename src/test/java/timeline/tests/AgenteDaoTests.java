package timeline.tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import timeline.model.Agente;
import timeline.persistence.AgenteDao;
import timeline.persistence.DaoFactory;
import timeline.persistence.PersistenceException;

public class AgenteDaoTests {

	AgenteDao dao = DaoFactory.getAgenteDao(); //devuelve un dao

	Agente andres = new Agente("andres@gmail.com","andres");
	Agente marcos = new Agente("marcos@gmail.com","marcos");

	@Before
	public void setUp() throws PersistenceException {
		// se borran todos los agentes para iniciar con la base vacia
		for (Agente cadaAgente : dao.findAll()) { //aca trae la lista completa 
			dao.delete(cadaAgente); //va borrando a cada persona
		}

		dao.insert(andres);
		dao.insert(marcos);
	}

	@After
	public void tearDown() throws PersistenceException {
		// se borran todos los agentes creados en forma global
		dao.delete(andres);
		dao.delete(marcos);

	}

	@Test
	public void testQueSePuedeBuscarUnAgente() throws PersistenceException {

		Agente agenteEncontrado = dao.findByEmail(andres.getEmail_Agente());

		assertNotNull("el agente con email andres@gmail.com debe existir", agenteEncontrado);
		assertEquals("el agente de este email tiene nombre: andres", "andres", agenteEncontrado.getNombre());

	}

	@Test
	public void testQueSePuedeInsertarUnAgente() throws PersistenceException {

		Agente arte = new Agente ("alicia@gmail.com","alicia");
		assertEquals("antes de insertar hay 2 agentes", 2, dao.findAll().size());

		dao.insert(arte);
		assertEquals("luego de insertar hay 3 agentes", 3, dao.findAll().size());
		assertNotNull("que existe un agente con ese id", dao.findByEmail(arte.getEmail_Agente()));

	}
	
	@Test
	public void testQueSePuedeBorrarUnAgente() throws PersistenceException {

		Agente agenteEncontrado = dao.findByEmail(andres.getEmail_Agente());
		dao.delete(agenteEncontrado);

		agenteEncontrado = dao.findByEmail("andres@gmail.com");
		assertNull("el agente con ese email no deberia existir", agenteEncontrado);

	}
	
	@Test
	public void testQueSePuedeActualizarUnAgente() throws PersistenceException {

		Agente agenteEncontrado = dao.findByEmail(marcos.getEmail_Agente());
		assertEquals("la persona con email marcos@gmail.com se llama marcos", "marcos", agenteEncontrado.getNombre());
		agenteEncontrado.setNombre("marcos02");
		dao.update(agenteEncontrado);
		assertEquals("el agente ahora es marcos02", "marcos02", agenteEncontrado.getNombre());

	}

	@Test
	public void testQueSePuedenBuscarTodosLosAgentes() throws PersistenceException {

		List<Agente> todoslosAgentes = dao.findAll();
		assertEquals("se espera que haya dos agentes en la base", 2, todoslosAgentes.size());

	}

}
