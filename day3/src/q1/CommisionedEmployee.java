package q1;

public class CommisionedEmployee extends Employee{
	private double sales;
	public CommisionedEmployee() {
		super();
	}
	public CommisionedEmployee(int empId, String empName,double rate,double sal,double sales) {
		super(empId, empName,rate,sal);
		this.sales=sales;
	}
	
	@Override
	public void calSalary() {
		this.setSalary((this.getRate()*sales)/100);
	}
	public double incrementSal(double rate) {
		this.setRate(this.getRate()+rate);
		calSalary();
		return this.getSalary();
	}
}
