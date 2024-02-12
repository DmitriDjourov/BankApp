package com.djourov.bankapp.validation.annotation;

import com.djourov.bankapp.validation.constraint.UuidAnnotationChecker;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {UuidAnnotationChecker.class})
public @interface UuidChecker {

    String message() default "Invalid UUID format !!!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}