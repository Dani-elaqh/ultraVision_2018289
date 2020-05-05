package controller;

public class Customer {
	
	private String fn;
	private String ln;
	private String phone;
	MemberReg st;
	private String cn;
	private String date;
	

public Customer (String fn, String ln, String phone, MemberReg st, String cn, String date) {
		
		this.fn = fn;
		this.ln = ln;
		this.phone =phone;
		this.st = st;
		this.cn = cn;
		this.date =date;
	}
	
	public String getName() {
		return fn;
	}
	
	public String getLastName() {
		return ln;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public MemberReg getst() {
		return st;
	}
	
	public String getCard() {
		return cn;
	}
	
	public String getdate() {
		return date;
	}
	
}
