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
import vz.hackathon.logic.TaskManagement;

/**
 * Servlet implementation class ReassignServlet
 */
@WebServlet("/ReassignServlet")
public class ReassignServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReassignServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hgfhgfhs");
		String task_id=request.getParameter("server_task_id");
		HttpSession session=request.getSession();
		SQLHelper help=new SQLHelper();
		help.UPDATE("bucket", "status='R'", "task_id="+task_id+" and status='E'");
		help.DELETE("reassign", "task_id="+task_id);
		
		ResultSet rs=help.SELECT("task", "*", "task_id="+task_id);
		
		try {
			rs.next();
			TaskManagement.automateManagement(rs.getString("task_id"), rs.getString("concerns"), rs.getString("skill_set_required"), rs.getString("hours_needed"), rs.getString("priority"), rs.getString("date_created"), rs.getString("deadline"), session.getAttribute("emp_id").toString());
			System.out.println("Fuck it");
			response.sendRedirect("http://localhost:8080/hackathon/pages/reassign.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
