package controller;

public class Customer {

	private String fn;
	private String ln;
	private String Email;
	private String type;
	private String Card;
	private String date;

	public Customer(String fn, String ln, String email, String type, String Card, String date) {

		this.fn = fn;
		this.ln = ln;
		this.Email = email;
		this.type = type;
		this.Card = Card;
		this.date = date;
	}

	public String getFirstName() {
		return this.fn;
	}

	public String getLastName() {
		return this.ln;
	}

	public String getEmail() {
		return this.Email;
	}

	public String getCard() {
		return this.Card;
	}

	public String getDate() {
		return this.date;
	}

	public boolean isEmail(String Email) {

		boolean isEmail = Email.matches("\\b[\\w\\.-]+@[\\w\\.-]+\\.\\w{2,4}\\b");
		return isEmail;

	}

	public String gettype() {
		return type;
	}

	public boolean isCard(String Card) {

		return Card.matches("(\\d{4}[-. ]?){4}|\\d{4}[-. ]?\\d{6}[-. ]?\\d{5}");

	}

	public boolean isDate(String date) {

		return date.matches("(\\d\\d\\/\\d{2}\\W");
	}

}
