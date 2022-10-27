package employeeManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import employeeManagement.entity.User;
import employeeManagement.serviceImpl.UserServiceImpl;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserServiceImpl userService;
	
	@GetMapping
	public List<User> getUsers() {
		return userService.showUsers();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public User addUser(@RequestBody User user) {
		user.setUserId(0);
		userService.saveUser(user);
		return user;
	}
	
	@GetMapping("/{userId}")
	public User getUserbyId(@PathVariable Integer userId) {
		return userService.findUserById(userId);
	}
	
	@PutMapping
	public User updateUser(@RequestBody User user) {
		userService.saveUser(user);
		return user;
	}
	
	@DeleteMapping("/{userId}")
	public String deleteUser(@PathVariable Integer userId) {
		User user = userService.findUserById(userId);
		userService.deleteUser(user);
		return "Deleted user ID - " + userId;
	}
}