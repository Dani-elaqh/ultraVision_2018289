package controller;

public class Movies {

	private String director;
	private String title;
	private String year;
	private String genre;
	private String free;
	
	public Movies (String director, String title, String year, String genre, String free) {
		this.director = director;
		this.title = title;
		this.year = year;
		this.genre = genre;
		this.free = free;
	}
	public String getDir() {
		return this.director;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public String getYear() {
		return this.year;
	}
	
	public String getGenre() {
		return this.genre;
	}
	
	public String getRent() {
		return this.free;
	}
}
