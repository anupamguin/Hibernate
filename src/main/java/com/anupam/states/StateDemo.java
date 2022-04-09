package com.anupam.states;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StateDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate-cfg.xml").buildSessionFactory();
		
		// Student Object creating
		Student std = new Student();
		std.setId(87);
		std.setCity("Salt Lake");
		std.setName("Gopi");
		std.setCertificate(new Certificate("Docker with Kubernates","2 Monthes"));
		
		//Till Now Student in Transient State 
		
		Session session = factory.openSession();
		Transaction tsx = session.beginTransaction();
		session.save(std);
		
		// Till now in Persistent State , it is associated with session & database
		// So now if we change then name
		 std.setName("Gopi Guin");
       //  then it changes with session and db , because it sink with session as well as db
		 // so two query run now at console 1) insert then 2) update
		 
		 tsx.commit();
		 
		 Student student = (Student) session.get(Student.class, 87);
		 System.out.println(student);
		 
		// Now we have to move to detached state where value store in db but remove from session ,( session close)
		session.close();
		factory.close();
	}

}
