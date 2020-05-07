package controller;

public enum Rent {

	AVAILABLE("FALSE");
	
	private String free;
	
	Rent(String free){
		this.free = free;
	}
	
	public String getFree() {
		return this.free;
	}
}
