package com.luv2code.hibernate.demo;

import java.util.Set;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentImagesSetDemo {
	
	public static void main(String[] args) {
		
		// Create session factory
		SessionFactory factory = new Configuration()
				                     .configure("hibernate.cfg.xml")
				                     .addAnnotatedClass(Student.class)
				                     .buildSessionFactory();
				                                    
		// Create session
		Session session = factory.getCurrentSession();
		
		try {
			// Create the object
			Student tempStudent = new Student("John", "Doe", "paul@luv2code.com");
			
			Set<String> theImages = tempStudent.getImages();
			
			theImages.add("photo1.jpg");
			
			theImages.add("photo2.jpg");
			
			theImages.add("photo3.jpg");
			
			theImages.add("photo4.jpg");
			
			theImages.add("photo4.jpg"); // Duplicate, filtered at Java level by HashSet
			
			theImages.add("photo5.jpg");
			
			// Start transaction
			session.beginTransaction();
			
			// Save the object
			System.out.println("Saving the student and images...");
			
			session.persist(tempStudent);
			
			// Commit the transaction
			session.getTransaction().commit();
			
			System.out.print("Done!");
		}
		finally {
			
			session.close();
			
			factory.close();
			// Clean up code
		}
	}
}
