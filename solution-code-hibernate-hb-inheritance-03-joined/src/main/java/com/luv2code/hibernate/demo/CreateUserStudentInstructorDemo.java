package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateUserStudentInstructorDemo {

	public static void main(String[] args) {

		// Create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.addAnnotatedClass(Instructor.class)
								.buildSessionFactory();
		
		// Create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			// Create the objects			
			Student tempStudent = new Student("Paul", "Doe", "paul@luv2code.com", "Hibernate");
			
			Instructor tempInstructor = new Instructor("Mary", "Doe", "mary@luv2code.com", 5000.0);
			
			 
			// Start a transaction
			session.beginTransaction();
	
			// Save the student object
			System.out.println("Saving thestudent and instructor...");
			
			session.persist(tempStudent);
			
			session.persist(tempInstructor);
			
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





