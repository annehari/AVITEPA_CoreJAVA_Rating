package com.wipro;
import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class StudentDataLoad {
	
	public List<Student> studentList;
	
	private static StudentDataLoad studentDataLoad = null;
	
	private StudentDataLoad() {
		studentList = new ArrayList<Student>();
	}
	
	public static StudentDataLoad getInstance() {
	    if( studentDataLoad == null){
	    	studentDataLoad = new StudentDataLoad();
	    }
	    return studentDataLoad;
	}
	
    public void loadStudentData() throws IOException {
    	String line;
    	File file;
    	FileReader fileReader = null;
    	BufferedReader bReader = null;
    	try {
    		 file = new File("src\\main\\resources\\data.txt");
    		 String fileName = file.getAbsolutePath();
    	     fileReader = new FileReader(fileName);
    	     bReader = new BufferedReader(fileReader);
    	     line = bReader.readLine();
    	     while( line != null)
    	     {
    	    	 String[] lineArray = line.trim().split(",");
    	    	 studentList.add(new Student(lineArray[1],lineArray[2],lineArray[3],Integer.parseInt(lineArray[5])));
    	    	 line = bReader.readLine();
    	     }
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    	}
    	finally {
    		bReader.close();
    		fileReader.close();
  
    	}
    }
    
    public boolean validateAssignment(String assign) {
      	if(assign.startsWith("test") || assign.startsWith("quiz") || assign.startsWith("lab") || assign.startsWith("project")) {
      		return true;
      	}else {
      		return false;
      	}
    }
    
    public Student getStudentData() throws Exception {
    	
        BufferedReader data = new BufferedReader(new InputStreamReader(System.in));
    	
    	System.out.println("Enter Student Name:");
    	String name = data.readLine();
    	
    	System.out.println("Enter Subject:");
    	String subject = data.readLine();
    	
    	System.out.println("Enter Assignment Category");
    	String assignment = data.readLine();
    	while(!validateAssignment(assignment)) {
    		System.out.println("Please enter valid assignment category..\n"
    				+ "Assignment name should start with either test or quiz or lab or project");
    		assignment = data.readLine();
    	}
    	
    	System.out.println("Enter points:");
    	int points = Integer.parseInt(data.readLine());
    	
    	return new Student(name,subject,assignment,points);
    	
    }
    
    public void deleteStudent() throws Exception {
    	Student delStudent = getStudentData();
    	boolean ind = false;
    	for(Student s:studentList) {
    	   if(s.getName().equals(delStudent.getName()) && s.getSubject().equals(delStudent.getSubject()) &&  s.getAssignCat().equals(delStudent.getAssignCat()) && s.getPoints() == delStudent.getPoints()) {
    		   ind = true;
    		   if(studentList.remove(s)) {
    			   System.out.println("Successfully deleted the student \n" + s);
    			   break;
    		   }else {
    			   System.out.println("Student with below details is not present in Database");
    		   }
    		   
    	    }//End of If
    	   
    	}//End of for
    	
    	if(!ind) {
    		System.out.println("Student with below details is not present in Database");
    	}
    	
    }
    
    public void addStudent() throws Exception{
    	
    	Student newStudent = getStudentData();
    	studentList.add(newStudent);
    	System.out.println("Successfully Added the student \n" + newStudent);
    }
    
    public void displayData() {
    	System.out.println("Student Data : \n");
    	for(Student s : studentList) {
    		System.out.println(s);
    	}
    }
}
