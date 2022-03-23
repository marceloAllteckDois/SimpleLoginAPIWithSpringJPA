package br.com.allteck.login.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import br.com.allteck.login.entity.User;
import br.com.allteck.login.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepo;
	private List<User> usersList = new ArrayList<>();
	public User findUser(String name, String password) {
		User user = new User();
		user.setName(name);
		user.setPassword(password);
		Example<User> example = Example.of(user);
		Optional<User> optional = userRepo.findOne(example);
		return optional.orElse(null);
	}
	public User AddUser(User user) {
		return userRepo.save(user);
	}
	
	
	public List<User> listAllUsers(){
		usersList = userRepo.findAll();
		return usersList;
	}
}
