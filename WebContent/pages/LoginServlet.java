

import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
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
			Class.forName("com.mysql.jdbc.Driver");
		    Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","pass");
		    System.out.println("Connection Successful!");
		    Statement stmt = conn.createStatement();
		    ResultSet rs=stmt.executeQuery("select * from employee where emp_id = " + emp_id + "and password = '" + password + "'");
		    
		    if(rs.next())
		    {
		    	response.sendRedirect("pages/dashboard.html");
		    }
	 
		
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
}

}
