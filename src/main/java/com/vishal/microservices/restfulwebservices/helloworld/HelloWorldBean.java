package com.vishal.microservices.restfulwebservices.helloworld;

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
