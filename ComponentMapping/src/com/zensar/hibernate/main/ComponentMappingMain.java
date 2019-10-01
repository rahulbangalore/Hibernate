package com.zensar.hibernate.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Blob;
import java.sql.Clob;
import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.jdbc.BlobProxy;
import org.hibernate.engine.jdbc.ClobProxy;

import com.zensar.entities.Customer;
import com.zensar.entities.Name;

public class ComponentMappingMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration c = new Configuration().configure();
		SessionFactory sf = c.buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();

		Name name = new Name();
		name.setFirstName("RAHUL");
		name.setMiddleName("BANGALORE");
		name.setLastName("SRIDHAR");

		/*
		 * Customer cu = new Customer(101,name,"male",21);
		 */
		Customer cu = new Customer();
		cu.setCustomerId(103);

		cu.setAge(21);
		cu.setGender("male");
		cu.setCustomerName(name);
		cu.setBirtDate(LocalDate.of(1997, 11, 16));
		cu.setAddress("HYD");

		try {
			File photo = new File("./resources/dt.jpg");
			FileInputStream fin = new FileInputStream(photo); // read mode file-opening

			Blob customerPhoto = BlobProxy.generateProxy(fin, photo.length());
			cu.setProfilePhoto(customerPhoto);

			File file2 = new File("./resources/CustomerInfo.txt");
			FileReader fr=new FileReader(file2);
			
			Clob description=ClobProxy.generateProxy(fr, file2.length());
			cu.setDescription(description);

			s.save(cu);

			t.commit();
			s.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
