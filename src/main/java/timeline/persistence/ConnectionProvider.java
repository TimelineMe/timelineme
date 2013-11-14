package timeline.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/*provee la conexion*/
public class ConnectionProvider {

	private static ConnectionProvider instance;
	private static Connection connection = null;
	
	private String url = "jdbc:sqlite:C:/java/workspace/TimelineMe/timeline.db"; //la url, taller.db esta en la raiz

	private ConnectionProvider() throws PersistenceException {
		try {
			Class.forName("org.sqlite.JDBC"); //registrar el driver
			connection = DriverManager.getConnection(this.url); 
		} catch (Exception classNotFoundException) { //si no esta el driver instalado o esta mal la url, lanza una excepcion
			throw new PersistenceException(classNotFoundException);
		}
	}

	public static ConnectionProvider getInstance() throws PersistenceException { //implementacion de patron singleton
		if (instance == null) {
			instance = new ConnectionProvider();
		}
		return instance;
	}

	public Connection getConnection() throws PersistenceException {

		try {
			this.closeConnection();
			// siempre debe ser una nueva conexión, por cuestiones de SQLite

			connection = DriverManager.getConnection(this.url);
			connection.setAutoCommit(false);
		} catch (Exception exception) {
			throw new PersistenceException(exception);
		}
		return connection;
	}

	public void closeConnection() throws PersistenceException {
		if (connection != null) {
			try {
				connection.close(); 
			} catch (SQLException sqlException) { 
				throw new PersistenceException(sqlException);
			}
		}
	}

	public void rollback() throws PersistenceException {
		if (connection != null) {
			try {
				connection.rollback(); // si hice una transaccion pero se corto en algun momento, deberia volver atras y cancelar todo, hasta que no se termino la transaccion no escribe en la base de datos
			} catch (SQLException sqlException) {
				throw new PersistenceException(sqlException);
			}
		}
	}

}
