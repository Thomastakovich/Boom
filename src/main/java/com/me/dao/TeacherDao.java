package com.me.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;

import com.me.pojo.Teacher;

public class TeacherDao extends DAO {
	
	public Teacher checkLogin(String username, String password) {
		
		String hql = "FROM Teacher WHERE userName=:us AND password=:pw";
		Query query = getSession().createQuery(hql);
		query.setString("us", username);
		query.setString("pw", password);
		query.setComment("***Login HQL in UserDao***");
		return (Teacher) query.uniqueResult();

	}
	
	public Teacher createTeacher(String firstName, String lastName, String userName, String password, String zoomId) throws Exception {
		
		try {
			begin();
			Teacher t = new Teacher(firstName, lastName, userName, password, zoomId);
			System.out.println(t);
			getSession().save(t);
			commit();
			return t;
		} catch(HibernateException e) {
			throw new Exception("Could not create teacher ", e);
		}
	}
	
	public List<Teacher> browseTeacher() {
		String hql = "FROM Teacher";
		Query query = getSession().createQuery(hql);
		return (List<Teacher>) query.getResultList();
	}
	
	public Teacher getTeacherById(String id) {
		String hql = "FROM Teacher WHERE id=:id";
		Query query = getSession().createQuery(hql);
		query.setString("id", id);
		return (Teacher) query.uniqueResult();
	}

}
