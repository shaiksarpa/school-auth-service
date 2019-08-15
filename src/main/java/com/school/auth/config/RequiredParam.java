package com.school.auth.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Constraint(validatedBy = { NotEmptyValidator.class })
public @interface RequiredParam {

	String message() default "{customMessage} is required.";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	String customMessage() default "";

}
