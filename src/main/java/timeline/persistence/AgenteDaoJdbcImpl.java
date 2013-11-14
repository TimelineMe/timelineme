package timeline.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import timeline.model.Agente;

public class AgenteDaoJdbcImpl implements AgenteDao { // este es el que implementa el persona dao y hace los insert, delete, y update respectivos

	private static AgenteDao instance = new AgenteDaoJdbcImpl(); //patron singleton

	public static AgenteDao getInstance() {
		return instance;
	}
	//inserta un objeto persona
	@Override
	public void insert(Agente agente) throws PersistenceException {

		Transaction tx = TransactionJdbcImpl.getInstance(); //genera una instancia de transaction 
															//(una interface que tiene metodos, que 
															//son implementados en transaction jdbcimpl) 
															//para hacer una transaccion de la base de la de datos
		Connection conn = tx.getConnection();

		try {
			tx.begin(); //comienza la transaccion
			//esto es un prepareStatement
			String query = "insert into Agente (email_Agente,nombre_Agente) values (?, ?)";
			PreparedStatement statement = TransactionJdbcImpl.getInstance()
					.getConnection().prepareStatement(query);
			statement.setString(1, agente.getEmail_Agente()); // en el punto1, pone lo que te viene de persona.getEmail();
			statement.setString(2, agente.getNombre());

			statement.executeUpdate();

			tx.commit(); //metodo que escribe los datos en la base de datos

		} catch (SQLException sqlException) {
			throw new PersistenceException(sqlException);
		} finally {
			try {
				conn.close();
			} catch (SQLException sqlException) {
				throw new PersistenceException(sqlException);
			}
		}
	}

	@Override
	//borrado
	public void delete(Agente agente) throws PersistenceException {
		Transaction tx = TransactionJdbcImpl.getInstance();
		Connection conn = tx.getConnection();

		try {
			tx.begin();

			String query = "delete from Agente where email_Agente = ?";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, agente.getEmail_Agente());
			statement.executeUpdate();

			tx.commit();

		} catch (SQLException sqlException) {
			throw new PersistenceException(sqlException);
		} finally {
			try {
				conn.close();
			} catch (SQLException sqlException) {
				throw new PersistenceException(sqlException);
			}
		}
	}

	@Override
	public void update(Agente agente) throws PersistenceException {
		try {
			String query = "update Agente set nombre_Agente = ? where email_Agente = ?";

			PreparedStatement statement = TransactionJdbcImpl.getInstance()
					.getConnection().prepareStatement(query);
			statement.setString(1, agente.getNombre());
			statement.setString(2, agente.getEmail_Agente());
			statement.executeUpdate();
		} catch (SQLException sqlException) {
			throw new PersistenceException(sqlException);
		}
	}

	public List<Agente> findAll() throws PersistenceException {
		List<Agente> lista = new LinkedList<Agente>();
		try {
			String query = "select * from Agente";
			PreparedStatement statement = ConnectionProvider.getInstance()
					.getConnection().prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				lista.add(convertOne(resultSet)); //tiene que convertir cada tupla en una persona. convertone esta al final del archivo
			}
		} catch (SQLException sqlException) {
			throw new PersistenceException(sqlException);
		}
		return lista;
	}

	@Override
	public Agente findByEmail(String email_Agente) throws PersistenceException {
		if (email_Agente == "") {
			throw new IllegalArgumentException(
					"El email de agente no debe ser vacio");
		}
		Agente agente = null;
		try {
			Connection c = ConnectionProvider.getInstance().getConnection();
			String query = "select * from Agente where email_Agente = ?";
			PreparedStatement statement = c.prepareStatement(query);
			statement.setString(1, email_Agente);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				agente = convertOne(resultSet);
			}
		} catch (SQLException sqlException) {
			throw new PersistenceException(sqlException);
		}
		return agente;
	}

	private Agente convertOne(ResultSet resultSet) throws SQLException {
		Agente retorno = new Agente(resultSet.getString("email_Agente"),resultSet.getString("nombre_Agente"),resultSet.getString("password"),resultSet.getString("cargo"),resultSet.getString("descripcion"),resultSet.getString("empresa")); //crea el agente, le asigna los valores y la devuelve
		return retorno;
	}

}
