package employeeManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import employeeManagement.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

	public User getByUsername(String username);
}
