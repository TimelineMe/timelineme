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

	Agente andres = new Agente("leandroandres1@gmail.com","andres", null, null, null, null);
	Agente marcos = new Agente("marcos@gmail.com","marcos", null, null, null, null);
	Agente german = new Agente("german@gmail.com","german",null,null,null,null);

	@Before
	public void insertarAgente() throws PersistenceException{
		dao.insert(german);
	}
	
	@Test 
	public void probarLaInsercion() throws PersistenceException{
	 Agente	agenteInsertado = dao.findByEmail("german@gmail.com");
		assertEquals("probar que se inserto german","german@gmail.com",agenteInsertado.getEmail_Agente());
	}
	
	@Test
	public void actualizarAgente() throws PersistenceException{
		Agente agenteEncontrado = dao.findByEmail(german.getEmail_Agente());
		assertEquals("la persona con email german@gmail.com se llama german", "german", agenteEncontrado.getNombre());
		agenteEncontrado.setNombre("germansito");
		dao.update(agenteEncontrado);
		assertEquals("el agente ahora es germansito", "germansito", agenteEncontrado.getNombre());
	}
	@After
	public void borrarUnAgente() throws PersistenceException{
		dao.delete(german);
	}
	
	

	@Test
	public void testQueSePuedeBuscarUnAgente() throws PersistenceException {

		Agente agenteEncontrado = dao.findByEmail(andres.getEmail_Agente());

		assertNotNull("el agente con email leandroandres1@gmail.com debe existir", agenteEncontrado);
		assertEquals("el agente de este email tiene nombre: Andres Malagreca", "Andres Malagreca", agenteEncontrado.getNombre());

	}
	
	@Test
	public void testQueSePuedenBuscarTodosLosAgentes() throws PersistenceException {

		List<Agente> todoslosAgentes = dao.findAll();
		assertEquals("se espera que haya dos agentes en la base", 6, todoslosAgentes.size());

	}
	@Test
	public void AgenteSigueEmpresa() throws PersistenceException {
		List<Agente> Agentes = dao.findSeguidoresByEmpresa("info@timelineme.com.ar");
		assertEquals("tiene que haber 4 agentes",4,Agentes.size());
	}
	
	@Test
	public void testQueSePuedenBuscarTodosLosAgentesdeUnaEmpresa() throws PersistenceException {

		List<Agente> todoslosAgentes = dao.findByEmpresa("info@timelineme.com.ar");
		assertEquals("se espera que haya dos agentes en la base", 2, todoslosAgentes.size());

	}

}
