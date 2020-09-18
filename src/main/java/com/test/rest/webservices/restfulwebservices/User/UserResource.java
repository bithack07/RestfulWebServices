package com.test.rest.webservices.restfulwebservices.User;

import java.net.URI;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;





@RestController
public class UserResource {

	@Autowired
	private UserDaoService service;

	// retriveAllUsers
	@GetMapping("/users")
	public List<User> retriveALLUsers() {
		return service.findAll();

	}

	// retriveUser(int Id)
	@GetMapping("/users/{id}")
	public User retreiveUser(@PathVariable int id) {
		return service.findOne(id);

	}

	// Add User(Post Mapping is used to create something)
	// Method Input: Details Of User
	// Method Output: CREATED & return the created URI
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@RequestBody User user) {
		User savedUser = service.save(user);
		//return String.format("The Link for the new user is : http://localhost:8080/users/%s", savedUser.getId());
		//To get the response from current request
          URI location=ServletUriComponentsBuilder
		.fromCurrentRequest()
		.path("/{id}")
		.buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();

	}

}
