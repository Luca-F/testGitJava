package fr.formation.inti.dao;

import org.hibernate.query.Query;


import fr.formation.inti.entity.User;


public class userDaoImpl extends GenericDaoImpl<User, Integer> implements userDao{

	public User findUserBy(String email, String password) {
		
		String hql = "from User where (email = :email and password = :password)";
		Query<User> query = session.createQuery(hql);
		query.setParameter("email", email);
		query.setParameter("password", password);
		User user = (User) query.uniqueResult();
		//User user = (User) session.createQuery("select u from "+User.class.getName()+" u where u.email = '" + email+ "' and u.password = '"+password+"'").uniqueResult();
		return user;
	}
}
