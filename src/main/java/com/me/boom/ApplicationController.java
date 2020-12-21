package com.me.boom;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.me.dao.ApplicationDao;
import com.me.dao.CourseDao;
import com.me.dao.StudentDao;
import com.me.pojo.Application;
import com.me.pojo.Course;
import com.me.pojo.Student;

@Controller
public class ApplicationController {

	@RequestMapping(value = "/applications.htm", method = RequestMethod.GET)
	public String browseApplications(HttpServletRequest request, ApplicationDao dao) {
		try {
			List<Application> applications = dao.browseApplications();
			request.setAttribute("applications", applications);
			System.out.println(applications.size());
			request.setAttribute("number", applications.size());
		} catch (HibernateException e) {
			return "error-page";
		}
		return "browse-application-page";
	}
	
	@RequestMapping(value = "/handleApplication.htm", method = RequestMethod.POST)
	public String handleApplications(HttpServletRequest request, ApplicationDao appDao, StudentDao studentDao, CourseDao courseDao) throws Exception {
		String option = request.getParameter("option");
		String appId = request.getParameter("apps");
		if (appId == null) {
			return "nothing-handle-page";
		}
		if (option.equals("Deny")) {
			appDao.deleteApplication(appId);
			return "deny-application-success-page";
		}
		Application app = appDao.getApplicationById(appId);
		Student student = app.getStudent();
		Course course = app.getCourse();
		student.getCourses().add(course);
		course.getStudents().add(student);
		appDao.deleteApplication(appId);
		return "approve-application-success-page";
	}
	
}

