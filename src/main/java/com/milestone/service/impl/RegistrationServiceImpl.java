package com.milestone.service.impl;

<<<<<<< HEAD
import com.milestone.model.RegisterModel;
import com.milestone.model.UserEntity;
import com.milestone.repository.UserRepository;
import com.milestone.service.RegistrationService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

=======
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
>>>>>>> 89d1c399dd32c88b3f4aaa71c221fd83192f6e53
@Service
public class RegistrationServiceImpl implements RegistrationService {

    private final UserRepository userRepository;
<<<<<<< HEAD
    private final BCryptPasswordEncoder encoder;

    public RegistrationServiceImpl(UserRepository userRepository, BCryptPasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

=======

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
>>>>>>> 89d1c399dd32c88b3f4aaa71c221fd83192f6e53
    @Override
    public boolean register(RegisterModel m) {
        if (!m.getPassword().equals(m.getConfirmPassword())) {
            return false;
        }
<<<<<<< HEAD

        // Convert RegisterModel → UserEntity
        UserEntity user = new UserEntity();
        user.setFirstName(m.getFirstName());
        user.setLastName(m.getLastName());
        user.setEmail(m.getEmail());
        user.setPhoneNumber(m.getPhoneNumber());
        user.setUsername(m.getUsername());

        // ❗ ENCRYPT the password here
        user.setPassword(encoder.encode(m.getPassword()));

        // Save encrypted user
        userRepository.save(user);

=======
        // Save user to database
        userRepository.save(m);
>>>>>>> 89d1c399dd32c88b3f4aaa71c221fd83192f6e53
        return true;
    }
}
