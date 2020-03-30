package es.profile.prueba.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import es.profile.prueba.model.Employee;

@Repository
public class EmployeeRepositoryCustomImpl implements EmployeeRepositoryCustom {
	@PersistenceContext
	EntityManager entityManager;
	
	public List<Employee> buscaEmployeePorSalario(Integer salario) {
		Query query = entityManager.createQuery("SELECT e FROM Employee e WHERE salary=:salary");
		query.setParameter("salary",salario);
		List<Employee> empleados= query.getResultList();
		return empleados;
	}
}
