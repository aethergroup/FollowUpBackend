package com.x86.followup.module.user.domain.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.regex.Pattern;

@RequiredArgsConstructor
@Getter
public class UserIdentification {
    private static final String ID_PATTERN = "^[0-9]{7,12}$";
    private static final Pattern PATTERN = Pattern.compile(ID_PATTERN);

    private final String value;

    public boolean isValid() {
        if (value == null) {
            return false;
        }
        String cleanValue = value.replaceAll("[\\s.]", "");
        return PATTERN.matcher(cleanValue).matches();
    }
}
