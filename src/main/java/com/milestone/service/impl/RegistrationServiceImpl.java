package com.milestone.service.impl;

import org.springframework.stereotype.Service;

import com.milestone.model.RegisterModel;
import com.milestone.service.RegistrationService;

/**
 * Implementation of the {@link RegistrationService} interface.
 * 
 * <p>This service provides simple registration logic for users. Currently,
 * it validates the registration by checking that the password and confirm password
 * fields match.</p>
 *
 * <p><b>Note:</b> This implementation does not persist data to a database and
 * is intended for demonstration purposes only.</p>
 * 
 * @author Casey
 * @version 1.0
 */
@Service
public class RegistrationServiceImpl implements RegistrationService {

    /**
     * Registers a user by validating that the password and confirm password
     * fields in the {@link RegisterModel} are equal.
     * 
     * @param m the {@link RegisterModel} containing user registration data
     * @return {@code true} if passwords match, {@code false} otherwise
     */
    @Override
    public boolean register(RegisterModel m) {
        return m.getPassword().equals(m.getConfirmPassword());
    }
}
