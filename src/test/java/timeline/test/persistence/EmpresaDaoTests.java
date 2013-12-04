package timeline.test.persistence;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import timeline.model.Empresa;
import timeline.persistence.DaoFactory;
import timeline.persistence.EmpresaDao;
import timeline.persistence.PersistenceException;

public class EmpresaDaoTests {

	EmpresaDao dao = DaoFactory.getEmpresaDao(); //devuelve un dao
	
	Empresa choco = new Empresa("choco@empresa.com","123456", "chocolatins","www.chocos.com","cerrito 1001",4450-4563);
	
	@Before
	public void insertarEmpresa() throws PersistenceException{
		dao.insert(choco);
	}

	@Test 
	public void probarLaInsercion() throws PersistenceException{
	 Empresa empresaInsertada = dao.findByEmail("choco@empresa.com");
		assertEquals("probar que se inserto choco","chocolatins",empresaInsertada.getRazon_Social());
	}
	
	@Test
	public void actualizarEmpresa() throws PersistenceException{
		Empresa EmpresaEncontrada = dao.findByEmail("choco@empresa.com");
		assertEquals("la empresa tiene razon social chocolatins", "chocolatins",EmpresaEncontrada.getRazon_Social());
		EmpresaEncontrada.setRazon_Social("chocoAguila");
		dao.update(EmpresaEncontrada);
		assertEquals("la razon social ahora es chocoAguila", "chocoAguila",EmpresaEncontrada.getRazon_Social());
	}
	
	@After
	public void borrarUnaEmpresa() throws PersistenceException{
		dao.delete(choco);
	}

	@Test
	public void testQueSePuedeBuscarUnEmpresa() throws PersistenceException {

		Empresa empresaEncontrada = dao.findByEmail("prueba@prueba.com.ar");

		assertNotNull("el empresa con id 1 debe existir", empresaEncontrada);
		assertEquals("el empresa 1 tiene nombre: Prueba", "Prueba", empresaEncontrada.getRazon_Social());

	}

	@Test
	public void testQueSePuedenBuscarTodosLosEmpresas() throws PersistenceException {

		List<Empresa> todoslosEmpresas = dao.findAll();
		assertEquals("se espera que haya dos empresas en la base", 5, todoslosEmpresas.size());

	}
	@Test
	public void testQueSePuedeBuscarLasEmpresasNoSeguidas() throws PersistenceException {

		List<Empresa> todoslosEmpresas = dao.findEmpresasNoSeguidasByPalabra("marcos.scalzotto@hotmail.com", "ja");
		assertEquals("se espera que haya dos empresas en la base", 1, todoslosEmpresas.size());

	}
	
	@Test
	public void buscarEmpresaPorPalabra() throws PersistenceException {
		List<Empresa> lista = dao.findEmpresasSeguidasByPalabra("marcos.scalzotto@hotmail.com", "ja");
		assertEquals("buscar empresa por palabra",1,lista.size());
	}
	
	@Test
	public void buscarEmpresasSeguidasPorAgente() throws PersistenceException{
		List<Empresa> lista = dao.findEmpresasSeguidasByAgente("aliciarosenthal@gmail.com"); 
		assertEquals("traer las empresas que sigue alice!",2,lista.size());
	}

}
