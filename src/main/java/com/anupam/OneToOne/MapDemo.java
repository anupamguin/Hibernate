package com.anupam.OneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate-cfg.xml").buildSessionFactory();
		
		// create question1
		Question question1 = new Question();
		question1.setQuestionId(32);
		question1.setQuestion("What is Java?");
		Answer a1 = new Answer();
		a1.setAnswerid(89);
		a1.setAnswer("Java is a Programming Language");
		a1.setQ(question1);
		question1.setAnswer(a1);
		
		Question question2 = new Question();
		question2.setQuestionId(33);
		question2.setQuestion("Who is Anupam?");
		Answer a2 = new Answer();
		a2.setAnswerid(90);
		a2.setAnswer("Anupam is a good boy");
		a2.setQ(question2);
		question2.setAnswer(a2);
		
		Session session= factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(question1);
		session.save(question2);
		session.save(a1);
		session.save(a2);
		
		tx.commit();
		
		// fetching
		Question q=(Question) session.get(Question.class, 33);
		System.err.println("HI Question---> "+q);
		System.out.println(q.getQuestion()+"   "+q.getAnswer().getAnswer());
		
		Answer a =(Answer) session.load(Answer.class, 89);
		System.err.println("Welcome Answer ===> "+a);
		System.out.println(a.getAnswer()+"   "+a.getQ());
		
		session.close();
		factory.close();
	}
}
