package com.luv2code.hibernate.demo;

import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentImagesMapDemo {
	
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
			
			Map<String, String> theImages = tempStudent.getImages();
			
			theImages.put("photo1.jpg", "Photo 1");
			
			theImages.put("photo2.jpg", "Photo 2");
			
			theImages.put("photo3.jpg", "Photo 3");
			
			theImages.put("photo4.jpg", "Photo 4");
			
			theImages.put("photo5.jpg", "Photo 5");
			
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
