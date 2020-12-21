package com.me.dao;

import org.hibernate.query.Query;

import com.me.pojo.Admin;

public class AdminDao extends DAO {
	
	public Admin checkLogin(String username, String password) {
		
		String hql = "FROM Admin WHERE userName=:us AND password=:pw";
		Query query = getSession().createQuery(hql);
		query.setString("us", username);
		query.setString("pw", password);
		query.setComment("***Login HQL in UserDao***");
		return (Admin) query.uniqueResult();
		
	}

}
