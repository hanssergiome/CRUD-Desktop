package conexões;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexão {
	
	
	public static Connection conecta_banco() throws SQLException{
		
				
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
				return DriverManager.getConnection("jdbc:mysql://localhost/dbsenhas", "hanssergiom", "tpidy6wx");
					
		} catch (ClassNotFoundException e) {
			
			throw new SQLException(e.getException());
			
		}
		
		
	}
	

}
