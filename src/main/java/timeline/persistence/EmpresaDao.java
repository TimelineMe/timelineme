package timeline.persistence;

import java.util.List;

import timeline.model.Empresa;

/*hace todas las operaciones de insert, delete, update y consulta*/
public interface EmpresaDao { //es una interface, que alguien tiene que implementarla

    public void insert(Empresa empresa) throws PersistenceException;
    
    public void delete(Empresa empresa) throws PersistenceException;
    
    public void update(Empresa empresa) throws PersistenceException;
    
    public Empresa findByEmail(String email) throws PersistenceException; //trae un objeto de tipo persona
    
    public List<Empresa> findAll() throws PersistenceException;
    
}
