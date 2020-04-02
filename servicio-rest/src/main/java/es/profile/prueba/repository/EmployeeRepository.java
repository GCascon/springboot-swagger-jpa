package es.profile.prueba.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
import es.profile.prueba.model.Employee;
 
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>,EmployeeRepositoryCustom{
		
	public List<Employee> findEmployeesById(Long id);	
	
}