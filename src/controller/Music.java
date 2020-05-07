package controller;

public class Music {

	private String artist;
	private String title;
	private String year;
	private String rent;
	
	public Music (String artist, String title, String year, String rent) {
		this.artist = artist;
		this.title = title;
		this.year = year;
		this.rent = rent;
	}
	
	public String getArtist() {
		return this.artist;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public String getYear() {
		return this.year;
	}
	
	public String getRented() {
		return this.rent;
	}
}
