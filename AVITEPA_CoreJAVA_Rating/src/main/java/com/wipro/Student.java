package com.wipro;

public class Student {
	private String name;
	private String subject;
	private String assignCat;
	private int points;
	
	public Student(String name, String subject, String assignCat, int points) {
		super();
		this.name = name;
		this.subject = subject;
		this.assignCat = assignCat;
		this.points = points;
	}

	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	public String getAssignCat() {
		return assignCat;
	}


	public void setAssignCat(String assignCat) {
		this.assignCat = assignCat;
	}


	public int getPoints() {
		return points;
	}


	public void setPoints(int points) {
		this.points = points;
	}


	@Override
	public String toString() {
		return "Student [name=" + name + ", subject=" + subject + ", assignCat=" + assignCat + ", points=" + points
				+ "]";
	}
	
	
}
