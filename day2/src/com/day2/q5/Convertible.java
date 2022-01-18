package com.day2.q5;

public class Convertible extends Car{
	private boolean isHoodOpen;
	
	public Convertible(){}
	public Convertible(int noOfWheel, int noOfPassenger, int model, String make,int door,boolean isOpen) {
		super(noOfWheel,noOfPassenger,model,make,door);
		this.isHoodOpen=isOpen;
	}
	
	public void display() {
		super.display();
		if(isHoodOpen)System.out.println("The hood of car is open");
		else System.out.println("The hood of car is closed..");
	}
}
