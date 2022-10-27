package employeeManagement.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import employeeManagement.entity.Role;
import employeeManagement.entity.User;
import employeeManagement.repository.RoleRepo;
import employeeManagement.repository.UserRepo;
import employeeManagement.security.EmployeeUserDetails;
import employeeManagement.service.UserService;

@Service
public class UserServiceImpl implements UserDetailsService, UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private RoleRepo roleRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.getByUsername(username);
		if(user == null)
			throw new UsernameNotFoundException("Bad credentials!");
		return new EmployeeUserDetails(user);
	}

	@Override
	public List<User> showUsers() {
		return userRepo.findAll();
	}

	@Override
	public void saveUser(User user) {
		userRepo.save(user);
	}

	@Override
	public User findUserById(Integer id) {
		Optional<User> obj = userRepo.findById(id);
		User user = null;
		if (obj.isPresent())
			user = obj.get();
		else
			throw new IllegalArgumentException("Did not find user id - " + id);
		return user;
	}

	@Override
	public void deleteUser(User user) {
		userRepo.delete(user);		
	}
}