package wegest;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;

import com.mysql.jdbc.ExceptionInterceptor;
import com.mysql.jdbc.PingTarget;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetInternalMethods;
import com.mysql.jdbc.Statement;

public class ConectarDB{
	
	private String url;
	private String user;
	private String pass;
	private Connection conect;
	private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
	
	public ConectarDB(String url, String user, String pass) {
		this.url = url;
		this.user = user;
		this.pass = pass;
		this.conect = null;
	}
	
	
	public void conectarDB() throws ClassNotFoundException {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conect = DriverManager.getConnection(url, user, pass);
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
	
	public void manageDB(String statement) {
		int rs;
		try (java.sql.PreparedStatement stmt = conect.prepareStatement(statement)) {
	        rs = stmt.executeUpdate(); //returns int = number of rows afected
	        System.out.println(rs+" filas afectadas");
	       
	      } catch (SQLException sqle) { 
	        System.out.println("Error en la ejecución:"+ sqle.getErrorCode() + " " + sqle.getMessage());    
	      }
	}
	
	public void manageDataDB(String statement) {		
		try (java.sql.PreparedStatement stmt = conect.prepareStatement(statement)) {
	        ResultSet rs = stmt.executeQuery();
	       
	        while (rs.next())
	          System.out.println (rs.getString("country"));
	       
	      } catch (SQLException sqle) { 
	        System.out.println("Error en la ejecución:"+ sqle.getErrorCode() + " " + sqle.getMessage());    
	      }
	}

}
