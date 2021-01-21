package com.me.boom;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.me.dao.CourseDao;
import com.me.dao.TeacherDao;
import com.me.pojo.Course;
import com.me.pojo.Teacher;
import com.me.validator.AddCourseValidator;
import com.me.validator.AddTeacherValidator;

@Controller
public class AdminController {
	@Autowired
	AddCourseValidator addCourseValidator;
	@Autowired
	AddTeacherValidator addTeacherValidator;

	@RequestMapping(value = "/addCourse.htm", method = RequestMethod.GET)
	public String goToAddCoursePage(ModelMap model, Course course) {
		return "add-course-page";
	}
	
	@RequestMapping(value = "/addCourse.htm", method = RequestMethod.POST)
	public String addCourse(@ModelAttribute("course") Course course, BindingResult result, SessionStatus status, HttpServletRequest request, CourseDao dao) throws Exception {
		if (request.getAttribute("unsafe_request") == "true") {
			return "unsafe-page";
		}
		
		addCourseValidator.validate(course, result);
		if (result.hasErrors()) {
			System.out.println("err");
			return "add-course-page";
		}
		status.setComplete();
		
		try {
			dao.createCourse(course.getName(), course.getStartDate(), course.getEndDate(), course.getStartTime(), course.getEndTime(), course.getDescription());
		} catch (HibernateException e) {
			return "error-page";
		}
		return "add-course-success-page";
	}
	
	@InitBinder     
	public void initBinder(WebDataBinder binder){
		SimpleDateFormat dateFormat = new SimpleDateFormat( "yyyy-MM-dd");
	     binder.registerCustomEditor(       Date.class,     
	                         new CustomDateEditor(dateFormat, true, 10));   
	}

	@RequestMapping(value = "/browseCourses.htm", method = RequestMethod.GET)
	public String browseCourse(HttpServletRequest request, CourseDao dao) throws Exception {
		try {
			List<Course> courses = dao.browseCourses();
			request.setAttribute("courses", courses);
			System.out.println(courses.size());
			for (Course c : courses) {
				System.out.println(c.getName() + " " + c.getId());
			}
		} catch (HibernateException e) {
			return "error-page";
		}
		return "browse-course-page";
	}
	
	@RequestMapping(value = "/addTeacher.htm", method = RequestMethod.GET)
	public String goToAddTeacherPage(ModelMap model, Teacher teacher) {
		return "add-teacher-page";
	}
	
	@RequestMapping(value = "/addTeacher.htm", method = RequestMethod.POST)
	public String addTeacher(@ModelAttribute("teacher") Teacher teacher, BindingResult result, SessionStatus status, HttpServletRequest request, TeacherDao dao) throws Exception {
		if (request.getAttribute("unsafe_request") == "true") {
			return "unsafe-page";
		}
		
		addTeacherValidator.validate(teacher, result);
		if (result.hasErrors()) {
			System.out.println("Errors!");
			return "add-teacher-page";
		}
		status.setComplete();
		
		try {
			dao.createTeacher(teacher.getFirstName(), teacher.getLastName(), teacher.getUserName(), teacher.getPassword(), teacher.getZoomId());
		} catch (HibernateException e) {
			return "error-page";
		}
		return "add-teacher-success-page";
	}
	
	@RequestMapping(value = "/browseTeachers.htm", method = RequestMethod.GET)
	public String browseTeacher(HttpServletRequest request, TeacherDao dao) throws Exception {
		try {
			List<Teacher> teachers = dao.browseTeacher();
			request.setAttribute("teachers", teachers);
			System.out.println(teachers.size());
		} catch (HibernateException e) {
			return "error-page";
		}
		return "browse-teacher-page";
	}
	
	
	@RequestMapping(value = "/admin.htm", method = RequestMethod.GET)
	public String goToAdminPage(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("course");
		session.removeAttribute("teachers");
		return "admin-page";
	}
	
	@RequestMapping(value = "/assign.htm", method = RequestMethod.POST)
	public String goToAssignTeacher(HttpServletRequest request, CourseDao courseDao, TeacherDao teacherDao) {
		HttpSession session = request.getSession();
		String courseId = request.getParameter("courseId");
		Course c = courseDao.getCourseById(courseId);
		System.out.println(c.getName());
		List<Teacher> ts = teacherDao.browseTeacher();
		session.setAttribute("course", c);
		session.setAttribute("teachers", ts);
		return "assign-teacher-page";
	}
	
	@RequestMapping(value = "/assignTeacher.htm", method = RequestMethod.POST)
	public String assignTeacher(HttpServletRequest request, CourseDao courseDao, TeacherDao teacherDao) {
		HttpSession session = request.getSession();
		Course c = (Course) session.getAttribute("course");
		System.out.println(c.getName());
		String courseId = c.getId();
		String teacherId = request.getParameter("teacher");
		System.out.println(teacherId);
		courseDao.assignTeacher(courseId, teacherId, teacherDao);
		session.removeAttribute("course");
		session.removeAttribute("teachers");
		return "assign-teacher-success-page";
	}

}
