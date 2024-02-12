package com.djourov.bankapp.validation.constraint;

import com.djourov.bankapp.validation.annotation.UuidChecker;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Optional;
import java.util.UUID;

public class UuidAnnotationChecker implements ConstraintValidator<UuidChecker, UUID> {
    private static final String UUID_PATTERN = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$";

    @Override
    public void initialize(UuidChecker constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(UUID value, ConstraintValidatorContext context) {
        return Optional.ofNullable(value)
                       .map(Object::toString)
                       .filter(s -> !s.isBlank())
                       .map(s -> s.matches(UUID_PATTERN))
                       .orElse(false);
    }
}