package br.com.allteck.login.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.allteck.login.entity.User;
import br.com.allteck.login.services.UserService;

@RestController
@RequestMapping(value="/login")
public class LoginResources {
	@Autowired
	private UserService userService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public User loginUser(@RequestBody User user) {
		return userService.findUser(user.getName(),user.getPassword());
		
	}
}
