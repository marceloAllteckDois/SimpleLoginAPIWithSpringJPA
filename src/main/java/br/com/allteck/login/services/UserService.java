package br.com.allteck.login.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.allteck.login.entity.User;
import br.com.allteck.login.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepo;
	private List<User> usersList = new ArrayList<>();
	public User findUser(String name, String password) {
		try {
			usersList = userRepo.findAll();
			for (User u : usersList) {
				if(u.getName().equals(name) && u.getPassword().equals(password))
					return u;
			}
			throw new NullPointerException();
		}
		catch(Exception e) {
			return new User(Long.valueOf(0),"","","");
		}
	}
	public void AddUser(User user) {
		userRepo.save(user);
	}
}
