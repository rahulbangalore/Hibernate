package com.zensar.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.zensar.entities.User;

/**
 * @author RAHUL BANGALORE SRIDHAR
 * @version 2.0 modification date 28th sept 2019 11.12am @
 *
 */

@Entity
public class UserDaoImpl implements UserDao {

	private Session session;

	public UserDaoImpl() {
		// TODO Auto-generated constructor stub
		Configuration c = new Configuration().configure();
		SessionFactory f = c.buildSessionFactory();
		session = f.openSession();
	}

	@Override
	public void insert(User user) {
		// TODO Auto-generated method stub
		Transaction t = session.beginTransaction();
		session.save(t);
		t.commit();
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		Transaction t = session.beginTransaction();
		session.update(t);
		t.commit();

	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		Transaction t = session.beginTransaction();
		session.delete(t);
		t.commit();

	}

	@Override
	public User getByUsername(String username) {
		// TODO Auto-generated method stub
		
		return session.get(User.class, username);
	}
	

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		Query q=session.createQuery("from User");
		return q.getResultList();
	}

}
