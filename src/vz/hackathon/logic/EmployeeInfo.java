package vz.hackathon.logic;

import java.sql.Date;
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
		
			info="<table><tr><td>Employee Name:</td><td> "+empName+"</td></tr>"
				+"<tr><td>Employee Id:</td><td> "+empId+"</td></tr>"
				+"<tr><td>Manager Name:</td><td> "+empId+"</td></tr></table>"
				
				;
		return info;
	}
	
	public void task(String id) throws SQLException{
		String taskId="";
		String name="";
		Date created;
		Date deadline;
		int hoursReq=0;
		int priority=0;
		
		
    	SQLHelper help=new SQLHelper();
    	ResultSet rsbucket=help.SELECT("bucket", "task_id", "emp_id="+id);
    	while(rsbucket.next()){
    		taskId=rsbucket.getString("task_id");
    		ResultSet rstask=help.SELECT("task", "*", "taskid="+taskId);
    		if(rstask.first()){
    			name=rstask.getString("name");
    			created=rstask.getDate("date_created");
    			deadline=rstask.getDate("deadline");
    			hoursReq=rstask.getInt("hours_needed");
    			priority=rstask.getInt("priority");
    			
    		}
	}
	}
}
