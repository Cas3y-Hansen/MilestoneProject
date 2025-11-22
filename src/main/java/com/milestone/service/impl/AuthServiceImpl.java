package com.milestone.service.impl;

import org.springframework.stereotype.Service;
<<<<<<< HEAD
import com.milestone.model.RegisterModel;
=======
>>>>>>> 89d1c399dd32c88b3f4aaa71c221fd83192f6e53
import com.milestone.repository.UserRepository;
import com.milestone.service.AuthService;


/**
 * Implementation of the {@link AuthService} interface that provides authentication
 * logic by verifying user credentials stored in the database.
 * <p>
 * This implementation uses {@link UserRepository} to check if a username exists
 * and whether the provided password matches the stored password.
 * </p>
 * 
 * @author Casey
 * @version 1.1
 */
@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    /**
     * Constructor to inject {@link UserRepository}.
     * @param userRepository repository used to access user data
     */
    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Authenticates a user by checking the username and password
     * against the stored user records in the database.
     *
     * @param username the username to authenticate; cannot be {@code null}
     * @param password the password to check against the stored credentials; cannot be {@code null}
     * @return {@code true} if the username exists and the password matches;
     *         {@code false} otherwise
     */
    @Override
    public boolean authenticate(String username, String password) {
        if (username == null || password == null) return false;

        return userRepository.findByUsername(username.trim())
                             .map(user -> user.getPassword().equals(password))
                             .orElse(false);
    }
}
