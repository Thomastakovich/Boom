package com.me.boom;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.me.dao.StudentDao;
import com.me.pojo.Student;

@Controller
public class LoginController {
	@RequestMapping(value = "login.htm", method = RequestMethod.POST)
	public String handlePostRequest(HttpServletRequest request, StudentDao studentdao) {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Student student;
		student = studentdao.checkLogin(username, password);
		if (student == null) {
			return "error-page";
		} else {
			return "welcome-page";
		}
		
	}
}
