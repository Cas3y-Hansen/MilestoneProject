package com.milestone.model;

import jakarta.validation.constraints.NotBlank;
/**
 * Model class for user login form data
 */
public class LoginModel {
	
	@NotBlank(message="Username is a required field")
    private String username;
	
	@NotBlank(message="Password is a required field")
    private String password;

    // Getters
    /** @return the username */
    public String getUsername() {
        return username;
    }

    /** @return the password */
    public String getPassword() {
        return password;
    }

    // Setters
    /** @param username the username to set */
    public void setUsername(String username) {
        this.username = username;
    }

    /** @param password the password to set */
    public void setPassword(String password) {
        this.password = password;
    }
}