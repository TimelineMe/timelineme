package timeline.persistence;

import java.util.List;

import timeline.model.AgenteEmpresa;

public interface AgenteEmpresaDao {
	public void insert(AgenteEmpresa agenteEmpresa) throws PersistenceException;
	
	public void delete(AgenteEmpresa agenteEmpresa) throws PersistenceException;
	
	public List<AgenteEmpresa> findAll() throws PersistenceException;
	
	

}
