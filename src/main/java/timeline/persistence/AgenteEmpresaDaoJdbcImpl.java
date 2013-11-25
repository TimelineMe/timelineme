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
	public List<Agente> findByEmpresa(String emailEmpresa) throws PersistenceException {
		List<Agente> lista = new LinkedList<Agente>();
		try {
			Connection c = ConnectionProvider.getInstance().getConnection();
			String query = "select * from AgenteEmpresa INNER JOIN Agente ON (Agente.email_Agente = AgenteEmpresa.agente) where AgenteEmpresa.sigue_Empresa = ?";
			PreparedStatement statement = c.prepareStatement(query);
			statement.setString(1, emailEmpresa);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				lista.add(convertOneAgente(resultSet));
			}
		} catch (SQLException sqlException) {
			throw new PersistenceException(sqlException);
		}
		return lista;
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

	@Override
	public List<Empresa> findByAgente(String emailAgente)
			throws PersistenceException {
		List<Empresa> lista = new LinkedList<Empresa>();
		try {
			Connection c = ConnectionProvider.getInstance().getConnection();
			String query = "select * from AgenteEmpresa INNER JOIN Empresa ON (Empresa.email = AgenteEmpresa.sigue_Empresa) where AgenteEmpresa.agente=?";
			PreparedStatement statement = c.prepareStatement(query);
			statement.setString(1, emailAgente);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				lista.add(convertOneEmpresa(resultSet));
			}
		} catch (SQLException sqlException) {
			throw new PersistenceException(sqlException);
		}
		return lista;		
	}
	private AgenteEmpresa convertOne(ResultSet resultSet) throws SQLException {
		AgenteEmpresa retorno = new AgenteEmpresa(resultSet.getString("sigue_Empresa"),resultSet.getString("agente")); 
		return retorno;
	}
	private Empresa convertOneEmpresa(ResultSet resultSet) throws SQLException {
		Empresa retorno = new Empresa(resultSet.getString("email"),resultSet.getString("password"),resultSet.getString("razon_Social"),resultSet.getString("sitio_web"),resultSet.getString("direccion"),resultSet.getInt("telefono")); 
		return retorno;
	}
	private Agente convertOneAgente(ResultSet resultSet) throws SQLException {
		Agente retorno = new Agente(resultSet.getString("email_Agente"),resultSet.getString("nombre_Agente"),resultSet.getString("password"),resultSet.getString("cargo"),resultSet.getString("descripcion"),resultSet.getString("empresa"));
		return retorno;	
	}
	/*private Noticia convertOneNoticia(ResultSet resultSet) throws SQLException {
		Noticia retorno = new Noticia(resultSet.getInt("id_Noticia"),resultSet.getString("titulo"),resultSet.getString("contenido"),resultSet.getString("fecha_hora"),resultSet.getString("autor"));
		return retorno;
	}*/

}
