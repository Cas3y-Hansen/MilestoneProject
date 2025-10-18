package com.milestone.service.impl;

import org.springframework.stereotype.Service;

import com.milestone.service.AuthService;

import java.util.Map;

@Service
public class AuthServiceImpl implements AuthService {

    // Simple hardcoded user store; extend if you want more users
    private static final Map<String, String> USERS = Map.of(
            "admin", "password"
    );

    @Override
    public boolean authenticate(String username, String password) {
        if (username == null || password == null) return false;
        String expected = USERS.get(username.trim());
        return expected != null && expected.equals(password);
    }
}