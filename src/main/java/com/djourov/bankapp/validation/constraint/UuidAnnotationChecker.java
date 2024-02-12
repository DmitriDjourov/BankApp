package com.djourov.bankapp.validation.constraint;

import com.djourov.bankapp.validation.annotation.UuidChecker;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UuidAnnotationChecker implements ConstraintValidator<UuidChecker, String> {
    @Override
    public void initialize(UuidChecker constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return true;
    }
}
