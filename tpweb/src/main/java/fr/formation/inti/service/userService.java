package fr.formation.inti.service;

import java.sql.SQLException;
import java.util.List;
import fr.formation.inti.entity.User;

public interface userService {

	User findUserBy(String email, String password);
	List<User> findAll();

}
