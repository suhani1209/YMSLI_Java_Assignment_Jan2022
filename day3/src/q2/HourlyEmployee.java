package q2;

public class HourlyEmployee extends Employee{
	private int hrsWorked;
	public HourlyEmployee() {
		super();
	}
	public HourlyEmployee(int empId, String name, double sal, double rate,int hoursWorkedFor) {
		super(empId, name, sal, rate);
		this.hrsWorked=hoursWorkedFor;
	}
	public int getHrsWorked() {
		return hrsWorked;
	}
	public void setHrsWorked(int hrsWorked) {
		this.hrsWorked = hrsWorked;
	}
	@Override
	public double getPayment() {
		this.setSalary(this.getRate()*this.hrsWorked);
		return this.getSalary();
	}
	
	
}
