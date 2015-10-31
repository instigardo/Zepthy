package vz.hackathon.logic;

import java.util.ArrayList;

public class SkillMatching {
	public static int min(ArrayList<String> a,ArrayList<String> b)
	{
		if(a.size()<b.size())
		{
		return 1;
		}
		else 
		{
		return 2;
		}
	}
 public static int calculate(ArrayList<String> a,ArrayList<String> b)
 {
	 int skill_match=0;
	 if(min(a,b)==1)
	 {
	 for(int i=0;i<a.size();i++)
	 {
		 for(int j=0;j<b.size();j++)
		 if(a.get(i).equals(b.get(j)))
		 {
			 skill_match+=1;
			 break;
		 }
		
	 }
	 }
	 else
	 {
		 for(int i=0;i<b.size();i++)
		 {
			 for(int j=0;j<a.size();j++)
			 if(b.get(i).equals(a.get(j)))
			 {
				 skill_match+=1;
				 System.out.println(b.get(i));
				 break;
			 }
			
		 } 
	 }
	 return skill_match;
 }

}
