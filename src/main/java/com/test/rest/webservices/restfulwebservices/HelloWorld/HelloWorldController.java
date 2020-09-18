package com.test.rest.webservices.restfulwebservices.HelloWorld;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	//GET
	//URI -/hello-world
	//method -HelloWorld
	
   //@RequestMapping(method= RequestMethod.GET,path="/hello-world") 
	
	@GetMapping(path = "/hello-world")
	public String helloWorld()
	{
		return "Hello Worlds";
	}
	//Returning a HelloWorld Bean
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean()
	{
		return new HelloWorldBean("Hello World");
	}
	//PathvariableExample: http://localhost:8080/hello-world-bean/path-variable/Mayuresh%20Bhola
	@GetMapping(path = "/hello-world-bean/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name)
	{
		return new HelloWorldBean(String.format("Hello World , %s",name));
	}

}
