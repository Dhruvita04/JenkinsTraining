package com.example.jenkins.models;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/")
@RestController
public class HelloController {
	
	@GetMapping
	public static void main(String[] args) {
		System.out.println("Hello world");
	}

}
