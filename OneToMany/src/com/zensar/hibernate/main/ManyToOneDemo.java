package com.zensar.hibernate.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.zensar.entities.Movie;
import com.zensar.entities.Song;

public class ManyToOneDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration c= new Configuration().configure();
		SessionFactory sf=c.buildSessionFactory();
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		
		Movie m=new Movie();
		m.setReleaseDate(LocalDate.of(1997, 11, 16));
		m.setTitle("MI4");
		
		Song so=new Song("LA");
		Song s1=new Song("TG");
		Song s2=new Song("NY");
		
		s1.setMovie(m);
		so.setMovie(m);
		s2.setMovie(m);
		
		List<Song> songs=new ArrayList<Song>();
		songs.add(so);
		songs.add(s1);
		songs.add(s2);
		
		m.setSongs(songs);
		
		s.save(m);
		s.save(so);
		s.save(s1);
		s.save(s2);
		

		t.commit();
		s.close();

	}

}
