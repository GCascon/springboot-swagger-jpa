package es.profile.prueba.repository;

import java.util.List;

import es.profile.prueba.model.Employee;

public interface EmployeeRepositoryCustom {
	public List<Employee> buscaEmployeePorSalario(Integer salario);
}
