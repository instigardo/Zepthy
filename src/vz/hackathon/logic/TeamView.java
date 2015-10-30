package vz.hackathon.logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpSession;

public class TeamView
{
public void teamViewer()
{
	try
	{
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
	    Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","pass");
	    System.out.println("Connection Successful!");
	    Statement stmt = conn.createStatement();
	    ResultSet rs=stmt.executeQuery("");
	    
	}
	catch (Exception e)
	{
		e.printStackTrace();
	}
	}
}