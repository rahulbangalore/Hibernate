package com.zensar.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.zensar.entities.Country;
import com.zensar.entities.Flag;

public class OneToOneMappingDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Configuration c= new Configuration().configure();
SessionFactory sf=c.buildSessionFactory();
Session s=sf.openSession();
Transaction t=s.beginTransaction();
Country co=new Country();
co.setLanguage("URDU");
co.setPopulation(838383l);
co.setName("PKMKB");

Flag f1=new Flag();
f1.setDescription("MGKMKB");
f1.setFlagName("greenMoon");


co.setFlag(f1);
f1.setCountry(co);

s.save(f1);
s.save(co);


t.commit();
s.close();
System.exit(0);
	}

}
