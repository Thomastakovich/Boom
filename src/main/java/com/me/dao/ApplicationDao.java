package com.me.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.me.pojo.Application;
import com.me.pojo.Course;
import com.me.pojo.Student;

public class ApplicationDao extends DAO {

	public List<Application> browseApplications() {
		String hql = "FROM Application";
		Query q = getSession().createQuery(hql);
		return (List<Application>) q.getResultList();
	}
	
	public Application createApplication(Student s, Course c) throws Exception {
		try {
			begin();
			Application a = new Application();
			a.setStudent(s);
			a.setCourse(c);
			getSession().save(a);
			commit();
			return a;
		} catch (HibernateException e) {
			throw new Exception("Could not create application ", e);	
		}
	}
	
	public Application getApplicationById(String id) {
		String hql = "FROM Application WHERE id=:id";
		Query q = getSession().createQuery(hql);
		q.setString("id", id);
		return (Application) q.uniqueResult();
	}
	
	public int deleteApplication(String id) throws Exception{
		
		try {
			begin();
			String hql = "DELETE from Application WHERE id=:id";
			Query q = getSession().createQuery(hql);
			q.setString("id", id);
			q.setComment("Delete application successfully!");
			System.out.println(q.getQueryString());
			System.out.println("Deny application: " + id);
			int rows = q.executeUpdate();
			commit();
			return rows;
		} catch (HibernateException e) {
			throw new Exception("Could not create application ", e);	
		}
		
	}
}
