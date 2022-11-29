package com.vishal.microservices.restfulwebservices.dto;

public class HelloWorldBean {
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	String message;
	
	public HelloWorldBean(String message) {
		this.message = message;
	}

}
