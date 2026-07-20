package com.example.jenkins.models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
 
@Entity 
@Table(name = "users")
public class User {
	@Id    
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int id;
	

	@Column(nullable = false)
	private String nameString;
	
	@Column(nullable = false,unique = true)
	
	private String emailString;
	
	@Column(nullable = false)
	
	private String passwordString;
	
	
	public User() {
		super();
	}
	public User(int id, String nameString, String emailString, String passwordString) {
		super();
		this.id = id;
		this.nameString = nameString;
		this.emailString = emailString;
		this.passwordString = passwordString;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNameString() {
		return nameString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	public String getEmailString() {
		return emailString;
	}
	public void setEmailString(String emailString) {
		this.emailString = emailString;
	}
	public String getPasswordString() {
		return passwordString;
	}
	public void setPasswordString(String passwordString) {
		this.passwordString = passwordString;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", nameString=" + nameString + ", emailString=" + emailString + ", passwordString="
				+ passwordString + "]";
	}
	
	

}