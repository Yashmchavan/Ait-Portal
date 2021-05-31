package com.springrest.springrest.services;

import java.util.List;



import com.springrest.springrest.entities.User;


public interface UserService {
	public List<User> getUsers();
	public User addUser(User user);
	public User updateUser(User user);
	public void deleteUser(long parseLong);
	public User fetchUserByEmailId(String email);
	public User fetchUserByEmailIdAndPassword(String email, String password);
	

	
	
	
	
	
	

}
