package com.zensar.hibernate.main;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.zensar.entities.Customer;
import com.zensar.entities.Name;

public class CustomerGetDemo {

	public static void main(String[] args) {
		Configuration c = new Configuration().configure();
		SessionFactory sf = c.buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		
		Customer c1=s.get(Customer.class,103);
		System.out.println(c1.getCustomerId());
		System.out.println(c1.getAddress());
		System.out.println(c1.getGender());
		System.out.println(c1.getBirtDate());
		System.out.println(c1.getAge());
		
		Name customerName=c1.getCustomerName();
		System.out.println(customerName);
		
		Blob customerPhoto=c1.getProfilePhoto();
		
		try {
			InputStream in=customerPhoto.getBinaryStream();
			FileOutputStream fout=new FileOutputStream("./resources/newPhoto.jpg");
			
			int data=0;
			while((data=in.read())!=-1){
				fout.write(data);
			}
			
			in.close();
			fout.close();
			
			Clob description = c1.getDescription();
			Reader r = description.getCharacterStream();
			PrintWriter pw=new PrintWriter("./resources/CustomerDbInfo.txt");
			int chardata=0;
			while((chardata=r.read())!=-1) {
				pw.print((char)chardata);
			}
			
			r.close();
			pw.close();
			
			t.commit();
			s.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
