package com.me.dao;

import java.util.List;

import org.hibernate.query.Query;

import com.me.pojo.Student;

public class StudentDao extends DAO{
	
	public Student checkLogin(String username, String password) {
		String hql = "FROM Student WHERE userName=:us AND password=:pw";
		Query query = getSession().createQuery(hql);
		query.setString("us", username);
		query.setString("pw", password);
		query.setComment("***Login HQL in UserDao***");
		return (Student) query.uniqueResult();

	}

}
