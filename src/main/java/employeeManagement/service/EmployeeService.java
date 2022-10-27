package employeeManagement.service;

import java.util.List;

import org.springframework.data.domain.Sort.Direction;

import employeeManagement.entity.Employee;

public interface EmployeeService {

	public List<Employee> showEmployees();

	public void saveEmployee(Employee emp);

	public Employee findEmployeeById(Integer employeeId);

	public void deleteEmployee(Employee emp);

	public Employee findByFirstName(String firstName);

	public List<Employee> sortByFirstName(Direction direction);
}