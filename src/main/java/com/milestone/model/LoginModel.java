package com.milestone.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * Model class for user login form data
 */
public class LoginModel {
	
	@NotNull(message="User name is a required field")
	@Size(min=1, max=32, message="User name must be between 1 and 32 characters")
    private String username;
	
	@NotNull(message="Password is a required field")
	@Size(min=1, max=32, message="Password must be between 1 and 32 characters")
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