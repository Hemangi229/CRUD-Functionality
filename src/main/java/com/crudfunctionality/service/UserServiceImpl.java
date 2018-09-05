package com.crudfunctionality.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudfunctionality.dao.UserDao;
import com.crudfunctionality.model.User;

@Service
public class UserServiceImpl implements UserService{
	
	UserDao userDao;
	
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public List<User> listAllUsers() {
		return userDao.listAllUsers();
	}

	public void saveUser(User user) {
		userDao.saveUser(user);		
	}

	public void updateUser(User user) {
		userDao.updateUser(user);		
	}

	public void deleteUser(int id) {
		userDao.deleteUser(id);		
	}

	public User findUserById(int id) {
		return userDao.findUserById(id);
	}

}
