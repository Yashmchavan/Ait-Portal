package com.springrest.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.springrest.springrest.entities.User;
import com.springrest.springrest.services.UserService;

@RestController
@RequestMapping("/users")
public class MyController {
	
	@Autowired
	private UserService userService;
	
	//get the users
	@GetMapping("/all")
	//@CrossOrigin(origins = "http://localhost:4200")
	public List<User> getUsers()
	{
		return this.userService.getUsers();
	}
	
	//add the users
//	@PostMapping("/users")
//	public User addUser(@RequestBody User user)
//	{
//		return this.userService.addUser(user);
//	}
	
	@PostMapping("/add")
	//@CrossOrigin(origins = "http://localhost:4200")
	public User addUser(@RequestBody User user)throws Exception{
		String tempEmailId = user.getEmail();
		if(tempEmailId!= null && !"".equals(tempEmailId)) {
			User userobj = userService.fetchUserByEmailId(tempEmailId);
			if(userobj!=null) {
				throw new Exception("user with"+" "+tempEmailId+" "+"is already exist");
			}
		}
//		User userobj = null;
//		userobj = userService.addUser(user);
//		return userobj;
		return this.userService.addUser(user);
	}
	
	
	
	
	
	
	//update the user
	@PutMapping("/update")
	//@CrossOrigin(origins = "http://localhost:4200")
	public User updateUser(@RequestBody User user)
	{
		return this.userService.updateUser(user);
	}
	
	//delete the user
	@DeleteMapping("/delete/{userId}")
	//@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<HttpStatus> deleteUser(@PathVariable String userId){
		try {
			this.userService.deleteUser(Long.parseLong(userId));
			return new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//Login api
	@PostMapping("/login")
	//@CrossOrigin(origins = "http://localhost:4200")
	public User loginUser(@RequestBody User user) throws Exception
	{
		String tempEmailId = user.getEmail();
		String tempPass = user.getPassword();
		User userObj = null;
		if(tempEmailId != null && tempPass != null) 
		{
			userObj = userService.fetchUserByEmailIdAndPassword(tempEmailId, tempPass);
		}
		if(userObj == null) {
			throw new Exception("Bad Credentials");
		}
		return userObj;
	}
	
	
}
