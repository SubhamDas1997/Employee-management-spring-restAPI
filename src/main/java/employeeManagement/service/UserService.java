package employeeManagement.service;

import java.util.List;

import employeeManagement.entity.Role;
import employeeManagement.entity.User;

public interface UserService {

	public List<User> showUsers();
	
	public void saveUser(User user);
	
	public User findUserById(Integer id);
	
	public void deleteUser(User user);
}