package harsha.practice.hibernate.commons;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import harsha.practice.hibernate.utils.HibernateUtility;

public class MainClass {

	public static void main(String[] args) {
		Transaction transaction = null;
		System.out.println("Before calling Hibernate Session factory Util");
		try (Session session = HibernateUtility.getsessionFactory().openSession()) {
			transaction = session.beginTransaction();
			SubjectEntity sub1 = new SubjectEntity("Maths");
			SubjectEntity sub2 = new SubjectEntity("Science");

			List<SubjectEntity> subjectsList = new ArrayList<SubjectEntity>();
			subjectsList.add(sub1);
			subjectsList.add(sub2);

			StudentEntity student1 = new StudentEntity("Harsha", subjectsList);
			StudentEntity student2 = new StudentEntity("Teja", subjectsList);

			session.save(student1);
			session.save(student2);

			transaction.commit();
			System.out.println("Successfully committed");
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}

}
