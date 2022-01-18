package q1;

abstract public class Employee implements Payable{
	private int empId;
	private String empName;
	private double rate;
	private double salary;
	public Employee() {}
	public Employee(int empId, String empName,double rate,double salary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.rate=rate;
		this.salary=salary;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getEmpId() {
		return empId;
	}
	public String getEmpName() {
		return empName;
	}
	
	
	
}