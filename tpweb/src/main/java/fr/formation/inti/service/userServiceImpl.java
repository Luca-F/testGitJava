package fr.formation.inti.service;

import java.util.List;

import fr.formation.inti.dao.userDaoImpl;
import fr.formation.inti.entity.User;

public class userServiceImpl implements userService{

	
userDaoImpl dao;
	
	public userServiceImpl() {
		dao = new userDaoImpl();
	}
	
	@Override
	public User findUserBy(String email, String password) {
		dao.beginTransaction();
		User c = dao.findUserBy(email, password);
		dao.commit(true);
		return c;
	}

	@Override
	public List<User> findAll() {
		dao.beginTransaction();
		List<User> list = dao.findAll();
		dao.commit(true);
		return list;
	}

}
