package mercado.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoMysql {

	public Connection getConnection() {
		
		Connection conex = null;
		
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			conex = DriverManager.getConnection("jdbc:mysql://localhost:3306/conta?useTimezone=true&serverTimezone=UTC&useSSL=false", "root", "rootroot");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conex;
	}
	
}
