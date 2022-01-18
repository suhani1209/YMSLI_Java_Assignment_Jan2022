package q2;

public class SalariedEmployee extends Employee{
	public SalariedEmployee() {}
	
	public SalariedEmployee(int id,String name,double sal,double rate) {
		super(id,name,sal,rate);
	}
	
	public double getPayment() {
		this.setSalary(this.getRate()*7);
		return this.getSalary();
	}
}
