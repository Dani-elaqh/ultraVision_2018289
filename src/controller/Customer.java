package controller;

public class Customer {
	
	private String fn;
	private String ln;
	private String phone;
	private String type;
	private String cn;
	private String date;
	

	public Customer (String fn, String ln, String phone, String type, String cn, String date) {
		
		this.fn = fn;
		this.ln = ln;
		this.phone =phone;
		this.type = type;
		this.cn = cn;
		this.date =date;
	}
	
	public String getFirstName() {
		return fn;
	}
	
	public String getLastName() {
		return ln;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public String gettype() {
		return type;
	}
	
	public String getCard() {
		return cn;
	}
	
	public String getdate() {
		return date;
	}
	
}
