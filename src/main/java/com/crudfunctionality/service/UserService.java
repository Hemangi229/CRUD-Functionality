package com.crudfunctionality.service;

import java.util.List;

import com.crudfunctionality.model.User;

public interface UserService {

public List<User> listAllUsers();
	
	public void saveUser(User user);
	
	public void updateUser(User user);
	
	public void deleteUser(int id);
	
	public User findUserById(int id);

}
