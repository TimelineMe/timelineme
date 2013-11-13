package timeline.persistence;

import java.util.List;

import timeline.model.Agente;


/*hace todas las operaciones de insert, delete, update y consulta*/
public interface AgenteDao { //es una interface, que alguien tiene que implementarla

    public void insert(Agente agente) throws PersistenceException;
    
    public void delete(Agente agente) throws PersistenceException;
    
    public void update(Agente agente) throws PersistenceException;
    
    public Agente findByEmail(String email_Agente) throws PersistenceException; //trae un objeto de tipo agente
    
    public List<Agente> findAll() throws PersistenceException;
    
}
