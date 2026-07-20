package com.example.jenkins.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jenkins.models.User;

import java.util.List;


@Repository
public interface UsersRepository extends JpaRepository<User, Integer> {
	
	User findByEmailString(String emailString);
	
}
