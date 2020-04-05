package harsha.practice.hibernate.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import harsha.practice.hibernate.commons.StudentEntity;
import harsha.practice.hibernate.commons.SubjectEntity;

public class HibernateUtility {

	private static final SessionFactory sessionFactory;
	static {

		try {
			Configuration cfg = new Configuration();
			cfg.addAnnotatedClass(StudentEntity.class);
			cfg.addAnnotatedClass(SubjectEntity.class);
			System.out.println("Before creating session factory");
			sessionFactory = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
			System.out.println("After creating session factory");
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	public static SessionFactory getsessionFactory() {
		return sessionFactory;
	}
}
