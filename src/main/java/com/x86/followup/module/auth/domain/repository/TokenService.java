package com.x86.followup.module.auth.domain.repository;

import com.x86.followup.module.user.domain.model.User;

public interface TokenService {
    String generateToken(User user);
    String getUsernameFromToken(String token);
    boolean validateToken(String token);
    String getRoleFromToken(String token);
}
