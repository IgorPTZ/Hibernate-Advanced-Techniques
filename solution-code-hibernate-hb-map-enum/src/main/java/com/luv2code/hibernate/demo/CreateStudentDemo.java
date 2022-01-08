package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Status;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {

		// Create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// Create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			// Create the objects			
			Student tempStudent1 = new Student("Paul", "Doe", "paul@luv2code.com", Status.ACTIVE);
			
			Student tempStudent2 = new Student("Mary", "Doe", "mary@luv2code.com", Status.INACTIVE);
			
			 
			// Start a transaction
			session.beginTransaction();
	
			// Save the student object
			System.out.println("Saving the student and address...");
			
			session.persist(tempStudent1);
			
			session.persist(tempStudent2);
			
			// Commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			
			// Add clean up code
			session.close();
			
			factory.close();
		}
	}
}





