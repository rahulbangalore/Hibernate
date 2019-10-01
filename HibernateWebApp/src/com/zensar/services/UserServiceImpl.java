package com.zensar.services;

import java.sql.SQLException;


import java.util.List;

import com.zensar.daos.UserDao;
import com.zensar.entities.User;
import com.zensar.exceptions.ServiceException;

/**
 * @author RAHL B S
 * @version 2.0
 * @creation_date 21st sep 2019 5.29PM
 * @modification_date 28st sep 2019 11.46PM
 * @copyright Zensar Technologies. All rights reserved.
 * @description:It is business service interface. It is used in business layer of application.
 */


public class UserServiceImpl implements UserService{

	private UserDao userdao;
	
	
	public void setUserdao(UserDao userdao) {
		this.userdao = userdao;
	}

	@Override 
	public void addUser(User user) throws ServiceException{
		userdao.insert(user);
		
	}

	@Override
	public void updateUser(User user) throws ServiceException{
	     userdao.update(user);
	     
		
	}

	@Override
	public void removeUser(User user) throws ServiceException {
		userdao.delete(user);
	}

	@Override
	public User findUserByUserName(String username) throws ServiceException {
		// TODO Auto-generated method stub
		User user;
		user = userdao.getByUsername(username);
		return user;
		
	}

	@Override
	public List<User> findAllUsers() throws ServiceException {
		// TODO Auto-generated method stub
		try {
			return userdao.getAll();
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		
	}

	@Override
	public boolean validateUser(User user) throws ServiceException {
		// TODO Auto-generated method stub
		
		User dbUser= findUserByUserName(user.getUsername());
		
		if(dbUser!=null && dbUser.getPassword().equals(user.getPassword()))
			return true;
		else
		    return false;
	}
	
	

}
