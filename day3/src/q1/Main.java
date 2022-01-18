package q1;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		ArrayList<Employee> emps=new ArrayList<Employee>();
		Employee e1=new SalariedEmployee(1,"Suhani Mittal",20,20000);
		Employee e2=new CommisionedEmployee(2,"Mohit Singwal",55,55000,2000);
		Employee e3=new HourlyEmployee(3, "Krrish Mittal", 20, 20090, 40);
		
		emps.add(e1);
		emps.add(e2);
		emps.add(e3);
		
		System.out.println("Total employees in the company : "+emps.size());
		System.out.println(e1.getEmpName()+" has a salary of: "+e1.getSalary());
		System.out.println(e2.getEmpName()+" has a salary of: "+e2.getSalary());
		System.out.println(e3.getEmpName()+" has a salary of: "+e3.getSalary());
		
		System.out.println("Increased salary of "+e1.getEmpName()+" by rate 30 so the salary now becomes : "+e1.incrementSal(30));
	}
}
