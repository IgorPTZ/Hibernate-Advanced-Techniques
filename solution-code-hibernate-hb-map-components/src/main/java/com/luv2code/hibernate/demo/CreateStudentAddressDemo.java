package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Address;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentAddressDemo {

	public static void main(String[] args) {

		// Create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.addAnnotatedClass(Address.class)
								.buildSessionFactory();
		
		// Create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			// Create the objects			
			Student tempStudent = new Student("Paul", "Doe", "paul@luv2code.com");
			
			Address homeAddress = new Address("Some Street 1", "12345", "Some City");
			
			Address billingAddress = new Address("Soma Street 2", "54321", "Some City 2");
			
			tempStudent.setHomeAddress(homeAddress);
			
			tempStudent.setBillingAddress(billingAddress);
			 
			// Start a transaction
			session.beginTransaction();
			
	
			// Save the student object
			System.out.println("Saving the student and address...");
			
			session.persist(tempStudent);	
			
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





