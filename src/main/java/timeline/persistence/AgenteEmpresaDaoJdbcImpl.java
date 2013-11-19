package timeline.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import timeline.model.Agente;
import timeline.model.AgenteEmpresa;
import timeline.model.Empresa;

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
			String query = "insert into AgenteEmpresa (agente,empresa) values(?, ?)";
			
			PreparedStatement statement = TransactionJdbcImpl.getInstance().getConnection().prepareStatement(query);
			
			statement.setString(1, agenteEmpresa.getDirAgente());
			
			statement.setString(2, agenteEmpresa.getDirEmpresa());
			
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
			
			String query = "delete from AgenteEmpresa where agente = ? AND empresa = ? ";
			PreparedStatement statement = con.prepareStatement(query);
			statement.setString(1, agenteEmpresa.getDirAgente());
			statement.setString(2, agenteEmpresa.getDirEmpresa());
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
	public List<Empresa> findByAgente() throws PersistenceException {
		List<Empresa> lista = new LinkedList<Empresa>();
		try{
			String query = "select * from AgenteEmpresa where empresa = ?"; 
		
		PreparedStatement statement = ConnectionProvider.getInstance().getConnection().prepareStatement(query);
		ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()){
				lista.add(convertOneEmpresa(resultSet));
			}
		}catch(SQLException sqlException){
			throw new PersistenceException(sqlException);
		}
		return lista;
	}
	
	
	private Empresa convertOneEmpresa(ResultSet resultSet) throws SQLException{
		Empresa retorno = new Empresa(resultSet.getString("email"),resultSet.getString("password"),resultSet.getString("razon_social"),resultSet.getString("sitio_web"),resultSet.getString("direccion"),resultSet.getInt("telefono"));
		return retorno;
	}


	@Override
	public List<Agente> findByEmpresa() throws PersistenceException {
		List<Agente> lista = new LinkedList<Agente>();
		try{
			String query = "select * from AgenteEmpresa where agente = ?";
			PreparedStatement statement = ConnectionProvider.getInstance().getConnection().prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()){
				lista.add(ConvertOneAgente(resultSet));
			}
		}catch(SQLException sqlException){
			throw new PersistenceException(sqlException);
		}
		return lista;
	}


	private Agente ConvertOneAgente(ResultSet resultSet)throws SQLException {
		Agente retorno = new Agente(resultSet.getString("email_Agente"), resultSet.getString("nombre_Agente"), resultSet.getString("password"), resultSet.getString("cargo"),resultSet.getString("descripcion"), resultSet.getString("empresa"));
		return retorno;
	}
	
}
