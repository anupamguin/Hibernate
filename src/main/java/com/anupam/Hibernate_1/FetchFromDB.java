package com.anupam.Hibernate_1;

import java.io.FileOutputStream;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchFromDB {

	public static void main(String[] args) throws Exception {
		
		SessionFactory sessionFactory = new Configuration().configure("hibernate-cfg.xml").buildSessionFactory();
		Session session=sessionFactory.openSession();
		
		// get-student:108
		
		Student std = (Student) session.get(Student.class, 108);
		System.out.println(std);
		
		Address add = (Address) session.load(Address.class, 1);
		System.out.println(add.getAddedDate()+"   "+add.getCity());
		
		FileOutputStream fout=new FileOutputStream(add.getStreet()+".jpg"); 
		fout.write(add.getImage());
		
		System.out.println("completed");
		session.close();
		sessionFactory.close();
	}

}
