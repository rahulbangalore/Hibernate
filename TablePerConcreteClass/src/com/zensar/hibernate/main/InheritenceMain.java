package com.zensar.hibernate.main;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.zensar.entities.Employee;
import com.zensar.entities.WageEmp;

public class InheritenceMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration c=new Configuration().configure();
		SessionFactory sf=c.buildSessionFactory();
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		
		Employee e=new Employee();
		e.setName("RoV");
		e.setJoinDate(LocalDate.of(2019, 8, 01));
		e.setSalary(19000);
		
		s.save(e);
		
		WageEmp we=new WageEmp();
		we.setName("Sc");
		we.setJoinDate(LocalDate.of(2019, 10, 05));
		we.setSalary(20000);
		we.setHours(45);
		we.setRate(115f);
		
		s.save(we);
		
		
		t.commit();
		s.close();
	}

}
