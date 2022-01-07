package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class GetStudentImagesDemo {
	
	public static void main(String[] args) {
		
		// Create session factory
		SessionFactory factory = new Configuration()
				                .configure("hibernate.cfg.xml")
				                .addAnnotatedClass(Student.class)
				                .buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			// Start a transaction
			session.beginTransaction();
			
			// Get the student id
			int id = 1;
			
			Student student = session.get(Student.class, id);
			
			// Print the student detail
			System.out.println("Student details: " + student);
			
			// Print the associated images
			System.out.println("The associated images: " + student.getImages());
			
			// Commit the transaction
			session.getTransaction().commit();
			
			// Done
			System.out.println("Done!");
		}
		finally {
			// Close the transaction
			session.close();
			
			factory.close();
		}
	}
}
