package com.example.jenkins.controllers;
import java.util.List;

import org.hibernate.annotations.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jenkins.models.User;
import com.example.jenkins.services.UsersService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UsersService usersService;
	
	@GetMapping
	public List<User> getAllUsers() {
		
		return usersService.getAllUsers();
		
	}
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable int id) {
		User user=this.usersService.getUserById(id); 
		if(user!=null) {
			return ResponseEntity.ok(user);
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUserById(@PathVariable int id){
		boolean deleted=usersService.deleteUserById(id);
		if(deleted) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUserById(@PathVariable int id, @ModelAttribute User updatedUser){
		User user=this.usersService.updateUser(id, updatedUser);
		if(user!=null) {
			return ResponseEntity.ok(user);
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<User> addUser(@ModelAttribute User user) {
	    User createdUser = usersService.addUser(user);
	    return ResponseEntity.status(201).body(createdUser);
	}

	
//	@GetMapping("/profile")
//	public ResponseEntity<UserProfile> getProfile(HttpServletRequest request){
//		
//		Integer id=(Integer)request.getAttribute("id");
//		User foundUser= this.usersService.getUserById(id);
//		
//		UserProfile profile=new UserProfile(foundUser.getId(), foundUser.getNameString(), foundUser.getEmailString());
//		return ResponseEntity.ok(profile);
//		
//		
//	}
	
	
}

