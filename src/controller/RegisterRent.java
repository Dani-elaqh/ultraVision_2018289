package controller;

public class RegisterRent {

	private String Id;
	private String titleID;
	private String title;
	private String date;
	
	public RegisterRent (String Id, String titleID, String title, String date) {
		this.Id = Id;
		this.titleID = titleID;
		this.title = title;
		this.date = date;
	}
	
	public String getId() {
		return this.Id;
	}
	
	public String getTitleID() {
		return this.titleID;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public String getDate() {
		return this.date;
	}
}
