package com.wipro;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.wipro.utils.AverageCalculator;

public class StudentCalculator {
	
	private Map<String,HashMap<String,Integer>> studentMap;
	private AverageCalculator avgCal;
	
	public void studentAvg(List<Student> studentList,String name) 
	{	
		studentMap = new HashMap<String,HashMap<String,Integer>>();
		avgCal = new AverageCalculator();
		
		for(Student s : studentList) 
		{
			if(s.getName().equals(name)) 
			{		
				if(studentMap.containsKey(s.getSubject())) {
					HashMap<String,Integer> hm1 = studentMap.get(s.getSubject());
					hm1.put(s.getAssignCat(), s.getPoints());
				}else {
					HashMap<String,Integer> hm2 = new HashMap<String,Integer>();
					hm2.put(s.getAssignCat(), s.getPoints());
					studentMap.put(s.getSubject(), hm2);
				}
			}
		}
		
		if(studentMap.isEmpty()) {
			System.out.println("Student named " + name + " doesn't exists :");		
		}else {
			avgCal.constructMap(studentMap,"Subject");
		}
	  	
	} // End Of StudentAvg method
	
    //Subject Average
	public void subjectAvg(List<Student> studentList,String subject) 
	{
		studentMap = new HashMap<String,HashMap<String,Integer>>();
		avgCal = new AverageCalculator();
		
		for(Student s : studentList) {
			if(s.getSubject().equals(subject)) {
				if(studentMap.containsKey(s.getName())) {
					HashMap<String,Integer> hm1 = studentMap.get(s.getName());
					hm1.put(s.getAssignCat(),s.getPoints());
				}else {
					HashMap<String,Integer> hm2 = new HashMap<String,Integer>();
					hm2.put(s.getAssignCat(), s.getPoints());
					studentMap.put(s.getName(), hm2);
				}
			}		
		}//End Of For loop
		
		if(studentMap.isEmpty()) {
			System.out.println("Subject named " + subject + " doesn't exists :");
		}else {
			avgCal.constructMap(studentMap,"Name");
		}
		
	}//End of subjectAvg Method
	
}
