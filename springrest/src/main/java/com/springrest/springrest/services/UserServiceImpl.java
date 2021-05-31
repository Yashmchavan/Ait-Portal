package com.springrest.springrest.services;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.springrest.springrest.dao.UserDao;

import com.springrest.springrest.entities.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
    @PersistenceContext
	private EntityManager entityManager;
	
	
	
	
	//List<User> list;
	
	public UserServiceImpl() {
		//list=new ArrayList<>();
		//list.add(new User(1,"pooja","sanware","pooja@company.com","pooja@"));
		
	}

	@Override
	public List<User> getUsers() {
		return userDao.findAll();
		
	}

	@Override
	public User addUser(User user) {
		//list.add(user);
		userDao.save(user);
		return user;
	}

	@Override
	public User updateUser(User user) {
		/*list.forEach(e->{
			if(e.getId()== user.getId())
			{
				e.setFirst_name(user.getFirst_name());
				e.setLast_name(user.getLast_name());
				e.setEmail(user.getEmail());
				e.setPassword(user.getPassword());
			}
		});*/
		
		userDao.save(user);
		return user;
	}

	@Override
	public void deleteUser(long parseLong) {
		//list=this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
		
	User entity = userDao.getOne(parseLong);
	userDao.delete(entity);
	}

	@Override
	public User fetchUserByEmailId(String email) {
		
		return userDao.findByEmail(email);
	}

	//login authentication
	@Override
	public User fetchUserByEmailIdAndPassword(String email, String password) {
		
		return userDao.findByEmailAndPassword(email, password);
	}
	
}
	
	
	
	
	
	


	
	

	
	
	
	

	

