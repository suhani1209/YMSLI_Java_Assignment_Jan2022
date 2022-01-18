package com.day2.q1;

class Circle{
	private double radius;
	private String color;
	public Circle() {
		System.out.println("default constructor called..");
	};
	public Circle(double r) {
		System.out.println("parameterised constructor called..");
		this.radius=r;
	}
	public double getRadius() {
		return this.radius;
	}
	public double getArea() {
		return 3.14*radius*radius;
	}
}
public class Q1 {
	public static void main(String[] args) {
		Circle c1=new Circle();
		Circle c2=new Circle(3.4);
		System.out.println("Area of circle c2 is "+c2.getArea());
	}
}
