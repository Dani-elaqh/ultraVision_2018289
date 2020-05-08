package controller;

public class Box {

	private String title;
	private String season;
	private String genre;
	private String free;

	public Box(String title, String season, String genre, String free) {
		this.title = title;
		this.season = season;
		this.genre = genre;
		this.free = free;
	}

	public String getTitle() {
		return title;
	}

	public String getSeason() {
		return season;
	}

	public String getGenre() {
		return genre;
	}

	public String getRented() {
		return free;
	}
}
