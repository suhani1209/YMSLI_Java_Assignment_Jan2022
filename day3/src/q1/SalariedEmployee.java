package q1;

public class SalariedEmployee extends Employee{

	public SalariedEmployee() {
		super();
	}

	public SalariedEmployee(int empId, String empName, double rate, double salary) {
		super(empId, empName, rate, salary);
	}
	
	@Override
	public void calSalary() {
		this.setSalary(this.getSalary()*7);
	}
	public double incrementSal(double rate) {
		this.setRate(this.getRate()+rate);
		calSalary();
		return this.getSalary();
	}
	
	
	
}
