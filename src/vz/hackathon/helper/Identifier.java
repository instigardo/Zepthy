package vz.hackathon.helper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Identifier {
	static String Id="";

	public static String getId() {
		return Id;
	}

	public static void setId(String id) {
		Id = id;
	}
	SQLHelper helper=new SQLHelper();
	String empS[]=new String[50];
	
	public String[] idFetcher(String managerId) throws SQLException{
		ResultSet rs=helper.SELECT("employee", "emp_id", "manager_id="+managerId);
		int i=0;
		while(rs.next())
		{
			empS[i]=rs.getString("emp_id");
			i++;
		}
		return empS;
	}
	
	
}
