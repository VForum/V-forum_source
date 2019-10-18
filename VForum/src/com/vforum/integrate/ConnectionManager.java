package com.vforum.integrate;
/*
 * This class we are creating database connection
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

private static DataSource dataSource=new DataSource();
	
	private static Connection connection=null;
	public static Connection openConnection() 
			throws ClassNotFoundException,SQLException {
		
		Class.forName(dataSource.getDriver());
		connection=DriverManager.getConnection(dataSource.getUrl(),dataSource.getUsername(),dataSource.getPassword());
		return connection;
		
	}
	
	public static void closeConnection() throws SQLException{
		
		connection.close();
	}
}
