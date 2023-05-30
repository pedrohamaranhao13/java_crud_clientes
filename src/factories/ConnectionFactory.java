package factories;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	// método para abrir conexão com um banco de dados do PostgreSQL
	public Connection getConnection() throws Exception {
		
		
		String driver = "org.postgresql.Driver";
		String host = "jdbc:postgresql://localhost:5432/bd_java_projeto03";
		String user = "postgres";
		String password = "root";
		
		Class.forName(driver);
		return DriverManager.getConnection(host, user, password);

//	    Class.forName("org.postgresql.Driver");
//		return DriverManager.getConnection("jdbc:postgresql://localhost:5432/bd,java_projeto03", "root", "root");
	}
}
