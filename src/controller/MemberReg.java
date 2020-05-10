package controller;

public enum MemberReg {

	MusicLovers("Music Lover"), VideoLovers("Movies lover"), TvLover("Box Sets"), Premium("Sky is the limit");

	private String type;

	MemberReg(String type) {
		this.type = type;
	}

	public String gettype() {
		return this.type;
	}

}
