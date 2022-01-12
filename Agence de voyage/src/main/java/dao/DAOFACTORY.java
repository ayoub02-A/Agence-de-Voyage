package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOFACTORY {
	
	private DAOFACTORY() {}
	
	private static Connection cnx;
	static 
	{
		String url="jdbc:mysql://localhost:3306/agence?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String user ="root";
		String password="agence";
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			cnx=DriverManager.getConnection(url,user,password);
			System.out.println("connexion �tablie ");
		}
		
		
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
		
		catch(SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	
	public static Connection getConnection() 
	{
		return cnx;
	}


}
