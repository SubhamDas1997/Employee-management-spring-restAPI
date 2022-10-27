package employeeManagement.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import employeeManagement.entity.Employee;
import employeeManagement.repository.EmployeeRepo;
import employeeManagement.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Override
	public List<Employee> showEmployees() {
		return employeeRepo.findAll();
	}

	@Override
	public void saveEmployee(Employee emp) {
		employeeRepo.save(emp);
	}

	@Override
	public Employee findEmployeeById(Integer employeeId) {
		Optional<Employee> obj = employeeRepo.findById(employeeId);
		Employee emp = null;
		if (obj.isPresent())
			emp = obj.get();
		else
			throw new IllegalArgumentException("Did not find employee id - '" + employeeId + "'");
		return emp;
	}

	@Override
	public void deleteEmployee(Employee emp) {
		employeeRepo.delete(emp);
	}

	@Override
	public Employee findByFirstName(String firstName) {
		Optional<Employee> obj = employeeRepo.findByFirstName(firstName);
		Employee emp = null;
		if (obj.isPresent())
			emp = obj.get();
		else
			throw new IllegalArgumentException("Did not find employee with first name - '" + firstName + "'");
		return emp;
	}

	@Override
	public List<Employee> sortByFirstName(Direction direction) {
		return employeeRepo.findAll(Sort.by(direction, "firstName"));
	}
}