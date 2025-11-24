package com.milestone.service.impl;

import com.milestone.model.RegisterModel;
import com.milestone.model.UserEntity;
import com.milestone.repository.UserRepository;
import com.milestone.service.RegistrationService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Implementation of the {@link RegistrationService} interface.
 *
 * <p>This service handles user registration, including validation and saving
 * user data to the database with encrypted passwords.</p>
 *
 * @author Casey
 * @version 1.1
 */
@Service
public class RegistrationServiceImpl implements RegistrationService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    public RegistrationServiceImpl(UserRepository userRepository, BCryptPasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    @Override
    public boolean register(RegisterModel m) {

        // Validate password match
        if (!m.getPassword().equals(m.getConfirmPassword())) {
            return false;
        }

        // Convert RegisterModel → UserEntity
        UserEntity user = new UserEntity();
        user.setFirstName(m.getFirstName());
        user.setLastName(m.getLastName());
        user.setEmail(m.getEmail());
        user.setPhoneNumber(m.getPhoneNumber());
        user.setUsername(m.getUsername());

        // Encrypt password
        user.setPassword(encoder.encode(m.getPassword()));

        // Save user
        userRepository.save(user);

        return true;
    }
}
