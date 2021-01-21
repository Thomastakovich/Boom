package com.me.dao;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;

import com.me.pojo.Course;
import com.me.pojo.Student;
import com.me.pojo.Teacher;

public class CourseDao extends DAO {
	
	public List<Course> browseCourses() {
		
		String hql = "FROM Course";
		Query query = getSession().createQuery(hql);
		System.out.println(query.getQueryString());
		return (List<Course>) query.getResultList();
		
	}
	
	public Course createCourse(String name, Date startDate, Date endDate, String startTime, String endTime, String description) throws Exception {
		try {
			begin();
			Course c = new Course(name, startDate, endDate, startTime, endTime, description);
			getSession().save(c);
			commit();
			return c;
		} catch (HibernateException e) {
			throw new Exception("Could not create course ", e);
		}
	}
	
	public Course getCourseById(String id) {
		String hql = "FROM Course WHERE id=:id";
		Query query = getSession().createQuery(hql);
		query.setString("id", id);
		return (Course) query.uniqueResult();
	}
	
	public void dropStudent(String studentId, String courseId) {
		Course c = getCourseById(courseId);
		Iterator<Student> iterator = c.getStudents().iterator();
		while (iterator.hasNext()) {
			Student s = iterator.next();
			if (s.getId().equals(studentId)) {
				iterator.remove();
			}
		}
	}
	
	public void assignTeacher(String courseId, String teacherId, TeacherDao dao) {
		try {
			begin();
			Course c = getCourseById(courseId);
			Teacher t = dao.getTeacherById(teacherId);
			c.setTeacher(t);
			commit();
		} catch (HibernateException e) {
			System.out.println("RollBack");
			rollback();
		}
	}

}
