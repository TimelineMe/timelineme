package timeline.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import timeline.model.Empresa;

public class EmpresaDaoJdbcImpl implements EmpresaDao { // este es el que implementa el persona dao y hace los insert, delete, y update respectivos

	private static EmpresaDao instance = new EmpresaDaoJdbcImpl(); //patron singleton

	public static EmpresaDao getInstance() {
		return instance;
	}
	//inserta un objeto persona
	@Override
	public void insert(Empresa empresa) throws PersistenceException {

		Transaction tx = TransactionJdbcImpl.getInstance(); //genera una instancia de transaction 
															//(una interface que tiene metodos, que 
															//son implementados en transaction jdbcimpl) 
															//para hacer una transaccion de la base de la de datos
		Connection conn = tx.getConnection();

		try {
			tx.begin(); //comienza la transaccion
			//esto es un prepareStatement
			String query = "insert into Empresa (id_Empresa, razon_Social) values (?, ?)";
			PreparedStatement statement = TransactionJdbcImpl.getInstance()
					.getConnection().prepareStatement(query);
			statement.setInt(1, empresa.getId_Empresa()); // en el punto1, pone lo que te viene de persona.getId();
			statement.setString(2, empresa.getRazon_Social());

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
	public void delete(Empresa empresa) throws PersistenceException {
		Transaction tx = TransactionJdbcImpl.getInstance();
		Connection conn = tx.getConnection();

		try {
			tx.begin();

			String query = "delete from Empresa where id_Empresa = ?";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, empresa.getId_Empresa());
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
	public void update(Empresa empresa) throws PersistenceException {
		try {
			String query = "update Empresa set razon_Social = ? where id_Empresa = ?";

			PreparedStatement statement = TransactionJdbcImpl.getInstance()
					.getConnection().prepareStatement(query);
			statement.setString(1, empresa.getRazon_Social());
			statement.setInt(2, empresa.getId_Empresa());
			statement.executeUpdate();
		} catch (SQLException sqlException) {
			throw new PersistenceException(sqlException);
		}
	}

	public List<Empresa> findAll() throws PersistenceException {
		List<Empresa> lista = new LinkedList<Empresa>();
		try {
			String query = "select * from Empresa";
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
	public Empresa findById(Integer id_Empresa) throws PersistenceException {
		if (id_Empresa == null) {
			throw new IllegalArgumentException(
					"El id de empresa no debe ser nulo");
		}
		Empresa empresa = null;
		try {
			Connection c = ConnectionProvider.getInstance().getConnection();
			String query = "select * from Empresa where id_Empresa = ?";
			PreparedStatement statement = c.prepareStatement(query);
			statement.setInt(1, id_Empresa);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				empresa = convertOne(resultSet);
			}
		} catch (SQLException sqlException) {
			throw new PersistenceException(sqlException);
		}
		return empresa;
	}

	private Empresa convertOne(ResultSet resultSet) throws SQLException {
		Empresa retorno = new Empresa(resultSet.getInt("id_Empresa"),resultSet.getString("razon_Social")); //crea la persona, le asigna los valores y la devuelve
		return retorno;
	}

}
