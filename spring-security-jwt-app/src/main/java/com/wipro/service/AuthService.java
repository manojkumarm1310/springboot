package com.wipro.service;

import com.wipro.dto.LoginDto;

public interface AuthService {
    String login(LoginDto loginDto);
}