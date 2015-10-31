package vz.hackathon.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vz.hackathon.helper.SQLHelper;

/**
 * Servlet implementation class MorrisPopulator
 */
@WebServlet("/MorrisPopulator")
public class MorrisPopulator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MorrisPopulator() {
        super();
        // TODO Auto-generated constructor stub
    }

//    HttpServletRequest request;
//    HttpServletResponse response;
//    
//    	HttpSession session=request.getSession();
//    	String emp_id=session.getAttribute("emp_id").toString();
	SQLHelper sqlhelp=new SQLHelper();

    public int morrisDataTaskCompleted(String emp_id, String role) throws SQLException
    	{
    		
    		ResultSet rs=sqlhelp.SELECT("bucket", "count(status)", "status='C' and "+role+"='"+emp_id+"'");
    		int completed=0;
    		while(rs.next())
    		{
    			completed=rs.getInt("count(status)");
    			
    		}
    		return completed;
    	}

    	public int morrisDataTaskPending(String emp_id, String role) throws SQLException
    	{
    		
    		ResultSet rs1=sqlhelp.SELECT("bucket", "count(status)", "status='P' and "+role+"='"+emp_id+"'");
    		int pending=0;
    		while(rs1.next())
    		{
    			pending=rs1.getInt("count(status)");
    			
    		}
    		return pending;
    	}

    	public int morrisDataTaskFailed(String emp_id, String role) throws SQLException
    	{
    		
    		ResultSet rs2=sqlhelp.SELECT("bucket", "count(status)", "status='F' and "+role+"='"+emp_id+"'");
    		int failed=0;
    		while(rs2.next())
    		{
    			failed=rs2.getInt("count(status)");
    			
    		}
    		return failed;
    	}

    	public int morrisDataTaskReassigned(String emp_id, String role) throws SQLException
    	{
    		
    		ResultSet rs3=sqlhelp.SELECT("bucket", "count(status)", "status='R' and "+role+"='"+emp_id+"'");
    		int reassigned=0;
    		while(rs3.next())
    		{
    			reassigned=rs3.getInt("count(status)");
    			
    		}
    		return reassigned;
    	}

    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
