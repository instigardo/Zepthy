package vz.hackathon.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionGetter
{
	Connection con;
	public ConnectionGetter()
	{
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "hr", "pass" );
					
		System.out.println(con);
		
		} 
	catch (SQLException e)
	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	catch(Exception e)
	{
		e.printStackTrace();	    }

}
	public Connection getConnection()
	{
		return con;
	}
	}
