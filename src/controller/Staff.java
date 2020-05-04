package controller;

/*Class in charge of getting the userId and the password 
 * for the staff to login
 * 
 */

public class Staff {

	private String un;
	private String pw;
	
	public Staff(String un, String pw) {
		
		this.un = un;
		this.pw = pw;
	}
	
	public String getUn() {
		return un;
	}
	
	public String getPw() {
		return pw;
	}
}
