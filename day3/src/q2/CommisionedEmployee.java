package q2;

public class CommisionedEmployee extends Employee{
	private double sales;
	private double percent;
	public CommisionedEmployee() {
		super();
	}
	public CommisionedEmployee(int empId, String name, double sal, double rate,double sales,double percent) {
		super(empId, name, sal, rate);
		this.sales=sales;
		this.percent=percent;
	}
	public double getSales() {
		return sales;
	}
	public void setSales(double sales) {
		this.sales = sales;
	}
	public double getPercent() {
		return percent;
	}
	public void setPercent(double percent) {
		this.percent = percent;
	}
	
	@Override
	public double getPayment() {
		this.setSalary((this.getSales()*this.getPercent())/100);
		return this.getSalary();
	}
	
}
