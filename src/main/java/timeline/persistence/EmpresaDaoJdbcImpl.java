package timeline.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import timeline.model.Agente;
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
			String query = "insert into Empresa (email, password, razon_Social, sitio_Web, direccion, telefono) values (?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = TransactionJdbcImpl.getInstance()
					.getConnection().prepareStatement(query);
			statement.setString(1, empresa.getEmail()); 
			statement.setString(2, empresa.getPassword());
			statement.setString(3, empresa.getRazon_Social());
			statement.setString(4, empresa.getSitio_Web());
			statement.setString(5, empresa.getDireccion());
			statement.setInt(6, empresa.getTelefono());

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

			String query = "delete from Empresa where email = ?";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, empresa.getEmail());
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
			String query = "update Empresa set razon_Social = ? where email = ?";

			PreparedStatement statement = TransactionJdbcImpl.getInstance()
					.getConnection().prepareStatement(query);
			statement.setString(1, empresa.getRazon_Social());
			statement.setString(2, empresa.getEmail());
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
	public Empresa findByEmail(String email) throws PersistenceException {
		if (email == "") {
			throw new IllegalArgumentException(
					"El e-mail de una empresa no debe ser nulo");
		}
		Empresa empresa = null;
		try {
			Connection c = ConnectionProvider.getInstance().getConnection();
			String query = "select * from Empresa where email = ?";
			PreparedStatement statement = c.prepareStatement(query);
			statement.setString(1, email);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				empresa = convertOne(resultSet);
			}
		} catch (SQLException sqlException) {
			throw new PersistenceException(sqlException);
		}
		return empresa;
	}
	public List<Empresa> findEmpresaByPalabra(String razon_Social) throws PersistenceException{
		List<Empresa> lista = new LinkedList<Empresa>();
		try {
			Connection c = ConnectionProvider.getInstance().getConnection();
			String query = "select * from Empresa WHERE razon_Social LIKE ?";
			PreparedStatement statement = c.prepareStatement(query);
			statement.setString(1, "%"+razon_Social+"%");
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				lista.add(convertOne(resultSet));
			}
		} catch (SQLException sqlException) {
			throw new PersistenceException(sqlException);
		}
		return lista;
	}
	private Empresa convertOne(ResultSet resultSet) throws SQLException {
		Empresa retorno = new Empresa(resultSet.getString("email"),resultSet.getString("password"),resultSet.getString("razon_Social"),resultSet.getString("sitio_web"),resultSet.getString("direccion"),resultSet.getInt("telefono")); //crea la persona, le asigna los valores y la devuelve
		return retorno;
	}
	
}
