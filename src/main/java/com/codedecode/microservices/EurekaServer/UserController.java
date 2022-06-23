
package com.codedecode.microservices.EurekaServer;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserService userservice;

	@GetMapping("/users")
	public ResponseEntity<List<User>> users() {
		List<User> users = new ArrayList<>();
		users.add(new User(1, "Ramesh"));
		users.add(new User(2, "Tony"));
		users.add(new User(3, "Tom"));
		HttpHeaders headers = new HttpHeaders();
		headers.add("Responded", "UserController");
		return ResponseEntity.accepted().headers(headers).body(users);
	}

	/*
	 * @GetMapping("/users1")
	 * 
	 * @ResponseBody public List < User > users1() { List < User > users = new
	 * ArrayList < > (); users.add(new User(1, "Ramesh")); users.add(new User(2,
	 * "Tony")); users.add(new User(3, "Tom")); return users;
	 */

	@PostMapping("/addusers")
	public String addallusers(@RequestBody List<User> u) {
		return userservice.addallusers(u);
	}

	@GetMapping("/getUsers")
	public ResponseEntity<List<User>> getUser() {
		List<User> use = userservice.getUser();
		if (!use.isEmpty()) {
			return new ResponseEntity<>(use, HttpStatus.OK);
		} else {
			throw new UserNotFoundException("Invalid user"); // new obj
		}
	}
	
	@GetMapping("/getusers/{id}")
	public ResponseEntity getUserId(@PathVariable Integer id) {
		
		if (id<1) {
			throw new IdNotFoundException("Invalid Id"); // new obj
		} 
		else {
			List<User> use1 = (List<User>) userservice.getUserId(id);
		
			return new ResponseEntity(id, HttpStatus.OK);
		}
	
		
	}
	
	
	
	@DeleteMapping("/delete")                                  
	public String deleteInformation() {
		return userservice.deleteInformation();
	}

}
