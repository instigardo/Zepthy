package vz.hackathon.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vz.hackathon.helper.SQLHelper;

/**
 * Servlet implementation class Lserv
 */
@WebServlet("/ElevateServlet")
public class ElevateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ElevateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String task_id=request.getParameter("server_task_id");
		String empid_id=request.getParameter("server_emp_id");
		String status=request.getParameter("server_task_status");
		String name=request.getParameter("server_task_name");
		String created_date=request.getParameter("server_task_create_date");
		String deadline_date=request.getParameter("server_task_deadline_date");
		String priority=request.getParameter("server_priority");
		String hour=request.getParameter("server_hour");
		SQLHelper help=new SQLHelper();
		help.INSERT("reassign", "'"+name+"',"+task_id+",'"+created_date+"','"+deadline_date+"',"+priority+","+hour+","+status);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
