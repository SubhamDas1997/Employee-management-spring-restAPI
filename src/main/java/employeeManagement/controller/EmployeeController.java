package employeeManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import employeeManagement.entity.Employee;
import employeeManagement.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping
	public Object getEmployeeByName(@RequestParam(required = false) String firstName) {
		if (firstName == null)
			return employeeService.showEmployees();
		return employeeService.findByFirstName(firstName);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)	
	public Employee addEmployee(@RequestBody Employee emp) {
		emp.setEmployeeId(0);
		employeeService.saveEmployee(emp);
		return emp;
	}

	@GetMapping("/{employeeId}")
	public Employee getEmployeeById(@PathVariable Integer employeeId) {
		Employee emp = employeeService.findEmployeeById(employeeId);
		return emp;
	}

	@PutMapping
	public Employee updateEmployee(@RequestBody Employee emp) {
		employeeService.saveEmployee(emp);
		return emp;
	}

	@DeleteMapping("/{employeeId}")
	public String deleteEmployee(@PathVariable Integer employeeId) {
		Employee emp = employeeService.findEmployeeById(employeeId);
		employeeService.deleteEmployee(emp);
		return "Deleted employee ID - " + employeeId;
	}

	@GetMapping("/sort")
	public List<Employee> getEmployeesSortedByFirstName(Direction direction) {
		List<Employee> emp = employeeService.sortByFirstName(direction);
		return emp;
	}
}