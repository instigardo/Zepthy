package vz.hackathon.servlet;


import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int emp_id=Integer.parseInt(request.getParameter("id"));
		String password=request.getParameter("password");
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		    Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","pass");
		    System.out.println("Connection Successful!");
		    Statement stmt = conn.createStatement();
		    ResultSet rs=stmt.executeQuery("select * from employee where emp_id = " + emp_id + "and password = '" + password + "'");
		    rs.next();
		    if(rs.getString("role")=="Employee")
		    {
		    	System.out.println("here");
		    	response.sendRedirect("pages/dashboard.jsp");
		    	
		    }
		    else
		    {
		    	
		    }
	 
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
}

}
