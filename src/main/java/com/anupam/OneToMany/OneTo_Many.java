package com.anupam.OneToMany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneTo_Many {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate-cfg.xml").buildSessionFactory();
		
		// create question1
		Question question1 = new Question();
		question1.setQuestionId(32);
		question1.setQuestion("What is Java?");
		
		Answer a1 = new Answer();
		a1.setAnswerid(65);
		a1.setAnswer("Java is a Programming Language");
		a1.setQ(question1);
		
		Answer a2 = new Answer();
		a2.setAnswerid(66);
		a2.setAnswer("Java has Oops features ");
		a2.setQ(question1);
		
		Answer a3 = new Answer();
		a3.setAnswerid(67);
		a3.setAnswer("Java has Spring Framework");
		a3.setQ(question1);
		
		List<Answer> list = new ArrayList<Answer>();
		list.add(a1);
		list.add(a2);
		list.add(a3);
		
		question1.setAnswer(list);
				
		//save 
		Session session= factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(question1);
		session.save(a1);
		session.save(a2);
		session.save(a3);
		
		tx.commit();
		
		// fetching
		Question q =(Question) session.get(Question.class, 32);
		System.out.println(q.getQuestion());
		q.getAnswer().forEach(System.out::println);
		
		session.close();
		factory.close();
	}
}
