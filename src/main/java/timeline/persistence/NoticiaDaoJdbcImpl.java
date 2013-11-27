package timeline.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import timeline.model.Noticia;

public class NoticiaDaoJdbcImpl implements NoticiaDao {
	
	private static NoticiaDao instance = new NoticiaDaoJdbcImpl();

	public static NoticiaDao getInstance(){
		return instance;
	}
	@Override
	public void insert(Noticia noticia) throws PersistenceException {
		Transaction tx = TransactionJdbcImpl.getInstance();
		
		Connection conn = tx.getConnection();
		
		try{
			tx.begin();
			
			String query = "insert into Noticia(id_noticia, titulo, contenido, fecha_Hora, autor) values(?, ?, ?, ?, ?)";
			PreparedStatement statement = TransactionJdbcImpl.getInstance().getConnection().prepareStatement(query);
			statement.setInt(1, noticia.getId());
			statement.setString(2, noticia.getTitulo());
			statement.setString(3, noticia.getContenido());
			statement.setString(4, noticia.getFecha());
			statement.setString(5, noticia.getAutor());
			
			statement.executeUpdate();
			
			tx.commit();
		}catch(SQLException sqlException){
			throw new PersistenceException(sqlException);
		}finally{
			try{
				conn.close();
			}catch(SQLException sqlException){
				throw new PersistenceException(sqlException);
			}
		}
	}

	@Override
	public void delete(Noticia noticia) throws PersistenceException {
		Transaction tx = TransactionJdbcImpl.getInstance();
		Connection conn = tx.getConnection();
		
		try{
			tx.begin();
			String query = "delete from Noticia where id_noticia = ?";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, noticia.getId());
			statement.executeUpdate();
			
			tx.commit();
		}catch(SQLException sqlException){
			throw new PersistenceException(sqlException);
		}finally{
			try{
				conn.close();
			}catch(SQLException sqlException){
				throw new PersistenceException(sqlException);
			}
		}
	}

	@Override
	public void update(Noticia noticia) throws PersistenceException {
		try{
			String query="update Noticia set titulo = ? where id_noticia = ?";
			PreparedStatement statement = TransactionJdbcImpl.getInstance().getConnection().prepareStatement(query);
			statement.setInt(1, noticia.getId());
			statement.setString(2, noticia.getTitulo());
			statement.executeUpdate();
		}catch(SQLException sqlException){
			throw new PersistenceException(sqlException);
		}
		
	}

	@Override
	public Noticia findByID(Integer id_noticia) throws PersistenceException {
		if(id_noticia == null){
			throw new IllegalArgumentException("El id de noticia no debe ser nulo");
		}
		Noticia noticia = null;
		try{
			Connection c = ConnectionProvider.getInstance().getConnection();
			String query = "select * from Noticia where id_noticia = ?";
			PreparedStatement statement = c.prepareStatement(query);
			statement.setInt(1, id_noticia);
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next()){
				noticia = convertOne(resultSet);
			}
		}catch(SQLException sqlException){
			throw new PersistenceException(sqlException);
		}
		return noticia;
	}

	
	@Override
	public List<Noticia> findAll() throws PersistenceException {
		List<Noticia> lista = new LinkedList<Noticia>();
		try{
			String query = "select * from Noticia";
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
	public List<Noticia> findbyEmpresa(String pemailEmpresa)
			throws PersistenceException {
		List<Noticia> lista = new LinkedList<Noticia>();
		try{
				Connection c = ConnectionProvider.getInstance().getConnection();
				String query = "select * from Noticia INNER JOIN Agente ON(Noticia.autor=Agente.email_Agente) INNER JOIN Empresa ON (Agente.empresa  =  Empresa.email) where Empresa.email=?";
				PreparedStatement statement = c.prepareStatement(query);
				statement.setString(1, pemailEmpresa);
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
	public List<Noticia> findbyAutor(String emailAutor)
			throws PersistenceException {
		List<Noticia> lista = new LinkedList<Noticia>();
		try{
			Connection c = ConnectionProvider.getInstance().getConnection();
			String query = "select * from Noticia where autor=?";
			PreparedStatement statement = c.prepareStatement(query);
			statement.setString(1, emailAutor);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()){
				lista.add(convertOne(resultSet));
			}
		}catch(SQLException sqlException){
			throw new PersistenceException(sqlException);
		}
		return lista;
	}
	private Noticia convertOne(ResultSet resultSet) throws SQLException {
		Noticia retorno = new Noticia(resultSet.getInt("id_Noticia"),resultSet.getString("titulo"),resultSet.getString("contenido"),resultSet.getString("fecha_hora"),resultSet.getString("autor"));
		return retorno;
	}
}
