package q2;

public class Invoice implements Payable{
	private String partNum;
	private String partDesciption;
	private int qty;
	private double pricePerItem;
	public Invoice(String partNum, String partDesciption, int qty, double pricePerItem) {
		super();
		this.partNum = partNum;
		this.partDesciption = partDesciption;
		this.qty = qty;
		this.pricePerItem = pricePerItem;
	}
	public String getPartNum() {
		return partNum;
	}
	public void setPartNum(String partNum) {
		this.partNum = partNum;
	}
	public String getPartDesciption() {
		return partDesciption;
	}
	public void setPartDesciption(String partDesciption) {
		this.partDesciption = partDesciption;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public double getPericePerItem() {
		return pricePerItem;
	}
	public void setPericePerItem(double pericePerItem) {
		this.pricePerItem = pericePerItem;
	}
	@Override
	public String toString() {
		StringBuilder builder=new StringBuilder();
		builder.append("Invoice \n partNum : ").append(partNum).append("\n partDescription : ").append(partDesciption).append("\n quantity : ").append(qty).append("\n price per item : ").append(pricePerItem);
		
		return builder.toString();
	}
	
	@Override
	public double getPayment() {
		return pricePerItem*qty;
	}
	
	

}
