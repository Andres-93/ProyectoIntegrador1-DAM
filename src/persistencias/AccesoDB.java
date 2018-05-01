package persistencias;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AccesoDB {

	private String url;
	private String driver;
	
	
	
	public AccesoDB(String driver, String url) {
		this.url = url;
		this.driver = driver;
	}
	
	
	public Connection conectar() throws ClassNotFoundException, SQLException {

		Class.forName(driver);
		Connection con = DriverManager.getConnection(url);			
		return con;		
	}
	
	public void desconectar(Connection con) throws SQLException {
            con.close();
       
	}
}
