package com.me.boom;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
public class StudentController {

	@RequestMapping(value = "/student.htm", method = RequestMethod.GET) 
	public String goToStudentPage(HttpServletRequest request, StudentDao dao) {
		HttpSession session = request.getSession();
		Student s = (Student) session.getAttribute("user");
		String id = s.getId();
		s = dao.getStudentById(id);
		System.out.println(s.getCourses().size() + " courses");
		session.setAttribute("user", s);
		return "student-page";
	}
	
	@RequestMapping(value = "/studentBrowseCourse.htm", method = RequestMethod.GET)
	public String browseCourse(HttpServletRequest request, CourseDao dao) {
		try {
			List<Course> courses = dao.browseCourses();
			request.setAttribute("courses", courses);
			System.out.println(courses.size());
		} catch (HibernateException e) {
			return "error-page";
		}
		return "student-browse-course-page";
	}

	@RequestMapping(value = "/courseApply.htm", method = RequestMethod.POST)
	public String applyCourse(HttpServletRequest request, StudentDao studentDao, CourseDao courseDao, ApplicationDao appDao) throws Exception {
		// send a request to apply for a course
		HttpSession session = request.getSession();
		String choosedCourseId = request.getParameter("course");
		System.out.println(choosedCourseId);
		request.setAttribute("courseId", choosedCourseId);
		Course curCourse = courseDao.getCourseById(choosedCourseId);
		if (curCourse == null) {
			return "nothing-to-apply-page";
		}
		String courseName = curCourse.getName();
		request.setAttribute("courseName", courseName);
		System.out.println("You choose: " + courseName);
		Student curStudent;
		curStudent = (Student) session.getAttribute("user");
		System.out.println(curStudent.getEmail());
		for (Course c : curStudent.getCourses()) {
			if (c.getId().equals(curCourse.getId())) {
				return "repeat-apply-page";
			}
		}
		Application a = appDao.createApplication(curStudent, curCourse);
		return "apply-success-page";
	}
	
	@RequestMapping(value = "/drop.htm", method = RequestMethod.POST) 
	public String dropCourse(HttpServletRequest request, StudentDao studentDao, CourseDao courseDao) throws Exception {
		HttpSession session = request.getSession();
		Student student = (Student) session.getAttribute("user");
		if (student.getCourses().size() == 0) {
			return "nothing-to-drop-page";
		}
		String studentId = student.getId();
		String courseId = request.getParameter("course");
		studentDao.dropCourse(studentId, courseId, courseDao);
//		courseDao.dropStudent(studentId, courseId);
		session.setAttribute("user", student);
		return "drop-success-page";
	}
}
