package com.x86.followup.module.auth.domain.repository;

public interface AuthRepository {
    String encode (String password);
    boolean matches(String rawPassword, String encodedPassword);
}
