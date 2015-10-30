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

    public int morrisDataTaskCompleted(String emp_id) throws SQLException
    	{
    		
 //   		ResultSet rs=sqlhelp.SELECT("bucket", "count(status)", "status='c' and emp_id='"+emp_id+"'");
    		int completed=4;
//    		while(rs.next())
//    		{
//    			completed=rs.getInt("count(status)");
//    			
//    		}
    		return completed;
    	}

    	public int morrisDataTaskPending(String emp_id) throws SQLException
    	{
    		
  //  		ResultSet rs=sqlhelp.SELECT("bucket", "count(status)", "status='p' and emp_id='"+emp_id+"'");
    		int pending=04;
//    		while(rs.next())
//    		{
//    			pending=rs.getInt("count(status)");
//    			
//    		}
    		return pending;
    	}

    	public int morrisDataTaskFailed(String emp_id) throws SQLException
    	{
    		
 //   		ResultSet rs=sqlhelp.SELECT("bucket", "count(status)", "status='f' and emp_id='"+emp_id+"'");
    		int failed=4;
//    		while(rs.next())
//    		{
//    			failed=rs.getInt("count(status)");
//    			
//    		}
    		return failed;
    	}

    	public int morrisDataTaskReassigned(String emp_id) throws SQLException
    	{
    		
 //   		ResultSet rs=sqlhelp.SELECT("bucket", "count(status)", "status='r' and emp_id='"+emp_id+"'");
    		int reassigned=4;
//    		while(rs.next())
//    		{
//    			reassigned=rs.getInt("count(status)");
//    			
//    		}
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
