package com.hibernate.singleton;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateAPI {

	private static SessionFactory factory = null;
	
	public static SessionFactory getFactory() {
		
		if(factory == null) {
			factory = new Configuration().configure().buildSessionFactory();
		}
		return factory;
	}
	
	public static void main(String[] args) {
		
		Employee e1 = new Employee(101,"Shiv","Malkapur");
		Employee e2 = new Employee(102,"Suru","Kolhapur");
		Employee e3 = new Employee(103,"Manu","Mumbai");
		Employee e4 = new Employee(104,"Guru","Pune");
		
		try (SessionFactory factory = getFactory();Session session = factory.openSession())
		{
			Transaction t = session.beginTransaction();
			
			session.save(e1);
			session.save(e2);
			session.save(e3);
			session.save(e4);
			
			t.commit();
			
		}catch(Exception e) {
			System.out.println("Exception Occured while creating factory");
		}
	}
}
