package employeeManagement.service;

import java.util.List;

import employeeManagement.entity.Role;

public interface RoleService {

	public List<Role> showRoles();
	
	public void saveRole(Role role);
	
	public Role findRoleById(Integer id);
	
	public void deleteRole(Role role);
}