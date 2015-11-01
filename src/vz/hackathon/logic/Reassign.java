package vz.hackathon.logic;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import vz.hackathon.helper.SQLHelper;

public class Reassign {
	public String reassign(String id) throws SQLException{
			String taskId="";
			String name="";
			String created;
			String deadline;
			String hoursReq;
			String priority;
			String stat;
			String status="";
			String ret="";

	    	SQLHelper help=new SQLHelper();
	    	ResultSet rsbucket=help.SELECT("reassign a, bucket b", "a.*,b.manager_id", "a.task_id=b.task_id and b.manager_id="+id);
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
	    		case "E":status="Elevated";
	    		break;
	    			
	    		}   		
	    				
	    		
	    			name=rsbucket.getString("name");
	    			created=rsbucket.getString("create_date");
	    			deadline=rsbucket.getString("deadline_date");
	    			hoursReq=rsbucket.getString("hours");
	    			priority=rsbucket.getString("priority");
	    			
	                ret+="<tr>"
	                +"<td>"+name+"</td>"
	                +"<td>"+taskId+"</td>"
	                +"<td>"+created+"</td>"
	                +"<td>"+deadline+"</td>"
	                +"<td>"+priority+"</td>"
	                +"<td>"+hoursReq+"</td>"
	                +"<td>"+stat+"</td>";
	                  ret+="</tr>";
	    	}
	    	
	    		
		
	    	return ret;
		}
	}

