package controller;

public class Concert {

	private String title;
	private String artist;
	private String year;
	private String genre;
	private String free;
	private String format;
	
	public Concert (String title, String artist, String year, String genre, String free, String format) {
		
		this.title = title;
		this.artist = artist;
		this.year = year;
		this.genre = genre;
		this.free = free;
		this.format = format;
		
	}
	
	
	
	public String getTitle() {
		return this.title;
	}
	public String getArtist() {
		return this.artist;
	}
	public String getYear() {
		return this.year;
	}
	
	public String getGenre() {
		return this.genre;
	}
	
	public String getRented() {
		return this.free;
	}
	
	public String getFormat() {
		return this.format;
	}
}
