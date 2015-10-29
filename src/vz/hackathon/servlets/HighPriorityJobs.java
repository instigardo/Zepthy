package vz.hackathon.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HighPriorityJobs
 */
public class HighPriorityJobs extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void test()
	{
		System.out.println("hello");
		
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			}
	ArrayList<String> array_emp=new ArrayList<String>();
    ArrayList<String> array_task=new ArrayList<String>();
    public String ret1()
    {
    	return "1";
    }
    public ArrayList<String> ret2()
    {
     return array_task;	
    }
    
    public String find()
    {
    	
		try
		{
		Class.forName("oracle.jdbc.driver.OracleDriver");
	    Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","pass");
	    System.out.println("Connection Successful!");
	    Statement stmt = conn.createStatement();
	    ResultSet rs=stmt.executeQuery("select * from task where priority=3");
	    String divContent="";
	    while(rs.next())
	    {
	    	String task_name=rs.getString("name");
	    	int task_id=Integer.parseInt(rs.getString("task_id"));
	    	// 	Class.forName("oracle.jdbc.driver.OracleDriver");
		    //Connection conn1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","pass");
		    
		    Statement stmt1 = conn.createStatement();
		    ResultSet rs1=stmt1.executeQuery("select emp_id from bucket where task_id="+task_id);
		    rs1.next();
		    int emp_id=Integer.parseInt(rs1.getString("emp_id"));
		    
		    Statement stmt2 = conn.createStatement();
		    ResultSet rs2=stmt2.executeQuery("select name from employee where emp_id="+emp_id);
		    rs2.next();
		    String emp_name=(rs2.getString("name"));
		    
		    //PrintWriter out=response.getWriter();
		    //out.println(empname + " " +temp);
		    
		    array_task.add(task_name);
		    array_emp.add(emp_name);
		    
		    //Response the Things here 
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		int i=0;
		String divContent="";
		 while(i<array_emp.size()) 
			{
			 divContent = divContent+ " <div class=\"list-group\">"
			 		+ "<i class=\"fa fa-comment fa-fw\"></i> "+
			  "<a href=\"\""+array_task.get(i)+"</a>"
			 		+" <span class=\"pull-right text-muted small\"><em> "
					 +array_emp.get(i)+
					 " </em></span></div> ";
			 i++;
			}
		//response.getWriter().append(divContent);
		System.out.println(divContent);
		return divContent;

    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
