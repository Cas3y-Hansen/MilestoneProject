package com.milestone.service;

/**
 * Service interface for user authentication.
 * 
 * <p>Defines a contract for authenticating users based on a username and password.
 * Implementations may validate against a database, in-memory store, or external service.</p>
 * 
 * @author Casey
 * @version 1.0
 */
public interface AuthService {

    /**
     * Authenticates a user with the provided username and password.
     * 
     * @param username the username of the user to authenticate
     * @param password the password of the user to authenticate
     * @return {@code true} if the credentials are valid; {@code false} otherwise
     */
    boolean authenticate(String username, String password);
}
