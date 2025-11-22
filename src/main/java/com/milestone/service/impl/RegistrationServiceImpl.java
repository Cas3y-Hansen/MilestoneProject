package com.milestone.service.impl;

import com.milestone.model.RegisterModel;
import com.milestone.model.UserEntity;
import com.milestone.repository.UserRepository;
import com.milestone.service.RegistrationService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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

        // ❗ ENCRYPT the password here
        user.setPassword(encoder.encode(m.getPassword()));

        // Save encrypted user
        userRepository.save(user);

        return true;
    }
}
