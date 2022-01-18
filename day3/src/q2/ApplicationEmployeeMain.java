package q2;

import java.util.ArrayList;

public class ApplicationEmployeeMain {
	public static void main(String[] args) {
		ArrayList<Employee> emps=new ArrayList<Employee>();
		Employee e1=new SalariedEmployee(1,"Suhani Mittal",50000,200);
		Employee e2=new CommisionedEmployee(2,"Mohit Singwal",55000,1200,12,190);
		Employee e3 =new HourlyEmployee(3, "Krrish Mittal", 20000, 10, 40);
		
		emps.add(e1);
		emps.add(e2);
		emps.add(e3);
		
		System.out.println("Total employees in the company : "+emps.size());
		System.out.println(e1.getEmpName()+" has a salary of: "+e1.getPayment());
		System.out.println(e2.getEmpName()+" has a salary of: "+e2.getPayment());
		System.out.println(e3.getEmpName()+" has a salary of: "+e3.getPayment());
		
		Invoice invoice=new Invoice("348BC38","Part 1", 6, 20000);
		System.out.println(invoice+"\n total expense of the part is : "+invoice.getPayment());
	
	}
}
