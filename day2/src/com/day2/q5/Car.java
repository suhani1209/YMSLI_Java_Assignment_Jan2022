package com.day2.q5;

public class Car extends Vehicle{
	private int noOfDoor;
	
	public Car() {}
	public Car(int noOfWheel, int noOfPassenger, int model, String make,int door) {
		super(noOfWheel,noOfPassenger,model,make);
		this.noOfDoor=door;
	}
	public int getNoOfDoor() {
		return noOfDoor;
	}

	public void setNoOfDoor(int noOfDoor) {
		this.noOfDoor = noOfDoor;
	}

	public void display() {
		System.out.println("Make of the car: "+super.getMake());
		System.out.println("Model of car: "+super.getModel());
		System.out.println("No of doors: "+noOfDoor);
	}
}
