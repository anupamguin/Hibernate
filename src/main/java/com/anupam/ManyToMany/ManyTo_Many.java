package com.anupam.ManyToMany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManyTo_Many {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate-cfg.xml").buildSessionFactory();
		
		Emp e1 = new Emp();
		Emp e2 = new Emp();
		
		e1.setEid(33);
		e1.setName("ANupam");
		e2.setEid(34);
		e2.setName("Guin");
		
		Project p1 =new Project();
		Project p2 =new Project();
		
		p1.setPid(666);
		p1.setProjectname("Stock Management");
		p2.setPid(777);
		p2.setProjectname("RTTweb");
		
		List<Emp> list1 = new ArrayList<Emp>();
		List<Project> list2 = new ArrayList<Project>();
		
		list1.add(e1);
		list1.add(e2);
		
		list2.add(p1);
		list2.add(p2);
		
		e1.setProjects(list2);
		p2.setEmps(list1);
		
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(e1);
		session.save(e2);
		session.save(p1);
		session.save(p2);
		
		tx.commit();
		
		factory.close();
	}

}
