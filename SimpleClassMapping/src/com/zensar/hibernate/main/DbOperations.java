package com.zensar.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.id.IncrementGenerator;

import com.zensar.entities.Product;

public class DbOperations {

	public static void main(String[] args) {
		Configuration c = new Configuration().configure(); // it reads cfg.configuration
		// singleton and heavy weight session factory
		SessionFactory f = c.buildSessionFactory();
		Session s = f.openSession(); // rep db connection and light weight
		Transaction t = s.beginTransaction();

		// insert new record
		/*
		 * Product p=new Product(1011,"PowerBank","QWERTY",(float)2299.00); s.save(p);
		 */

		// get Record according to primary key

		/*
		 * Product p = s.get(Product.class, 10101);
		 * 
		 * if (p != (null)) { System.out.println(p); } else {
		 * System.out.println("record dosen't exist");
		 * 
		 * }
		 */

		/*
		 * Product p1=s.load(Product.class, 1002);
		 */

		// update a record
		
		/*
		 * Product p = s.get(Product.class, 1006);
		 * 
		 * 
		 * 
		 * if (p != (null)) {
		 * 
		 * p.setPrice(p.getPrice()+1111); s.update(p);
		 * 
		 * } else { System.out.println("record dosen't exist");
		 * 
		 * }
		 */
		
		//Delete a record
		
		Product p = s.get(Product.class, 1006);
		if (p != (null)) {
			s.delete(p);
			System.out.println("record"+p+" deleted successfully");
		}
		else { System.out.println("record dosen't exist");
		  
		  }
		
		
		

		t.commit();
		s.close();

	}

}
