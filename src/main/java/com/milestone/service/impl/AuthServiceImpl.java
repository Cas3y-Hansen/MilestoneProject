package com.milestone.service.impl;

import org.springframework.stereotype.Service;
import com.milestone.service.AuthService;
import java.util.Map;

/**
 * Implementation of the {@link AuthService} interface that provides basic
 * authentication logic for verifying user credentials.
 * <p>
 * This implementation uses a simple hardcoded user map for demonstration
 * purposes. In a production environment, authentication would typically be
 * handled through a database or an external authentication service.
 * </p>
 * 
 * @author Casey
 * @version 1.0
 */
@Service
public class AuthServiceImpl implements AuthService {

    /**
     * A static, hardcoded map of valid usernames and passwords.
     * <p>
     * Currently, this map contains a single user entry:
     * <ul>
     *   <li>Username: {@code admin}</li>
     *   <li>Password: {@code password}</li>
     * </ul>
     * </p>
     */
    private static final Map<String, String> USERS = Map.of(
            "admin", "password"
    );

    /**
     * Authenticates a user by checking whether the provided username and password
     * match an entry in the {@link #USERS} map.
     *
     * @param username the username to authenticate; cannot be {@code null}
     * @param password the password to check against the stored credentials; cannot be {@code null}
     * @return {@code true} if the username exists and the password matches;
     *         {@code false} otherwise
     */
    @Override
    public boolean authenticate(String username, String password) {
        if (username == null || password == null) return false;
        String expected = USERS.get(username.trim());
        return expected != null && expected.equals(password);
    }
}
