package com.test.rest.webservices.restfulwebservices.HelloWorld;

public class HelloWorldBean{
	
	private String message;

	@Override
	public String toString() {
		return "HelloWorldBean [heya=" + message + "]";
	}

	
	  public String getMessage() { return message; }
	 
	public void setMessage(String message) {
		this.message = message;
	}

	
	
	public HelloWorldBean(String message) {
		
		this.message=message;
		// TODO Auto-generated constructor stub
	}
	

}
