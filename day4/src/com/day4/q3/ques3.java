package com.day5.q3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Employee implements Serializable{
	private int id;
	private String name;
	private String address;
	transient double salary;
	public Employee(int id, String name, String address, double salary) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.salary = salary;
	}
	public void display() {
		System.out.println("Name : "+name);
		System.out.println("Id : "+id);
		System.out.println("Address : "+address);
		System.out.println("Salary : "+salary);
	}
}
public class ques3 {
	
	public static void main(String[] args) {
		Employee emp=new Employee(1230, "Suhani Mittal", "Greater Noida", 55000.50);
		String filename="serialisation.txt";
		try{   
	            //Saving of object in a file
	            FileOutputStream file = new FileOutputStream(filename);
	            ObjectOutputStream out = new ObjectOutputStream(file);
	              
	            // Method for serialization of object
	            out.writeObject(emp);
	              
	            out.close();
	            file.close();
	              
	            System.out.println("Object has been serialized");
	            emp.display();
	            
	        }catch(IOException ex)
	        {
	            ex.getMessage();
	        }
		 
		 
		 Employee emp2=null;
		// Deserialization
	        try
	        {   
	            // Reading the object from a file
	            FileInputStream file = new FileInputStream(filename);
	            ObjectInputStream in = new ObjectInputStream(file);
	              
	            // Method for deserialization of object
	            emp2 = (Employee)in.readObject();
	              
	            in.close();
	            file.close();
	            emp2.salary=40000;
	            System.out.println("Object has been deserialized..");
	            emp2.display();
	            
	        }catch(IOException ex){
	           ex.getMessage();
	        }catch(ClassNotFoundException ex){
	           ex.getMessage();
	        }
		
	}
}
