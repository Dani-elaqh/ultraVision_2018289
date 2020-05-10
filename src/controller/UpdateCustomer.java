package controller;

public class UpdateCustomer {

	private String id;
	private String name;
	private String lname;
	private String mail;
	private String member;
	private String Card;
	private String expDate;

	public UpdateCustomer(String id, String name, String lname, String mail, String member, String Card,
			String expDate) {

		this.id = id;
		this.name = name;
		this.lname = lname;
		this.mail = mail;
		this.member = member;
		this.Card = Card;
		this.expDate = expDate;

	}

	public String getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public String getLname() {
		return this.lname;
	}

	public String getMail() {
		return this.mail;
	}

	public String getMember() {
		return this.member;
	}

	public String getCardN() {
		return this.Card;
	}

	public String getExpDate() {
		return this.expDate;
	}
}
