package com.app;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernate.HibernateConfig;
import com.model.Student;

public class AllOpeartion {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter choice 1-5");
		int op = sc.nextInt();
		switch (op) {
		case 1:
			insertData();
			break;
		case 2:
			deleteData();
			break;
		case 3:
			getDataById();
			break;
		case 4:
			getAllData();
			break;
		case 5:
			updateData();
			break;
		}
	}

	public static void insertData() {
		SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
		Session session = HibernateConfig.getSession();

		try (sessionFactory; session) {
			session.beginTransaction();

			Student student = new Student(3, "gff", "fgf");
			session.save(student);

			session.getTransaction().commit();
			session.close();
			sessionFactory.close();
		}
	}

	public static void deleteData() {
		SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
		Session session = HibernateConfig.getSession();

		try (sessionFactory; session) {
			session.beginTransaction();

			Student student = session.get(Student.class, 4);
			session.delete(student);

			session.getTransaction().commit();
			session.close();
			sessionFactory.close();
		}
	}

	public static void getDataById() {
		SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
		Session session = HibernateConfig.getSession();

		try (sessionFactory; session) {
			session.beginTransaction();

			Student student = session.get(Student.class, 3);
			System.out.println(student.getId());
			System.out.println(student.getFirstName());
			System.out.println(student.getLastName());

			session.getTransaction().commit();
			session.close();
			sessionFactory.close();
		}
	}

	public static void getAllData() {
		SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
		Session session = HibernateConfig.getSession();

		try (sessionFactory; session) {
			session.beginTransaction();

			@SuppressWarnings("unchecked")
			List<Student> list = session.createQuery("from Student").list();
			for (Student student : list) {
				System.out.println(student.getId());
				System.out.println(student.getFirstName());
				System.out.println(student.getLastName());
				System.out.println("==================");
			}

			session.getTransaction().commit();
			session.close();
			sessionFactory.close();
		}
	}

	public static void updateData() {
		SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
		Session session = HibernateConfig.getSession();

		try (sessionFactory; session) {
			session.beginTransaction();

			Student student = session.get(Student.class, 3);
			student.setFirstName("Jon");
			student.setLastName("Snow");

			session.getTransaction().commit();
			session.close();
			sessionFactory.close();
		}
	}

}
