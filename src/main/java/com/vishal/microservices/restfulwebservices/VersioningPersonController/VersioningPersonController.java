package com.vishal.microservices.restfulwebservices.VersioningPersonController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {
	
	@GetMapping("/v1/person")
	public Person getFirstVersionOfPerson() {
		return new Person("vishal pundir");
	}
	
	@GetMapping("/v2/person")
	public Personv2 getSecondVersionOfPerson() {
		return new Personv2(new Name("vishal", "pundir"));
	}
	
	@GetMapping(path = "/person", params = "version=1")
	public Person getFirstVersionOfPersonRequestParameter() {
		return new Person("vishal pundir");
	}
	
	@GetMapping(path = "person", params = "version=2")
	public Personv2 getSecondVersionOfPersonRequestParameter() {
		return new Personv2(new Name("vishal", "pundir"));
	}
	
}
