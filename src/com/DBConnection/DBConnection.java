package com.DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;

//import com.mysql.jdbc.PreparedStatement;

//import com.mysql.jdbc.Statement;
//import java.sql.PreparedStatement;
//import java.sql.Statement;

public class DBConnection {
	
	
	
	Connection c=null;
	
	
	public Connection con()
	{
		
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		
		c=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/vtjnw08@2016","root","admin");
		
		}
		catch(Exception e)
		{
		e.printStackTrace();
		}
		return c;
		
		
	}
	

}
