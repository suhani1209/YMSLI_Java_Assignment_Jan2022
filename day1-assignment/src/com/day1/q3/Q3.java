package com.day1.q3;

import java.util.Scanner;

public class Q3 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the number of students:");
		int numStudents=sc.nextInt();
		int grades[]=new int[numStudents];
		
		for(int i=1;i<=numStudents;i++)
		{
			System.out.println("Enter the grade for student "+i+":");
			int input=sc.nextInt();
			while(input<0 | input>100)
			{
				System.out.println("Invalid grade, try again..");
				input=sc.nextInt();
			}
			grades[i-1]=input;
		}
		
		int sum=0;
		for(int i=0;i<numStudents;i++)
		{
			sum+=grades[i];
		}
		System.out.println("The average is: "+sum/numStudents);
		
		
	}
}
