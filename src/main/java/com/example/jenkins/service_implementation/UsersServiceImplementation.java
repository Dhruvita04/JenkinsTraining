package com.example.jenkins.service_implementation;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jenkins.models.User;
import com.example.jenkins.repositories.UsersRepository;
import com.example.jenkins.services.UsersService;

@Service
public class UsersServiceImplementation implements UsersService{

	@Autowired   
	private UsersRepository us;
		
	private List<User> users=new ArrayList<>();
	
	public UsersServiceImplementation() {

	}
	
	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return this.us.findAll();
	}

	@Override
	public User getUserById(int id) {
			Optional<User> identity=this.us.findById(id);
			if(identity.isPresent()) {
				return identity.get();
			
		}
		return null;
		// TODO Auto-generated method stub
	}

	@Override
	public User insertUser(User newUser) {
//		this.users.add(newUser);
		User createdUsersRepositry= this.us.save(newUser);
		// TODO Auto-generated method stub
		return createdUsersRepositry;
	}
	
	@Override
	public User updateUser(int id, User updatedUser) {
		
		User existingUser=us.findById(id).orElse(null);
		if(existingUser==null) {
		    return null;
		}
		existingUser.setNameString(updatedUser.getNameString());
		existingUser.setEmailString(updatedUser.getEmailString());
		existingUser.setPasswordString(updatedUser.getPasswordString());
		
		return us.save(updatedUser);
		
	}
	
	@Override
	public boolean deleteUserById(int id) {
		if(us.existsById(id)) {
			us.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		return us.save(user);
	}

}