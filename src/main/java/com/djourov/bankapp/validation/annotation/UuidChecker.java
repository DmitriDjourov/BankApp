package com.djourov.bankapp.validation.annotation;

import com.djourov.bankapp.validation.constraint.UuidAnnotationChecker;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UuidAnnotationChecker.class)
public @interface UuidChecker {
    String message() default "Uuid не проходит валидацию ! ";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
