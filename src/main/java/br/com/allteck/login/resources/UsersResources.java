package br.com.allteck.login.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.allteck.login.entity.User;
import br.com.allteck.login.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UsersResources {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/{name}/{password}", method = RequestMethod.GET)
	public ResponseEntity<?> findUserByName(@PathVariable String name, @PathVariable String password) {
		User user = userService.findUser(name, password);
		return ResponseEntity.ok().body(user);
	}
	
	@RequestMapping(value="/{name}/{email}/{password}", method = RequestMethod.POST)
	public ResponseEntity<?> addUser(@PathVariable String name,
									@PathVariable String email,
									@PathVariable String password){
		User user = new User(name,email,password);
		userService.AddUser(user);
		return ResponseEntity.ok().body(user);
		
	}
}
