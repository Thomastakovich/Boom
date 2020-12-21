package com.me.boom;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.me.dao.StudentDao;
import com.me.pojo.Student;
import com.me.validator.StudentRegisterValidator;

@Controller
public class RegisterController {
	@Autowired
	StudentRegisterValidator studentRegisterValidator;
	
	
	@RequestMapping(value = "/register.htm", method = RequestMethod.POST)
	public String register(@ModelAttribute("student") Student student, BindingResult result, SessionStatus status, HttpServletRequest request, StudentDao studentdao) throws Exception {
		if (request.getAttribute("unsafe_request") == "true") {
			return "unsafe-page";
		}
		
		
		studentRegisterValidator.validate(student, result);
		if (result.hasErrors()) {
			return "register-page";
		}
		status.setComplete();
		
		try {
			studentdao.createStudent(student.getFirstName(), student.getLastName(), student.getUserName(), student.getPassword(), student.getEmail(), student.getZoomId());
		} catch (HibernateException e) {
			return "error-page";
		}
		
		return "register-success-page";
	}
	
	@RequestMapping(value = "/register.htm", method = RequestMethod.GET)
	public String goToRegister(ModelMap model, Student student) {
		return "register-page";
	}
}
