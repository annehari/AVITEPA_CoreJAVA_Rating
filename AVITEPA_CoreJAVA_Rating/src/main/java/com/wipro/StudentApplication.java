package com.wipro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StudentApplication {
	
	private static StudentDataLoad sdl;
	private static StudentCalculator stuCal;

	public static void main(String[] args) throws Exception
	{
	    //sdl = new StudentDataLoad();
		sdl = StudentDataLoad.getInstance();
	    stuCal = new StudentCalculator(); 
	    System.out.println("Started Loading the data.....");
		sdl.loadStudentData();
		System.out.println("Data loaded Successfull....");
				
		BufferedReader data = new BufferedReader(new InputStreamReader(System.in));
			
		do 
		{
		  System.out.println("\n 1. Display Student Average \n 2. Display Subject Average \n 3. Display Data \n "
		  		+ "4. Add new Student \n 5. Delete Student \n 6. Exit \n");
		  System.out.print("Enter you Choice :");	
		  int n = Integer.parseInt(data.readLine());
		
		  switch(n)
		  {
		   		case 1 : System.out.print("\n" + "Student : ");
		   		         String studentName = data.readLine().trim();
		   		         stuCal.studentAvg(sdl.studentList,studentName);
		   			     break;
		   		
		   		case 2:  System.out.print("\n" + "Subject : ");
  		                 String subName = data.readLine().trim();
  		                 stuCal.subjectAvg(sdl.studentList,subName);
  			             break;
  			             
  			    case 3: sdl.displayData();break;
  			    
  			    case 4: sdl.addStudent();break;
  			    
  			    case 5: sdl.deleteStudent();break;
		   		
		   		case 6: System.exit(0);break;
		   		
		   		default: System.out.println("Enter valid Input");
		  }
		  
		}while(true);

	}
}
