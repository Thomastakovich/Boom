package com.me.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.me.pojo.Student;

public class StudentRegisterValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Student.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		// TODO Auto-generated method stub
		Student stu = (Student) obj;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "error.firstName", "firstName cannot be empty!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "error.lastName", "lastName cannot be empty!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "error.userName", "userName cannot be empty!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.password", "password cannot be empty!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "error.email", "email cannot be empty!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "zoomId", "error.zoomId", "zoomId cannot be empty!");
	}

}
