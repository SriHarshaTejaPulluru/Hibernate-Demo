package harsha.practice.hibernate.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import harsha.practice.hibernate.commons.StudentEntity;
import harsha.practice.hibernate.commons.SubjectEntity;

public class HibernateUtility {

	private static final SessionFactory sessionFactory;
	private static final Logger logger = LoggerFactory.getLogger(HibernateUtility.class);
	static {
		try {
			Configuration cfg = new Configuration();
			cfg.addAnnotatedClass(StudentEntity.class);
			cfg.addAnnotatedClass(SubjectEntity.class);
			logger.info("Before creating session factory");
			sessionFactory = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
			logger.info("After creating session factory");
		} catch (Exception e) {
			logger.error("Problem in creating session factory : ", e);
			throw new ExceptionInInitializerError(e);
		}
	}

	public static SessionFactory getsessionFactory() {
		return sessionFactory;
	}
}
