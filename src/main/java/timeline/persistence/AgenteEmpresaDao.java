package timeline.persistence;

import java.util.List;

import timeline.model.Agente;
import timeline.model.AgenteEmpresa;
import timeline.model.Empresa;

public interface AgenteEmpresaDao {
	public void insert(AgenteEmpresa agenteEmpresa) throws PersistenceException;
	
	public void delete(AgenteEmpresa agenteEmpresa) throws PersistenceException;

	public List<AgenteEmpresa> findByAgente(String emailAgente) throws PersistenceException;
	
	public List<Agente> findByEmpresa(String emailEmpresa) throws PersistenceException;

	public List<AgenteEmpresa> findAll() throws PersistenceException;
}
