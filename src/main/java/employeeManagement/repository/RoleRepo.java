package employeeManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import employeeManagement.entity.Role;

public interface RoleRepo extends JpaRepository<Role, Integer> {

}