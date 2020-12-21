package com.me.dao;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;

import com.me.pojo.Course;
import com.me.pojo.Student;

public class StudentDao extends DAO {
	
	public Student checkLogin(String username, String password) throws Exception {
		
	
			String hql = "FROM Student WHERE userName=:us AND password=:pw";
			Query query = getSession().createQuery(hql);
			query.setString("us", username);
			query.setString("pw", password);
			query.setComment("***Login HQL in UserDao***");
			
			return (Student) query.uniqueResult();
		
			

	}
	
	public Student createStudent(String firstName, String lastName, String userName, String password, String email, String zoomId) throws Exception{
		try {
			begin();
			Student s = new Student(firstName, lastName, userName, password, email, zoomId);
			System.out.println(s);
			getSession().save(s);
			commit();
			return s;
		} catch(HibernateException e) {
			throw new Exception("Could not create student ", e);
		}
		
	}
	
	public Student getStudentById(String id) {
		
		String hql = "FROM Student WHERE id=:id";
		Query query = getSession().createQuery(hql);
		query.setString("id", id);
			
		return (Student) query.uniqueResult();
		
	}
	
	public void dropCourse(String studentId, String courseId, CourseDao courseDao) throws Exception {
		try {
			begin();
			Student s = getStudentById(studentId);
			Course c = courseDao.getCourseById(courseId);
			s.getCourses().remove(c);
			System.out.println("removed");
			commit();
		} catch (HibernateException e) {
			System.out.println("RollBack");
		}
	}
	
}
