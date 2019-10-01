package com.zensar.hibernate.main;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.zensar.entities.Product;

//HQL-Hibernate Query Language(O O Query Language)
public class HQLMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration c = new Configuration().configure(); // it reads cfg.configuration
		// singleton and heavy weight session factory
		SessionFactory f = c.buildSessionFactory();
		Session s = f.openSession(); // rep db connection and light weight
		Transaction t = s.beginTransaction();

		/*
		 * Query q = s.createQuery("from Product");
		 */		
		
		/*
		 * Query q =
		 * s.createQuery("from Product p where p.price>18999 and p.price<40000");
		 */		
		
		/*
		 * Query q =
		 * s.createQuery("from Product p where p.price between 10000 and 20000");
		 */
		
		/*
		 * Query q = s.createQuery("from Product p where p.brand like'H%'");
		 */
		/* Query q = s.createQuery("from Product p where p.name ='Laptop'"); */
		
		/* Query q=s.createQuery("select p.id, p.name,p.price from Product p"); */
		/*
		 * Query q=s.createQuery("select p.productId, p.name,p.price from Product p");
		 */		
		
		/*
		 * Query q=s.createQuery("select p.price,p.brand,p.name from Product p");
		 * 
		 * List<Object[]> objects = q.getResultList(); for (Object[] ob : objects) {
		 * for(int i=0;i<ob.length;i++) { System.out.println(ob[i]);
		 * System.out.println(""); } }
		 */
		
		Query q = s.createQuery("select max(p.price) from Product p");
		Float maxPrice=(Float) q.getSingleResult();
		System.out.println(maxPrice);
		
		Query q1 = s.createQuery("select min(p.price) from Product p");
		Float minPrice=(Float) q1.getSingleResult();
		System.out.println(minPrice);
		
		Query q2 = s.createQuery("select sum(p.price) from Product p");
		double sumPrice=(double) q2.getSingleResult();
		System.out.println(sumPrice);
		
		Query q3 = s.createQuery("select count(p.price) from Product p");
		long count=(long) q3.getSingleResult();
		System.out.println(count);
		
		Query q4 = s.createQuery("select avg(p.price) from Product p");
		double avg=(double) q4.getSingleResult();
		System.out.println(avg);
		
		/*
		 * //CRITERIA
		 *  Criteria cr=s.createCriteria(Product.class); List<Product>
		 * products=cr.list(); for(Product p:products) { System.out.println(p); }
		 * 
		 */
		
		
		
		
		t.commit();
		s.close();

	}

}
