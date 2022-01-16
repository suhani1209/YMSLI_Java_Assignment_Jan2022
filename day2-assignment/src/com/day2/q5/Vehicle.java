package com.day2.q5;

public class Vehicle {
	
	private int noOfWheel;
	private int noOfPassenger;
	private int model;
	private String make;
	
	public 	Vehicle(){}
	public Vehicle(int noOfWheel, int noOfPassenger, int model, String make) {
		this.noOfWheel = noOfWheel;
		this.noOfPassenger = noOfPassenger;
		this.model = model;
		this.make = make;
	}

	public int getNoOfWheel() {
		return noOfWheel;
	}

	public int getNoOfPassenger() {
		return noOfPassenger;
	}
	public int getModel() {
		return model;
	}

	public String getMake() {
		return make;
	}


	public void display() {
		System.out.println("Make of the vehicle : "+make);
		System.out.println("Model: "+model);
		System.out.println("The number of wheels: "+noOfWheel);
		System.out.println("Number of passengers it can take are: "+noOfPassenger);
	}
}
