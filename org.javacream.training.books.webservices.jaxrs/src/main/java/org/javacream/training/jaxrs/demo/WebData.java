package org.javacream.training.jaxrs.demo;

public class WebData {

	private String message;
	private int number;
	public WebData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public WebData(String message, int number) {
		super();
		this.message = message;
		this.number = number;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
}
