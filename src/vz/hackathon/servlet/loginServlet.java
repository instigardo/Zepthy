package vz.hackathon.servlet;


import java.io.IOException;
import java.sql.*;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

import vz.hackathon.helper.Identifier;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    //ResultSet rs = stmt.executeQuery();

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	Identifier iden= new Identifier();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int emp_id=Integer.parseInt(request.getParameter("id"));
		String password=request.getParameter("password");
		
		HttpSession session = request.getSession();
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		    Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","pass");
		    System.out.println("Connection Successful!");
		    Statement stmt = conn.createStatement();
		    ResultSet rs=stmt.executeQuery("select * from employee where emp_id = " + emp_id + "and password = '" + password + "'");
		    if(rs.next())
		    {
		    	session.setAttribute("emp_id", emp_id);
		    }
		    String role=rs.getString("role");
		    if(role.equals("Manager"))
		    {
		    	// Manager Dashboard
		    	
		    	response.sendRedirect("pages/dashboard.jsp");
		    	
		    }
		    else
		    {
		    	// Employee Dashboard
		    	iden.setId(emp_id+"");
		    	response.sendRedirect("pages/Empdashboard.jsp");
		    }
	 
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
}

}
