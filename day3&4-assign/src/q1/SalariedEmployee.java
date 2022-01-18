package q1;

public class SalariedEmployee extends Employee{
	public SalariedEmployee() {}
	
	public SalariedEmployee(int id,String name,double sal,double rate) {
		super(id,name,sal,rate);
	}
	
	public double getPayment() {
		this.setSalary(this.getRate()*5);
		return this.getSalary();
	}
}
