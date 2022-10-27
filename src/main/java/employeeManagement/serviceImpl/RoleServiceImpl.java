package employeeManagement.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import employeeManagement.entity.Role;
import employeeManagement.repository.RoleRepo;
import employeeManagement.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepo roleRepo;
	
	@Override
	public List<Role> showRoles() {
		return roleRepo.findAll();
	}

	@Override
	public void saveRole(Role role) {
		roleRepo.save(role);
	}

	@Override
	public Role findRoleById(Integer id) {
		Optional<Role> obj = roleRepo.findById(id);
		Role role = null;
		if (obj.isPresent())
			role = obj.get();
		else
			throw new IllegalArgumentException("Did not find role id - " + id);
		return role;
	}

	@Override
	public void deleteRole(Role role) {
		roleRepo.delete(role);
	}
}