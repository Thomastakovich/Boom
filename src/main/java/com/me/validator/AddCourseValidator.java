package com.me.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.me.pojo.Course;

public class AddCourseValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Course.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "error.name", "Name canno be empty!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "startTime", "error.startTime", "start Time cannot be empty!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "endTime", "error.endTime", "end Time cannot be empty!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "error.description", "Description cannot be empty");
	}

}
