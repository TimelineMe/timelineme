package timeline.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import timeline.model.AgenteEmpresa;

public class AgenteEmpresaDaoJdbcImpl implements  AgenteEmpresaDao {
	
	private static AgenteEmpresaDao instance = new AgenteEmpresaDaoJdbcImpl();

	public static AgenteEmpresaDao getInstance(){
		return instance;
	}
	
	
	@Override
	public void insert(AgenteEmpresa agenteEmpresa) throws PersistenceException {
		
		Transaction tx = TransactionJdbcImpl.getInstance();
		
		Connection con = tx.getConnection();
		
		try{
			tx.begin();
			String query = "insert into AgenteEmpresa (sigue_Empresa, agente) values(?, ?)";
			
			PreparedStatement statement = TransactionJdbcImpl.getInstance().getConnection().prepareStatement(query);
			
			statement.setString(1, agenteEmpresa.getSigue_Empresa());
			
			statement.setString(2, agenteEmpresa.getAgente());
			
			statement.executeUpdate();
			
			tx.commit();
		}catch(SQLException sqlException){
			throw new PersistenceException(sqlException);
		}finally{
			try{
				con.close();
			}catch(SQLException sqlException){
				throw new PersistenceException(sqlException);
			}
		}
		
	}

	@Override
	public void delete(AgenteEmpresa agenteEmpresa) throws PersistenceException {
		Transaction tx = TransactionJdbcImpl.getInstance();
		Connection con = tx.getConnection();
		
		try{
			tx.begin();
			
			String query = "delete from AgenteEmpresa where sigue_Empresa = ? AND agente = ? ";
			PreparedStatement statement = con.prepareStatement(query);
			statement.setString(1, agenteEmpresa.getSigue_Empresa());
			statement.setString(2, agenteEmpresa.getAgente());
			statement.executeUpdate();
			tx.commit();
		}catch(SQLException sqlException){
			throw new PersistenceException(sqlException);
		}finally{
			try{
				con.close();
			}catch(SQLException sqlException){
				throw new PersistenceException(sqlException);
			}
		}
		
	}

	
	@Override
	public List<AgenteEmpresa> findAll() throws PersistenceException {
		List<AgenteEmpresa> lista = new LinkedList<AgenteEmpresa>();
		try{
			String query = "select * from AgenteEmpresa";
			PreparedStatement statement = ConnectionProvider.getInstance().getConnection().prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()){
				lista.add(convertOne(resultSet));
			}
		}catch(SQLException sqlException){
			throw new PersistenceException(sqlException);
		}
		return lista;
	}

	
	private AgenteEmpresa convertOne(ResultSet resultSet) throws SQLException {
		AgenteEmpresa retorno = new AgenteEmpresa(resultSet.getString("sigue_Empresa"),resultSet.getString("agente")); 
		return retorno;
	}

}
