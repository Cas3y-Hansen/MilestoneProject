package com.milestone.service;

import com.milestone.model.RegisterModel;

/**
 * Service interface for handling user registration in the library system.
 * 
 * <p>Provides a method to register a user based on a {@link RegisterModel} object.
 * Implementations may perform validation and store user data in memory or in a database.</p>
 * 
 * @author Casey
 * @version 1.0
 */
public interface RegistrationService {

    /**
     * Registers a new user.
     * 
     * @param model the {@link RegisterModel} containing user registration details
     * @return {@code true} if the registration is successful (e.g., passwords match),
     *         {@code false} otherwise
     */
    boolean register(RegisterModel model);
}
