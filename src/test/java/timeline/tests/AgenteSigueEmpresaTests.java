package timeline.tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import timeline.model.Agente;
import timeline.model.AgenteEmpresa;
import timeline.model.Empresa;
import timeline.persistence.AgenteEmpresaDao;
import timeline.persistence.DaoFactory;
import timeline.persistence.PersistenceException;

public class AgenteSigueEmpresaTests {

	AgenteEmpresaDao dao = DaoFactory.getAgenteEmpresaDao();
	
	/*AgenteEmpresa AE1 = new AgenteEmpresa("andres@gmail.com","Aerolinea xxx");
	AgenteEmpresa AE2 = new AgenteEmpresa("andres@gmail.com","Super Pirulo");
	AgenteEmpresa AE3 = new AgenteEmpresa("marcos@gmail.com","Super Pirulo");
	AgenteEmpresa AE4 = new AgenteEmpresa("marcos@gmail.com","Aerolinea xxx");*/
	
	/*@Before
	public void setUp() throws PersistenceException {
		dao.insert(AE1);
		dao.insert(AE2);
		dao.insert(AE3);
		dao.insert(AE4);
		assertEquals("a ver si se inserto la primer empresa","andres@gmail",AE1.getDirAgente());
		
	}*/
	
	@Test
	public void AgenteSigueEmpresa() throws PersistenceException {
		List<Agente> Agentes = dao.findByEmpresa("info@timelineme.com.ar");
		assertEquals("tiene que haber 3 empresas",3,Agentes.size());
	}
	@Test
	public void Empresa() throws PersistenceException {
		List<Empresa> empresa = dao.findByAgente2("aliciarosenthal@gmail.com");
		assertEquals("tiene que haber 2 empresas",2,empresa.size());
	}
	@Test
	public void todos() throws PersistenceException {
		List<AgenteEmpresa> AgentesEmpresa = dao.findAll();
		assertEquals("tiene que haber 11 relaciones",11,AgentesEmpresa.size());
	}
}
