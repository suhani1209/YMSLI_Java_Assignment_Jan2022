package com.day2.q4;


public class application {
	public static void main(String[] args) {
		
		Student s1=new Student(1);
		s1.display();
		Student s2=new Student("Suhani-Mittal",2);
		s2.display();
		s2.display(2000);
		Student s3=new Student("Suhani-Mittal",3,95);
		s3.display();
	}
}
