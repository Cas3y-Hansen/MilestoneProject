package com.milestone.service.impl;

import org.springframework.stereotype.Service;
import com.milestone.model.RegisterModel;
import com.milestone.service.RegistrationService;


@Service
public class RegistrationServiceImpl implements RegistrationService {
  @Override
  public boolean register(RegisterModel m) {
    return m.getPassword().equals(m.getConfirmPassword());
  }
}