package q2;

abstract class Employee implements Payable{
	private int empId;
	private String empName;
	private double salary;
	private double rate;
	
	Employee(){}
	public Employee(int empId,String name,double sal,double rate) {
		this.empId = empId;
		this.empName=name;
		this.salary=sal;
		this.rate=rate;
	}
	public int getEmpId() {
		return empId;
	}
	public String getEmpName() {
		return empName;
	};
	
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public double getSalary() {
		return salary;
	}
	public double getPayment() {
		return salary;
	}
	
}
