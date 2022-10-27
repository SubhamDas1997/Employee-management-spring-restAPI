package employeeManagement.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import employeeManagement.entity.Role;
import employeeManagement.entity.User;

public class EmployeeUserDetails implements UserDetails{

	private User user;
	public EmployeeUserDetails(User user) {
		this.user = user;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<Role> rolesList = user.getUserRoles();
		List<SimpleGrantedAuthority> grantedAuthority = new ArrayList<>();
		for(Role role:rolesList)
			grantedAuthority.add(new SimpleGrantedAuthority(role.getName()));
		return grantedAuthority;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}