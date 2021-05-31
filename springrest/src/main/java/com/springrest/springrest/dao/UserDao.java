package com.springrest.springrest.dao;



import org.springframework.data.jpa.repository.JpaRepository;


import com.springrest.springrest.entities.User;

public interface UserDao extends JpaRepository<User,Long> {

	User findByEmail(String email);
	User findByEmailAndPassword(String email, String password);
	//News save(News news);
	//News findAll(News news);
	
	

}
