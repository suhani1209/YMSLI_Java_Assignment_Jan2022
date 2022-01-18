package q1;

public class HourlyEmployee extends Employee{
	private int numberOfHrsWorked;

	public HourlyEmployee() {
		super();
	}

	public HourlyEmployee(int empId, String empName, double rate, double salary,int hrs) {
		super(empId, empName, rate, salary);
		this.numberOfHrsWorked=hrs;
	}

	@Override
	public void calSalary() {
		this.setSalary(this.getRate()*numberOfHrsWorked);
	}
	public double incrementSal(double rate) {
		this.setRate(this.getRate()+rate);
		calSalary();
		return this.getSalary();
	}
	
	
}
