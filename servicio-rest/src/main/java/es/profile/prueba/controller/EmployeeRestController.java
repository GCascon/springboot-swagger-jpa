package es.profile.prueba.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import es.profile.prueba.model.ApiResponse;

import es.profile.prueba.model.Employee;
import es.profile.prueba.service.EmployeeService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class EmployeeRestController {

	@Autowired
	private EmployeeService employeeService;

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("/api/employees")
	public ApiResponse<List<Employee>> getEmployees() {
		List<Employee> employees = employeeService.retrieveEmployees();
		return new ApiResponse<>(HttpStatus.OK.value(), "User list fetched successfully.",employees);
		
	}
	
	@GetMapping("/api/employees/{employeeId}")
	public ApiResponse<Employee> getEmployee(@PathVariable(name = "employeeId") Long employeeId) {
		return new ApiResponse<>(HttpStatus.OK.value(), "User fetched successfully.",employeeService.getEmployee(employeeId));		
	}
	
	@GetMapping("/api/employees/salary/{salary}")
	public List<Employee> getEmployees(@PathVariable(name = "salary") Integer salary) {
		return employeeService.buscaEmployeePorSalario(salary);
	}

	@PostMapping("/api/employees")
	public ApiResponse<Employee> saveEmployee(@RequestBody Employee employee) {
		employeeService.saveEmployee(employee);
		System.out.println("Employee Saved Successfully:"+employee.toString());
		return new ApiResponse<>(HttpStatus.OK.value(), "User created successfully.",employee);
	}

	@DeleteMapping("/api/employees/{employeeId}")
	public ApiResponse<Void> deleteEmployee(@PathVariable(name = "employeeId") Long employeeId) {
		employeeService.deleteEmployee(employeeId);
		System.out.println("Employee Deleted Successfully");
		return new ApiResponse<>(HttpStatus.OK.value(), "User deleted successfully.", null);
	}

	@PutMapping("/api/employees/{employeeId}")
	public ApiResponse<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable(name = "employeeId") Long employeeId) {
		Employee emp = employeeService.getEmployee(employeeId);
		if (emp != null) {
			employeeService.updateEmployee(employee);
			Employee empMod = employeeService.getEmployee(employeeId);
			return new ApiResponse<>(HttpStatus.OK.value(), "User updated successfully.",empMod);
		}
		return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error while updating!",null);

	}

}
