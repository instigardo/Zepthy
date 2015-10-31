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
	
	public String task(String id) throws SQLException{
		String taskId="";
		String name="";
		Date created;
		Date deadline;
		int hoursReq=0;
		int priority=0;
		String stat;
		String status="";
		String ret="";
		
    	SQLHelper help=new SQLHelper();
    	ResultSet rsbucket=help.SELECT("bucket", "task_id,status", "emp_id="+id);
    	while(rsbucket.next()){
    		taskId=rsbucket.getString("task_id");
    		stat=rsbucket.getString("status");
    		switch(stat)
    		{
    		case "P":status="In Progress";
    		break;
    		case "C":status="Completed";
    		break;
    		case "R":status="Reassigned";
    		break;
    		case "F":status="Failed";
    		break;
    			
    		}
    		
    		ResultSet rstask=help.SELECT("task", "*", "task_id="+taskId);
    		if(rstask.first()){
    			name=rstask.getString("name");
    			created=rstask.getDate("date_created");
    			deadline=rstask.getDate("deadline");
    			hoursReq=rstask.getInt("hours_needed");
    			priority=rstask.getInt("priority");
    			
                ret+="<tr>"
                +"<td>"+name+"</td>"
                +"<td>"+taskId+"</td>"
                +"<td>"+created+"</td>"
                +"<td>"+deadline+"</td>"
                +"<td>"+priority+"</td>"
                +"<td>"+hoursReq+"</td>"
                +"<td>"+status+"</td>"
                +"<td style=\"text-align: center;\"><button type=\"button\" class=\"btn btn-default btn btn-success\"  title=\"Mark Completed\"><i class=\"fa fa-check\"></i></button>"
                    +" &nbsp;<button type=\"button\" class=\"btn btn-primary btn btn-success\">Elevate</i></button></td>"
            +"</tr>";

    		}
	}
    	return ret;
	}
}
