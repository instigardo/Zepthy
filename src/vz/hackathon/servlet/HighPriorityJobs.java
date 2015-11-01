package vz.hackathon.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vz.hackathon.helper.Identifier;

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
    ArrayList<String> array_empid=new ArrayList<String>();
    public String ret1()
    {
    	return "1";
    }
    public ArrayList<String> ret2()
    {
     return array_task;	
    }
    Identifier id = new Identifier();
    public String find(String empid)
    {
    	String emploginId=empid;
    	String task_id="";
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
	    	//String task_id=rs.getString("task_id");
	    	task_id=rs.getString("task_id");
	    	// 	Class.forName("oracle.jdbc.driver.OracleDriver");
		    //Connection conn1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","pass");
		    
		    PreparedStatement stmt1 = conn.prepareStatement("select emp_id from bucket where task_id=?",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		    stmt1.setString(1, task_id);
		    ResultSet rs1=stmt1.executeQuery();
		    String emp_id="";
		    if(rs1.first()){
		    rs1.first();
		    emp_id=rs1.getString("emp_id");
		    //rs1=null;
		    }
		    PreparedStatement stmt2 = conn.prepareStatement("select name,manager_id from employee where emp_id=?",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		    stmt2.setString(1, emp_id);
		    ResultSet rs2=stmt2.executeQuery();
		    String emp_name="";
		    String manager_id="";
		    if(rs2.first()){
		    rs2.first();
		    emp_name=(rs2.getString("name"));
		    manager_id=(rs2.getString("manager_id"));
		    }
		    //rs2=null;
		    //PrintWriter out=response.getWriter();
		    //out.println(empname + " " +temp);
		    if(manager_id.equals(emploginId)){
		    array_task.add(task_name);
		    array_emp.add(emp_name);
		    array_empid.add(emp_id+"");}
		    //Response the Things here 
		    //rs1.beforeFirst();   
		    //rs2.beforeFirst();   
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
"<a href=\"http://localhost:8080/hackathon/pages/taskdetails.jsp?pw=800&amp;ph=600&amp;taskid="+task_id+"\" class=\"default_popup\">"			 + array_task.get(i) + " </a> "
			 		+" <span class=\"pull-right text-muted small\"><em> "
					+ "<a href=\"http://localhost:8080/hackathon/pages/Empdashboard.jsp?pw=800&amp;ph=600&amp;empid="+array_empid.get(i)+"\" class=\"default_popup\"> " +array_emp.get(i)+"<\\a> "+
					 " </em></span></div> ";
			 i++;
			}
		//response.getWriter().append(divContent);
		System.out.println(divContent);
		return divContent;

    }
    public void retID(String task_id){
    	System.out.println("here motherfucker!!!");
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
