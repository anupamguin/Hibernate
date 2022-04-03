package com.anupam.Hibernate_1;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
/*        Configuration cfg= new Configuration();
          cfg.configure("hibernate-cfg.xml");
          SessionFactory factory = cfg.buildSessionFactory();
*/
    					// OR
    	
    	SessionFactory factory = new Configuration().configure("hibernate-cfg.xml").buildSessionFactory();
        
        System.out.println(factory.isOpen());
        System.out.println(factory.isClosed());
        
        // Creating Student
        Student std = new Student(108,"Aparna","Kolkata");
        System.out.println(std);
        
        //set address 
        Address ad = new Address();
		ad.setStreet("Gourhati");
		ad.setCity("Arambagh");
		ad.setOpen(true);
		ad.setAddedDate(new Date());
		ad.setX(1653.234);
		
		// Read Image 
		FileInputStream fis = new FileInputStream("src/main/java/urvashi.jpg");
		byte[] data = new byte[fis.available()];
		fis.read(data);
		ad.setImage(data);
        
        // To save
        Session session= factory.openSession();
        Transaction transaction= session.beginTransaction(); // Transaction need to save data
        session.save(std);
        session.save(ad);
        transaction.commit();
        
        session.close();
        factory.close();
    }
}
