package com.milestone.service.impl;

import org.springframework.stereotype.Service;

import com.milestone.model.RegisterModel;
import com.milestone.repository.UserRepository;
import com.milestone.service.RegistrationService;

/**
 * Implementation of the {@link RegistrationService} interface.
 * 
 * <p>This service provides simple registration logic for users. Currently,
 * it validates the registration by checking that the password and confirm password
 * fields match, and then saves the user to the database using Spring Data JDBC.</p>
 *
 * @author Casey
 * @version 1.1
 */
@Service
public class RegistrationServiceImpl implements RegistrationService {

    private final UserRepository userRepository;

    /**
     * Constructor to inject {@link UserRepository}.
     * @param userRepository repository used to persist user data
     */
    public RegistrationServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Registers a user by validating that the password and confirm password
     * fields in the {@link RegisterModel} are equal. If valid, saves
     * the user to the database.
     * 
     * @param m the {@link RegisterModel} containing user registration data
     * @return {@code true} if passwords match and user saved, {@code false} otherwise
     */
    @Override
    public boolean register(RegisterModel m) {
        if (!m.getPassword().equals(m.getConfirmPassword())) {
            return false;
        }
        // Save user to database
        userRepository.save(m);
        return true;
    }
}
