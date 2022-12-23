package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.model.Student;

public class HibernateConfig {

	private static SessionFactory sessionFactory;
	
	static {
		Configuration configuration=new Configuration();
		configuration.configure("hibernate.cfg.xml");
		configuration.addAnnotatedClass(Student.class);
		sessionFactory=configuration.buildSessionFactory();
	}
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public static Session getSession() {
		return sessionFactory.openSession();
	}
}
