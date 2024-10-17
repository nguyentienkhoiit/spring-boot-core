package com.khoinguyen.core.util;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class PhoneValidator implements ConstraintValidator<PhoneNumber, String> {

    private static final String PHONE_PATTERN = "^\\+?[0-9. ()-]{7,25}$";

    @Override
    public void initialize(PhoneNumber constraintAnnotation) {
        // Khởi tạo nếu cần (có thể không cần trong trường hợp này)
    }

    @Override
    public boolean isValid(String phone, ConstraintValidatorContext context) {
        if (phone == null || phone.isEmpty()) {
            return false;
        }
        return Pattern.matches(PHONE_PATTERN, phone);
    }
}