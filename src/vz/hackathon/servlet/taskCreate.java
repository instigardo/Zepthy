package vz.hackathon.servlet;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import vz.hackathon.helper.ConnectionGetter;
import vz.hackathon.helper.SQLHelper;

public class taskCreate {
	ConnectionGetter cg= new ConnectionGetter();
	Connection conn=cg.getConnection();
	public String filler(String emp_id) throws SQLException{
		String content="<label>Assignee</label><select class=\"form-control\" name=\"assignee\"><option></option>";
                                             
		 Statement stmt = conn.createStatement();
		    Statement stmt2 = conn.createStatement();
		    ResultSet rs=stmt.executeQuery("select name,emp_id from employee where manager_id = " + emp_id);
		    
		   
		    
		    ArrayList<String> emps=new ArrayList<String>();
		    ArrayList<String> empids=new ArrayList<String>();
		    String emp_name="";
		    String empid="";
		    while(rs.next())
		    {	

		    	emp_name=rs.getString("name");
		    	empid=rs.getString("emp_id");
		    	emps.add(emp_name);	
		    	empids.add(empid);	
	}
		  	
		   
		  	
		  	String divc="";
		   	  for(int i=0; i<emps.size(); i++){
		   	  divc+=
		       	    	"<option value=\""+empids.get(i)+"\">"+emps.get(i)+"</option>";
		       
		   	  }
		   	content+=divc+"</select>";
		       System.out.println(content);		
		
		
		return content;
	}
}
