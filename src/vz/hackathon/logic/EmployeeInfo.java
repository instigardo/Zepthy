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
				+"<tr><td>Manager Name:</td><td> "+managerName+"</td></tr></table>"
				
				;
		return info;
	}
	
	public String task(String id,String redirect) throws SQLException{
		String taskId="";
		String name="";
		Date created;
		Date deadline;
		int hoursReq=0;
		int priority=0;
		String stat;
		String status="";
		String ret="";
		String manager="";
    	SQLHelper help=new SQLHelper();
    	ResultSet rsman=help.SELECT("employee", "manager_id", "emp_id="+id);
    	rsman.next();
    	manager=rsman.getString("manager_id");
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
    		default: status="Elevated";
    			
    		}
    		String con="";
    				
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
                +"<td>"+status+"</td>";
                
                if(redirect.equals("empdash")){
                	if(stat.equals("P")&&created.before(deadline)){
                con="<td style=\"text-align: center;\"><button type=\"button\" class=\"btn btn-default btn btn-success\"  title=\"Mark Completed\" onclick=\"complete("+taskId+","+id+",'0') \"><i class=\"fa fa-check\"></i></button>"
                    +" &nbsp;<button type=\"button\" class=\"btn btn-primary btn btn-success\" id=\""+taskId+"\" onclick=\"elevate("+taskId+","+id+",'"+stat+"','"+created.toString()+"','"+deadline.toString()+"','"+priority+"','"+hoursReq+"','"+name+"','"+manager+"') \">Elevate</i></button></td>";
                }
                	else if(stat.equals("P")&&created.equals(deadline)){
                		help.UPDATE("bucket", "status='F'", "task_id="+taskId +"and emp_id="+id);
                		con="<td style=\"text-align: center;\"><button type=\"button\" class=\"btn btn-default btn btn-success disabled\"  title=\"Mark Completed\" onclick=\"complete("+taskId+","+id+",'0') \"><i class=\"fa fa-check\"></i></button>"
                                +" &nbsp;<button type=\"button\" class=\"btn btn-primary btn btn-success disabled\" id=\""+taskId+"\" onclick=\"elevate("+taskId+","+id+",'"+stat+"','"+created.toString()+"','"+deadline.toString()+"','"+priority+"','"+hoursReq+"','"+name+"','"+manager+"') \">Elevate</i></button></td>";
                	}
                	else{
                		con="<td style=\"text-align: center;\"><button type=\"button\" class=\"btn btn-default btn btn-success disabled\"  title=\"Mark Completed\" onclick=\"complete("+taskId+","+id+",'0') \"><i class=\"fa fa-check\"></i></button>"
                                +" &nbsp;<button type=\"button\" class=\"btn btn-primary btn btn-success disabled\" id=\""+taskId+"\" onclick=\"elevate("+taskId+","+id+",'"+stat+"','"+created.toString()+"','"+deadline.toString()+"','"+priority+"','"+hoursReq+"','"+name+"','"+manager+"') \">Elevate</i></button></td>";
                            
                	}
                }
                else if(redirect.equals("taskdetails")){
                	if(stat.equals("P")){
                        con="<td style=\"text-align: center;\"> &nbsp;<button type=\"button\" class=\"btn btn-primary btn btn-success\" id=\""+taskId+"\" onclick=\"elevate("+taskId+","+id+",'"+stat+"','"+created.toString()+"','"+deadline.toString()+"','"+priority+"','"+hoursReq+"','"+name+"','"+manager+"') \">Revoke</i></button></td>";
                        }
                	else{
                        con="<td style=\"text-align: center;\"> &nbsp;<button type=\"button\" class=\"btn btn-primary btn btn-success disabled\" id=\""+taskId+"\" onclick=\"elevate("+taskId+","+id+",'"+stat+"','"+created.toString()+"','"+deadline.toString()+"','"+priority+"','"+hoursReq+"','"+name+"','"+manager+"') \">Revoke</i></button></td>";

                                    	}
                }
                		
                
                
                    
                    ret+=con+"</tr>";

    		}
	}
    	return ret;
	}
	public int complete(String taskId, String id){
		help.UPDATE("bucket", "status='C'", "task_id="+taskId +"and emp_id="+id);
		
		return 0;
	}

	public int elevate(String taskId, String id){
		help.UPDATE("bucket", "status='E'", "task_id="+taskId+"and emp_id="+id);
		
		return 0;
	}

	
}

