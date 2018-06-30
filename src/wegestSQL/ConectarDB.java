package wegestSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConectarDB {

	private static final String url = "jdbc:mysql://localhost:3306/empresa";
	private static final String user = "root";
	private static final String pass = "";
	private Connection conector;


	public ConectarDB() throws ClassNotFoundException {
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				conector = DriverManager.getConnection(url, user, pass);
				System.out.println("Conectado Correctamente");

			} catch (SQLException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	public Connection getConnection() {
		return conector;
	}
	
	public void desconectarDB() {
		try {
			conector.close();
		} catch (SQLException e) {
			System.out.println("Error al cerrar la conexión");
			e.printStackTrace();
		}
	}
	
	



}


