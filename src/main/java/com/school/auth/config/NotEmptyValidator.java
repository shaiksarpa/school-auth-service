package com.school.auth.config;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;

public class NotEmptyValidator implements ConstraintValidator<RequiredParam, String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return StringUtils.isNotEmpty(value);
	}

}
