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

	Agente andres = new Agente(2,"andres","andres@gmail.com");
	Agente marcos = new Agente(5,"marcos","marcos@gmail.com");

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

		Agente agenteEncontrado = dao.findById(andres.getId());

		assertNotNull("el agente con id 2 debe existir", agenteEncontrado);
		assertEquals("el agente 2 tiene nombre: andres", "andres", agenteEncontrado.getNombre());

	}

	@Test
	public void testQueSePuedeInsertarUnAgente() throws PersistenceException {

		Agente arte = new Agente (1,"alicia","alicia@gmail.com");
		assertEquals("antes de insertar hay 2 agentes", 2, dao.findAll().size());

		dao.insert(arte);
		assertEquals("luego de insertar hay 3 agentes", 3, dao.findAll().size());
		assertNotNull("que existe un agente con ese id", dao.findById(arte.getId()));

	}
	
	@Test
	public void testQueSePuedeBorrarUnAgente() throws PersistenceException {

		Agente agenteEncontrado = dao.findById(andres.getId());
		dao.delete(agenteEncontrado);

		agenteEncontrado = dao.findById(1);
		assertNull("el agente con ese id no deberia existir", agenteEncontrado);

	}
	
	@Test
	public void testQueSePuedeActualizarUnAgente() throws PersistenceException {

		Agente agenteEncontrado = dao.findById(marcos.getId());
		assertEquals("la persona con id 5 se llama marcos", "marcos", agenteEncontrado.getNombre());
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
