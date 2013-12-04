package timeline.test.persistence;

import static org.junit.Assert.*;

import java.util.List;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import timeline.model.AgenteEmpresa;
import timeline.persistence.AgenteEmpresaDao;
import timeline.persistence.DaoFactory;
import timeline.persistence.PersistenceException;

public class AgenteSigueEmpresaTests {

	AgenteEmpresaDao dao = DaoFactory.getAgenteEmpresaDao();
	
	AgenteEmpresa AE1 = new AgenteEmpresa("choco@empresa.coms","marcos.scalzotto@hotmail.com");
	
	@Before
	public void insertarEmpresa() throws PersistenceException{
		dao.insert(AE1);
	}
	
	@After
	public void BorrarLaEmpresa() throws PersistenceException{
		dao.delete(AE1);
	}
	
	@Test
	public void todos() throws PersistenceException {
		List<AgenteEmpresa> AgentesEmpresa = dao.findAll();
		assertEquals("tiene que haber 14 relaciones",14,AgentesEmpresa.size());
	}
}
