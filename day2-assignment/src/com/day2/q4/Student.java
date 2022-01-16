package com.day2.q4;

public class Student {
	private String name;
	private int id;
	private int grade;
	public Student(int id)
	{
		this.id=id;
	}
	public Student(String name,int id)
	{
		this(id);
		this.name=name;
	}
	public Student(String name,int id,int grade)
	{
		this(name,id);
		this.grade=grade;
	}
	
	
	public void display()
	{
		System.out.println("Name : "+name+" id : "+id+" grade : "+grade);
	}
	
	public void display(int year)
	{
		this.display();
		System.out.println("This student has value in the year: "+year);
	}

}
