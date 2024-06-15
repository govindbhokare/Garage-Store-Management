package com.servicemanagement.model;


public class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private String role;

    // Getters and setters for all fields

    
    public User(String username2, String password2, String email2, String role) {
		// TODO Auto-generated constructor stub
    	username=username2;
    	password=password2;
    	email=email2;
    	this.role=role;
	}


	public User() {
		// TODO Auto-generated constructor stub
	}


	public int getId() {
        return id;
    }

    
	public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + ", role="
				+ role + "]";
	}
    
}
