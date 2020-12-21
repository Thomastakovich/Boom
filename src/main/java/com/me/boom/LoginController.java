package com.me.boom;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.me.dao.AdminDao;
import com.me.dao.StudentDao;
import com.me.dao.TeacherDao;
import com.me.pojo.Admin;
import com.me.pojo.Student;
import com.me.pojo.Teacher;

@Controller
public class LoginController {
	
	@RequestMapping(value = "/login.htm", method = RequestMethod.GET)
	public String toLoginPage (HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		return "home";
	}
	
	@RequestMapping(value = "/login.htm", method = RequestMethod.POST)
	public String handlePostRequest(HttpServletRequest request, StudentDao studentdao, TeacherDao teacherDao, AdminDao adminDao) throws Exception {
				
		if (request.getAttribute("unsafe_request") == "true") {
			return "unsafe-page";
		}
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		String role = request.getParameter("role");
		if (role.equals("student")) {
			return studentLogin(request, username, password, studentdao);
		} else if (role.equals("teacher")) {
			return teacherLogin(username, password, teacherDao);
		} else if (role.equals("admin")) {
			return adminLogin(username, password, adminDao);
		} else {
			return "login-error-page";
		}
		
		
	}
	
	public static String studentLogin(HttpServletRequest request, String username, String password, StudentDao dao) throws Exception {
		Student student;
		student = dao.checkLogin(username, password);
		HttpSession session = request.getSession();
		
		
		if (student == null) {
			return "login-error-page";
		} else {
			session.setAttribute("id", student.getId());
			session.setAttribute("user", student);
			return "student-page";
		}
	}
	
	public static String teacherLogin(String username, String password, TeacherDao dao) {
		Teacher t;
		t = dao.checkLogin(username, password);
		
		if (t == null) {
			return "login-error-page";
		} else {
			return "welcome-page";
		}
	}
	
	public static String adminLogin(String username, String password, AdminDao dao) {
		Admin a;
		a = dao.checkLogin(username, password);
		
		if (a == null) {
			return "login-error-page";
		} else {
			return "admin-page";
		}
	}
	
	@RequestMapping(value = "/getTime.htm", method = RequestMethod.GET)
	@ResponseBody
	public String getTime() {
		return "Current Time: " + new Date();
	}
	
	
}
