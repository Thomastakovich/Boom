package com.me.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.me.pojo.Teacher;

public class AddTeacherValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Teacher.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		// TODO Auto-generated method stub
		Teacher teacher = (Teacher) obj;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "error.firstName", "First name cannot be empty!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "error.lastName", "Last name cannot be empty!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "error.userName", "Username cannot be empty!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.password", "Password cannot be empty!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "zoomId", "error.zoomId", "Zoom ID cannot be empty!");
	}

}
