package vz.hackathon.logic;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import vz.hackathon.helper.SQLHelper;
import vz.hackathon.logic.*;


public class TaskManagement {
	public static ArrayList<String> seperate_string(String s)
	{
		ArrayList<String> arrlist=new ArrayList<String>();
		String a[]=s.split(",");
		for(int i=0;i<a.length;i++)
		{
			arrlist.add(a[i]);
		}
		return arrlist;
	}
	public static void automateManagement(String id,String concerns,String skill,String hours,String priority,String dated,String datered,String emp_id)
	{
		ArrayList<String> skills_required_array_list =seperate_string(skill);
		System.out.println("Skills reuired ArrayList"+skills_required_array_list);
		try
		{
			
		Class.forName("oracle.jdbc.driver.OracleDriver");
	    Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","pass");
	    System.out.println("Connection Successful! in automatic ......");
	    Statement stmt = conn.createStatement();
	   System.out.println("Empid"+emp_id);
	    ResultSet rs=stmt.executeQuery("select * from employee where manager_id ="+emp_id+" order by hours_remaining desc");
	    ResultSet resultset_for_skillset;
	    
	    ArrayList<Integer> skills_matching_score_array_list =new ArrayList<Integer>();
	    ArrayList<Integer> emp_id_array_list=new ArrayList<Integer>();
	    ArrayList<String> skills_array_list=new ArrayList<String>();
 	    int emp_id_save = 0;
 	   //System.out.println("ITS NOT WORKING COZ NO RESULT SSET");
 	   //System.out.println(rs.next());
	    while(rs.next())
	    {
	    	System.out.println("inside while");
	    	emp_id_save=rs.getInt("emp_id");
	    	emp_id_array_list.add(emp_id_save);
	    	skills_array_list=call_db_client(emp_id_save);
	    	System.out.println("inside while empid save "+emp_id_save);
	    	/*resultset_for_skillset=stmt.executeQuery("select * from skill_set where emp_id="+emp_id_save);
	    	skills_array_list.removeAll(skills_array_list);
	    	while(resultset_for_skillset.next())
	    	{
	    	System.out.println(resultset_for_skillset.getString("skill"));	
	    	skills_array_list.add(resultset_for_skillset.getString("skill"));
	    	}*/
	    	System.out.println("skills required  array list :"+skills_required_array_list);
	    	System.out.println("skills array list :"+skills_array_list);
	    	
	    	
	    	skills_matching_score_array_list.add(SkillMatching.calculate(skills_array_list, skills_required_array_list));
	    	System.out.println("skills score list :"+skills_matching_score_array_list);
	    }	
	    System.out.println("emp id array  list :"+emp_id_array_list);
	    int largest=skills_matching_score_array_list.get(0);
	    int largest_i=0;
	    for(int i=0;i<skills_matching_score_array_list.size();i++)
	    {
	    	if(skills_matching_score_array_list.get(i)>largest)
	    	{
	    		largest=skills_matching_score_array_list.get(i);
	    		largest_i=i;
	    	}
	    }
	    System.out.println("The task will be assigned to  :"+emp_id_array_list.get(largest_i));
	    ResultSet rs1=null;
	    rs1=stmt.executeQuery("select * from employee where emp_id ="+emp_id_array_list.get(largest_i));
	    rs1.next();
	    //Updating the assigned to for the task in the task table
	    SQLHelper sqlhelp=new SQLHelper();
	    
	    sqlhelp.INSERT("bucket", emp_id_array_list.get(largest_i)+","+id+",'P',"+rs1.getString("manager_id"));
	    sqlhelp.UPDATE("employee "," hours_remaining=hours_remaining-"+hours , "  emp_id="+emp_id_array_list.get(largest_i));
	    sqlhelp.UPDATE("employee "," hours_completed=hours_completed+"+hours , "  emp_id="+emp_id_array_list.get(largest_i));
	    System.out.println("gfhgfhgfgfhgfhfhgfhgfjhgf");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	private static ArrayList<String> call_db_client(int emp_id_save) {
		// TODO Auto-generated method stub
		ArrayList<String> skills_array_list = null;
		try{
		skills_array_list=new ArrayList<String>();
		Class.forName("oracle.jdbc.driver.OracleDriver");
	    Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","pass");
	    
	    Statement stmt = conn.createStatement();
		ResultSet resultset_for_skillset=stmt.executeQuery("select * from skill_set where emp_id="+emp_id_save);
    	while(resultset_for_skillset.next())
    	{
    		System.out.println(resultset_for_skillset.getString("skill"));	
    	skills_array_list.add(resultset_for_skillset.getString("skill"));
    	}
		}
		catch(Exception e)
		{
			
		}
		
    	return skills_array_list;
		
	}
	public static void manualManagement()
	{
		
	}
}
