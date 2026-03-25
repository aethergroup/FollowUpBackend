package com.x86.followup.module.user.domain.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.regex.Pattern;

@RequiredArgsConstructor
@Getter
public class UserPhone {
    private static final String COLOMBIA_PHONE_PATTERN = "^3[0-9]{9}$";
    private static final Pattern PATTERN = Pattern.compile(COLOMBIA_PHONE_PATTERN);

    private final String value;

    public boolean isValidPhone() {
        if (value == null) {
            return false;
        }
        String cleanValue = value.replaceAll("[\\s-]", "");
        return PATTERN.matcher(cleanValue).matches();
    }

}
