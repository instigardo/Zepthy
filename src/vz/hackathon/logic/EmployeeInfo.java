package vz.hackathon.logic;

import java.sql.ResultSet;
import java.sql.SQLException;

import vz.hackathon.helper.SQLHelper;

public class EmployeeInfo {
	SQLHelper help=new SQLHelper();
	public String myInfo(String empid) throws SQLException{
		String info="";
		ResultSet rs=help.SELECT("employee", "*", "emp_id="+empid);
		rs.next();
			String empName=rs.getString("name");
			String empId=rs.getString("emp_id");
			String managerId=rs.getString("manager_id");

			ResultSet rs1=help.SELECT("employee", "name", "emp_id="+managerId);
		rs1.next();
			String managerName=rs1.getString("name");
		
			info="<p>Employee Name:\t "+empName+"<br>"
				+"Employee Id:\t "+empId+"<br>"
				+"Manager Name:\t "+empId+"<br></p>"
				
				;
		return info;
	}
}
