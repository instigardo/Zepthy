package vz.hackathon.logic;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import vz.hackathon.helper.SQLHelper;

public class Reassign {
	public String reassign(String id) throws SQLException{
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
	    	ResultSet rsbucket=help.SELECT("reassign a, bucket b", "a.*,b.emp_id", "a.task_id=b.task_id&amp;emp_id="+id);
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
	    				
	    		
	    			name=rsbucket.getString("name");
	    			created=rsbucket.getDate("date_created");
	    			deadline=rsbucket.getDate("deadline");
	    			hoursReq=rsbucket.getInt("hours_needed");
	    			priority=rsbucket.getInt("priority");
	    			
	                ret+="<tr>"
	                +"<td>"+name+"</td>"
	                +"<td>"+taskId+"</td>"
	                +"<td>"+created+"</td>"
	                +"<td>"+deadline+"</td>"
	                +"<td>"+priority+"</td>"
	                +"<td>"+hoursReq+"</td>"
	                +"<td>"+status+"</td>";
	                  ret+="</tr>";
	    	}
	    	
	    		
		
	    	return ret;
		}
	}

