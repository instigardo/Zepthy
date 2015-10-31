package vz.hackathon.servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vz.hackathon.helper.SQLHelper;

/**
 * Servlet implementation class taskServlet
 */
@WebServlet("/taskServlet")
public class taskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public taskServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 *
	 *
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    SQLHelper sqlhelp=new SQLHelper();
	static String id="";
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String taskName=request.getParameter("taskName");
		String taskDesc=request.getParameter("taskDesc");
		String dated=request.getParameter("SelectedDate");
		String dater[]=dated.split("/");
		String month[]={"jan","feb","mar","apr","may","jun","jul","aug","sep","oct","nov","dec"};
		String datered=dater[1]+"-"+month[Integer.parseInt(dater[0])-1]+"-"+dater[2];
		String assignment=request.getParameter("assignment");
		String concerns=request.getParameter("concerns");
		String skill=request.getParameter("skill");
		String hours=request.getParameter("hours");
		String priority=request.getParameter("priority");
		sqlhelp.INSERT("task", "'"+ taskName+"','"+"132"+"','"+taskDesc+"',CURRENT_TIMESTAMP(0)"+",'"+datered+"','"+concerns+"','"+skill+"','"+hours+"','"+priority+"'" );
		ResultSet rs=sqlhelp.query("select task_id from task order by date_created desc");
		try {
				rs.next();
				id=rs.getString("task_id");
				System.out.println(id);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(assignment.equals("automatic")){
			System.out.println("id");
		}
		else if(assignment.equals("manual")){
			System.out.println("id");
		}
		response.sendRedirect("../hackathon/pages/dashboard.jsp");
	}

}
