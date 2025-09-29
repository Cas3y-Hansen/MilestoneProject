package com.milestone.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * Model class for user registration form data
 */
public class RegisterModel {

    @NotNull(message = "First name is required")
    @Size(min = 1, max = 32)
    private String firstName;

    @NotNull(message = "Last name is required")
    @Size(min = 1, max = 32)
    private String lastName;

    @NotNull(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    @NotNull(message = "Phone number is required")
    @Size(min = 10, max = 15, message = "Phone number must be valid")
    private String phoneNumber;

    @NotNull(message = "Username is required")
    @Size(min = 1, max = 32)
    private String username;

    @NotNull(message = "Password is required")
    @Size(min = 1, max = 32)
    private String password;

    @NotNull(message = "Confirm Password is required")
    private String confirmPassword;

    // Getters and Setters for all fields
    /** @return the first name */
    public String getFirstName() { return firstName; }
    /** @param firstName the first name to set */
    public void setFirstName(String firstName) { this.firstName = firstName; }

    /** @return the last name */
    public String getLastName() { return lastName; }
    /** @param lastName the last name to set */
    public void setLastName(String lastName) { this.lastName = lastName; }

    /** @return the email address */
    public String getEmail() { return email; }
    /** @param email the email address to set */
    public void setEmail(String email) { this.email = email; }

    /** @return the phone number */
    public String getPhoneNumber() { return phoneNumber; }
    /** @param phoneNumber the phone number to set */
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    /** @return the username */
    public String getUsername() { return username; }
    /** @param username the username to set */
    public void setUsername(String username) { this.username = username; }

    /** @return the password */
    public String getPassword() { return password; }
    /** @param password the password to set */
    public void setPassword(String password) { this.password = password; }

    /** @return the confirm password */
    public String getConfirmPassword() { return confirmPassword; }
    /** @param confirmPassword the confirm password to set */
    public void setConfirmPassword(String confirmPassword) { this.confirmPassword = confirmPassword; }
}
