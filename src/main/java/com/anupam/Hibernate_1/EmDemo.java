package com.anupam.Hibernate_1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate-cfg.xml").buildSessionFactory();
		
		Student std1 = new Student();
		std1.setId(350);
		std1.setName("Ananya Guin");
		std1.setCity("Arambagh");
		std1.setCertificate(new Certificate("Physics","12 Monthes"));
		
		Student std2 = new Student();
		std2.setId(327);
		std2.setName("Gopikanta Guin");
		std2.setCity("Gourhati");
		std2.setCertificate(new Certificate("History","6 Monthes"));
		
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		// Object save
		session.save(std1);
		session.save(std2);
		
		transaction.commit();
		session.close();
		factory.close();
	}

}
